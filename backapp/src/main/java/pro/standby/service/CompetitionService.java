package pro.standby.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.standby.model.Competition;
import pro.standby.model.results.ResultItem;
import pro.standby.model.results.StageResult;
import pro.standby.model.results.StageResultItem;
import pro.standby.repo.CompetitionRepository;

@Service
@RequiredArgsConstructor
public class CompetitionService {

  private final CompetitionRepository competitionRepository;

  public List<Competition> getAll() {
    return competitionRepository.findAll();
  }

  public Competition getById(Long competitionId) {
    Competition competition = competitionRepository.findById(competitionId)
        .orElseThrow(
            () -> new RuntimeException("There is no competition with id: " + competitionId)
        );

    return prepareCompetitionBeforeReturn(competition);
  }

  private Competition prepareCompetitionBeforeReturn(Competition competition) {
    List<ResultItem> resultItems = competition.getResult().getResultItems();
    resultItems.sort(Comparator.comparing(ResultItem::getPlace));
    competition.getResult().setResultItems(resultItems);
    return competition;
  }

  public List<StageResult> getStageResultsByCompetitionIdAndCompetitorId(Long competitionId,
      Long competitorId) {
    List<StageResult> stageResults = Collections.emptyList();
    Competition competition = getById(competitionId);
    Optional<ResultItem> resultItemOpt = competition.getResult().getResultItems().stream()
        .filter(resultItem -> Objects.equals(resultItem.getCompetitor().getCompetitorId(),
            competitorId)).findFirst();
    if (resultItemOpt.isPresent()) {
      stageResults = resultItemOpt.get().getStageResults();
    }
    return prepareStageResultsBeforeReturn(stageResults);
  }

  private List<StageResult> prepareStageResultsBeforeReturn(List<StageResult> stageResults) {
    List<StageResultItem> stageResultItems = stageResults.get(0).getStageResultItems();
    stageResultItems.sort(Comparator.comparing(StageResultItem::getStageNumber));
    stageResults.get(0).setStageResultItems(stageResultItems);
    return stageResults;
  }
}
