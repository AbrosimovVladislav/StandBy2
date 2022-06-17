package pro.standby.model.dto.result;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import pro.standby.model.Competition;

@Data
@Builder
public class CompetitionDetails {

  private Competition competition;
  private List<OverallResultItem> overallResults;
  private List<StageViewResult> stageViewResults;
  private List<CompetitorViewResultItem> competitorViewResults;
}
