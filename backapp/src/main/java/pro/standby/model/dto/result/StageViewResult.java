package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StageViewResult {
    private String stageName;
    private Integer stageNumber;
    private List<StageViewResultItem> stageViewResults;
}
