package pro.standby.service;

import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.standby.model.Competition;
import pro.standby.model.ResultItem;
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
}
