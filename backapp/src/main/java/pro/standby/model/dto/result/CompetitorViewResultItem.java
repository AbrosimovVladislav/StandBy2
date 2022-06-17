package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompetitorViewResultItem {

  Integer stageNumber;
  String stageName;
  Integer place;
  Double percentage;
  Integer points;
  Double hitFactor;
  Double resultPoints;
}
