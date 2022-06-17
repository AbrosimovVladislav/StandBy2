package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StageViewResultItem {

    Integer place; //-
    Double percentage; //-
    Integer points; //+
    Double hitFactor; //+
    Double resultPoints; //+
    String competitor; //+
    String rank;//+
    String gunType;//+
    String gunClass;//+
    String region;//+

}
