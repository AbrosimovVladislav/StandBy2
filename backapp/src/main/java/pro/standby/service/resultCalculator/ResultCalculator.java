package pro.standby.service.resultCalculator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pro.standby.model.Competition;
import pro.standby.model.Competitor;
import pro.standby.model.CompetitorStageResult;
import pro.standby.model.Person;
import pro.standby.model.Squad;
import pro.standby.model.dto.result.CompetitionResultOverallItem;
import pro.standby.service.CompetitorStageResultService;

@Component
@RequiredArgsConstructor
public class ResultCalculator {

  private final CompetitorStageResultService competitorStageResultService;

  public List<CompetitionResultOverallItem> calculateOverallResults(Competition competition) {
    //get results for each competitor
    Map<Competitor, List<CompetitorStageResult>> competitorsResults = competition.getSquads()
        .stream()
        .map(Squad::getCompetitors)
        .flatMap(List::stream)
        .collect(Collectors.toMap(
            competitor -> competitor,
            competitorStageResultService::findByCompetitor));

    //creating list of overallResultItem per competitor
    List<CompetitionResultOverallItem> results = competitorsResults.entrySet()
        .stream()
        .map(e -> Pair.of(e.getKey(), transformResultsToPoints(e.getValue())))
        .map(this::transformCompetitorAndPointsToOverallResultItem)
        .sorted(Comparator.comparing(CompetitionResultOverallItem::getPoints).reversed())
        .toList();

    //defining of champion
    CompetitionResultOverallItem championResult = results.get(0);
    Double championPoints = championResult.getPoints();
    championResult.setPercentage(100.00);
    championResult.setPlace(1);

    //setting places and percentages relatively to champion
    for (int i = 1; i < results.size(); i++) {
      CompetitionResultOverallItem currentResult = results.get(i);
      currentResult.setPlace(i + 1);
      currentResult.setPercentage((currentResult.getPoints() / championPoints) * 100);
    }

    return results;
  }

  private CompetitionResultOverallItem transformCompetitorAndPointsToOverallResultItem(
      Pair<Competitor, Double> pair) {
    Competitor competitor = pair.getFirst();
    Person person = competitor.getPerson();
    String firstName = person.getFirstName();
    String lastName = person.getLastName();
    return CompetitionResultOverallItem.builder()
        .points(pair.getSecond())
        .competitor(firstName + " " + lastName)
        .rank(person.getRank().toString())
        .gunType(competitor.getGunType().toString())
        .gunClass(competitor.getGunClass().toString())
        .region(person.getRegion().toString())
        .build();
  }

  private Double transformResultsToPoints(List<CompetitorStageResult> results) {
    return results.stream()
        .mapToDouble(result -> result.getHitFactor() * result.getStage().getMaximumPoints())
        .sum();
  }

}
