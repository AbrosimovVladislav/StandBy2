package pro.standby.model.dto.result;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompetitorViewResult {

  private String competitor;
  private String rank;
  private String gunType;
  private String gunClass;
  private String region;
  private List<CompetitorViewResultItem> competitorViewResults;
}
