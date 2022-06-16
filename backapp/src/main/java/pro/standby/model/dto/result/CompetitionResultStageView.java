package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CompetitionResultStageView {
    private String stageName;
    private Integer stageNumber;
    private List<CompetitionResultStageViewItem> stageViewResults;
}
