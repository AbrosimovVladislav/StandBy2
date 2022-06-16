package pro.standby.model.dto;

import lombok.Data;
import pro.standby.model.GunClass;
import pro.standby.model.GunType;

@Data
public class CompetitorDto {

  private String personName;
  private String squadName;
  private GunType gunType;
  private GunClass gunClass;

}
