package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OverallResultItem {

  Integer place;
  Double percentage;
  Double points;
  String competitor;
  String rank;
  String gunType;
  String gunClass;
  String region;
}

