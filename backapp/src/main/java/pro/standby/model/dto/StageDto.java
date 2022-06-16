package pro.standby.model.dto;

import lombok.Data;

@Data
public class StageDto {

  private String competitionName;
  private String name;
  private Integer number;
  private Integer paperTargetsNumber;
  private Integer steelTargetsNumber;
  private Integer noShootsNumber;

}
