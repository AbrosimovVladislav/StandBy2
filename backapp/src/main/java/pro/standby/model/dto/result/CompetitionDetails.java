package pro.standby.model.dto.result;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import pro.standby.model.Competition;

@Data
@Builder
public class CompetitionDetails {

  private Competition competition;
  private List<CompetitionResultOverallItem> overallResults;
  private List<CompetitionResultStageViewItem> stageViewResults;
  private List<CompetitionResultCompetitorViewItem> competitorViewResults;
}
