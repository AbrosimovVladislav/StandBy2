package pro.standby.model2.dto;

import java.util.Date;
import lombok.Data;
import pro.standby.model2.GunType;
import pro.standby.model2.Level;

@Data
public class CompetitionDto {

  private String  name;
  private String    startDate;
  private String    finishDate;
  private String  place;
  private String  organizer;
  private Integer price;
  private String  description;
  private Level level;
  private GunType gunType;
  private String  referee;
  private String  matchDirector;

}
