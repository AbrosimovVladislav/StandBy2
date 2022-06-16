package pro.standby.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pro.standby.model.Competitor;
import pro.standby.model.CompetitorStageResult;
import pro.standby.model.Stage;

public interface CompetitorStageResultRepository extends
    JpaRepository<CompetitorStageResult, Long> {

  List<CompetitorStageResult> findByCompetitor(Competitor competitor);

  Optional<CompetitorStageResult> findByStageAndCompetitor(Stage stage, Competitor competitor);

  @Query(
      value = "SELECT DISTINCT cst " +
          "FROM competitor_stage_result cst " +
          "WHERE cst.stage_id IN ?1",
      nativeQuery = true)
  List<CompetitorStageResult> findByStageIds(List<Long> stageIds);
}
