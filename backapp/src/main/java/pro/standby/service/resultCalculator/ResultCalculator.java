package pro.standby.service.resultCalculator;

import java.util.ArrayList;
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
import pro.standby.model.dto.result.CompetitorViewResult;
import pro.standby.model.dto.result.CompetitorViewResultItem;
import pro.standby.model.dto.result.OverallResultItem;
import pro.standby.model.dto.result.StageViewResult;
import pro.standby.model.dto.result.StageViewResultItem;
import pro.standby.service.CompetitorStageResultService;
import pro.standby.service.pointCalculator.PointCalculator;

@Component
@RequiredArgsConstructor
public class ResultCalculator {

  private final CompetitorStageResultService competitorStageResultService;
  private final PointCalculator pointCalculator;

  public List<CompetitorViewResult> calculateCompetitorViewResults(Competition competition) {
    List<CompetitorViewResult> results = new ArrayList<>();
    //get results for each competitor
    Map<Competitor, List<CompetitorStageResult>> competitorsResults = getCompetitorsResults(
        competition);

    for (var entry : competitorsResults.entrySet()) {
      //get all needed data about competitor and person
      Competitor competitor = entry.getKey();
      Person person = competitor.getPerson();
      //get all needed data about results
      var competitorResults = entry.getValue();

      //create result object and set info about competitor
      CompetitorViewResult competitorViewResult = CompetitorViewResult.builder()
          .competitor(person.getFirstName() + " " + person.getLastName())
          .rank(person.getRank().toString())
          .gunType(competitor.getGunType().toString())
          .gunClass(competitor.getGunClass().toString())
          .region(person.getRegion().toString()).build();

      List<CompetitorViewResultItem> competitorViewResults = new ArrayList<>();
      for (var stageCompetitorResult : competitorResults) {
        Integer points = pointCalculator.calculatePoints(
            stageCompetitorResult.getAlphas(), stageCompetitorResult.getCharlies(),
            stageCompetitorResult.getDeltas(), stageCompetitorResult.getMisses(),
            stageCompetitorResult.getNoShoots(), stageCompetitorResult.getProcedurals()
        );
        Double hitFactor = pointCalculator.calculateResult(points, stageCompetitorResult.getTime());
        CompetitorViewResultItem competitorViewResultItem = CompetitorViewResultItem.builder()
            .stageNumber(stageCompetitorResult.getStage().getNumber())
            .stageName(stageCompetitorResult.getStage().getName())
            .points(points)
            .hitFactor(hitFactor)
            .resultPoints(stageCompetitorResult.getStage().getMaximumPoints() * hitFactor).build();

        //ToDo не можем вытащить инфу по месту и процентам тут
        //ToDo придумать что и как хранить тут
        competitorViewResultItem.setPlace(null);
        competitorViewResultItem.setPercentage(null);

        competitorViewResults.add(competitorViewResultItem);
      }
      competitorViewResult.setCompetitorViewResults(competitorViewResults);
      results.add(competitorViewResult);
    }

    return results;
  }

  public List<StageViewResult> calculateStageViewResults(Competition competition) {
    List<StageViewResult> competitionResultStageViews = new ArrayList<>();

    for (var stage : competition.getStages()) {
      StageViewResult competitionResultStageView = StageViewResult.builder()
          .stageName(stage.getName())
          .stageNumber(stage.getNumber())
          .build();
      List<CompetitorStageResult> stageResults = competitorStageResultService.findByStage(stage);

      List<StageViewResultItem> stageViewResultItems = new ArrayList<>();

      for (var result : stageResults) {
        Integer points = pointCalculator.calculatePoints(
            result.getAlphas(), result.getCharlies(),
            result.getDeltas(), result.getMisses(),
            result.getNoShoots(), result.getProcedurals()
        );
        Double hitFactor = pointCalculator.calculateResult(points, result.getTime());
        Competitor competitor = result.getCompetitor();
        Person person = competitor.getPerson();

        stageViewResultItems.add(StageViewResultItem.builder()
            .points(points)
            .hitFactor(hitFactor)
            .resultPoints(stage.getMaximumPoints() * hitFactor)
            .competitor(person.getFirstName() + " " + person.getLastName())
            .rank(person.getRank().toString())
            .gunType(competitor.getGunType().toString())
            .gunClass(competitor.getGunClass().toString())
            .region(person.getRegion().toString())
            .build());
      }

      stageViewResultItems = stageViewResultItems.stream()
          .sorted(Comparator.comparing(StageViewResultItem::getPoints).reversed())
          .toList();

      //defining of champion
      StageViewResultItem championResult = stageViewResultItems.get(0);
      Integer championPoints = championResult.getPoints();
      championResult.setPercentage(100.00);
      championResult.setPlace(1);

      //setting places and percentages relatively to champion
      for (int i = 1; i < stageViewResultItems.size(); i++) {
        StageViewResultItem currentResult = stageViewResultItems.get(i);
        currentResult.setPlace(i + 1);
        currentResult.setPercentage(100.00 * currentResult.getPoints() / championPoints);
      }

      competitionResultStageView.setStageViewResults(stageViewResultItems);
      competitionResultStageViews.add(competitionResultStageView);
    }

    return competitionResultStageViews.stream()
        .sorted(Comparator.comparing(StageViewResult::getStageNumber))
        .toList();
  }

  public List<OverallResultItem> calculateOverallResults(Competition competition) {
    //get results for each competitor
    Map<Competitor, List<CompetitorStageResult>> competitorsResults = getCompetitorsResults(
        competition);

    //creating list of overallResultItem per competitor
    List<OverallResultItem> results = competitorsResults.entrySet()
        .stream()
        .map(e -> Pair.of(e.getKey(), transformResultsToPoints(e.getValue())))
        .map(this::transformCompetitorAndPointsToOverallResultItem)
        .sorted(Comparator.comparing(OverallResultItem::getPoints).reversed())
        .toList();

    //defining of champion
    OverallResultItem championResult = results.get(0);
    Double championPoints = championResult.getPoints();
    championResult.setPercentage(100.00);
    championResult.setPlace(1);

    //setting places and percentages relatively to champion
    for (int i = 1; i < results.size(); i++) {
      OverallResultItem currentResult = results.get(i);
      currentResult.setPlace(i + 1);
      currentResult.setPercentage((currentResult.getPoints() / championPoints) * 100);
    }

    return results;
  }

  private Map<Competitor, List<CompetitorStageResult>> getCompetitorsResults(
      Competition competition) {
    return competition.getSquads()
        .stream()
        .map(Squad::getCompetitors)
        .flatMap(List::stream)
        .collect(Collectors.toMap(
            competitor -> competitor,
            competitorStageResultService::findByCompetitor));
  }

  private OverallResultItem transformCompetitorAndPointsToOverallResultItem(
      Pair<Competitor, Double> pair) {
    Competitor competitor = pair.getFirst();
    Person person = competitor.getPerson();
    String firstName = person.getFirstName();
    String lastName = person.getLastName();
    return OverallResultItem.builder()
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
