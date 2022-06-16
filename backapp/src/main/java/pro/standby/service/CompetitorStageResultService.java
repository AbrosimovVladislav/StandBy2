package pro.standby.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Competitor;
import pro.standby.model.CompetitorStageResult;
import pro.standby.model.Stage;
import pro.standby.repo.CompetitorStageResultRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompetitorStageResultService {

  private final CompetitorStageResultRepository competitorStageResultRepository;

  public Optional<CompetitorStageResult> findByStageAndCompetitor(Stage stage,
      Competitor competitor) {
    return competitorStageResultRepository.findByStageAndCompetitor(stage, competitor);
  }

  public CompetitorStageResult save(CompetitorStageResult competitorStageResult) {
    return competitorStageResultRepository.save(competitorStageResult);
  }

  public List<CompetitorStageResult> findByCompetitor(Competitor competitor) {
    return competitorStageResultRepository.findByCompetitor(competitor);
  }

  public List<CompetitorStageResult> findByStages(Set<Stage> stages) {
    return competitorStageResultRepository.findByStageIds(
        stages.stream().map(Stage::getStageId).toList()
    );
  }
}
