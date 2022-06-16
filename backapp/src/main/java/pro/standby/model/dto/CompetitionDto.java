package pro.standby.model.dto;

import lombok.Data;
import pro.standby.model.GunType;
import pro.standby.model.Level;

@Data
public class CompetitionDto {

  private String name;
  private String startDate;
  private String finishDate;
  private String place;
  private String organizer;
  private Integer price;
  private String description;
  private Level level;
  private GunType gunType;
  private String referee;
  private String matchDirector;

}
