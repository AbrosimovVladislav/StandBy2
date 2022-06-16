package pro.standby.service.resultCalculator;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import pro.standby.model.*;
import pro.standby.model.dto.result.CompetitionResultOverallItem;
import pro.standby.model.dto.result.CompetitionResultStageView;
import pro.standby.model.dto.result.CompetitionResultStageViewItem;
import pro.standby.service.CompetitorStageResultService;
import pro.standby.service.pointCalculator.PointCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ResultCalculator {

    private final CompetitorStageResultService competitorStageResultService;
    private final PointCalculator pointCalculator;

    public List<CompetitionResultStageView> calculateStageViewResults(Competition competition) {
        List<CompetitionResultStageView> competitionResultStageViews = new ArrayList<>();

        for (var stage : competition.getStages()) {
            CompetitionResultStageView competitionResultStageView = CompetitionResultStageView.builder()
                    .stageName(stage.getName())
                    .stageNumber(stage.getNumber())
                    .build();
            List<CompetitorStageResult> stageResults = competitorStageResultService.findByStage(stage);


            List<CompetitionResultStageViewItem> stageViewResultItems = new ArrayList<>();

            for (var result : stageResults) {
                Integer points = pointCalculator.calculatePoints(
                        result.getAlphas(), result.getCharlies(),
                        result.getDeltas(), result.getMisses(),
                        result.getNoShoots(), result.getProcedurals()
                );
                Double hitFactor = pointCalculator.calculateResult(points, result.getTime());
                Competitor competitor = result.getCompetitor();
                Person person = competitor.getPerson();

                stageViewResultItems.add(CompetitionResultStageViewItem.builder()
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
                    .sorted(Comparator.comparing(CompetitionResultStageViewItem::getPoints).reversed())
                    .toList();

            //defining of champion
            CompetitionResultStageViewItem championResult = stageViewResultItems.get(0);
            Integer championPoints = championResult.getPoints();
            championResult.setPercentage(100.00);
            championResult.setPlace(1);

            //setting places and percentages relatively to champion
            for (int i = 1; i < stageViewResultItems.size(); i++) {
                CompetitionResultStageViewItem currentResult = stageViewResultItems.get(i);
                currentResult.setPlace(i + 1);
                currentResult.setPercentage((double) ((currentResult.getPoints() / championPoints) * 100));
            }

            competitionResultStageView.setStageViewResults(stageViewResultItems);
            competitionResultStageViews.add(competitionResultStageView);
        }


        return competitionResultStageViews;
    }

    public List<CompetitionResultOverallItem> calculateOverallResults(Competition competition) {
        //get results for each competitor
        Map<Competitor, List<CompetitorStageResult>> competitorsResults = getCompetitorsResults(competition);

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

    private Map<Competitor, List<CompetitorStageResult>> getCompetitorsResults(Competition competition) {
        return competition.getSquads()
                .stream()
                .map(Squad::getCompetitors)
                .flatMap(List::stream)
                .collect(Collectors.toMap(
                        competitor -> competitor,
                        competitorStageResultService::findByCompetitor));
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
