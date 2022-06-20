package pro.standby.model.dto.result;

import lombok.Builder;
import lombok.Data;
import pro.standby.model.Competition;

@Data
@Builder
public class CompetitionDetails {

  private Competition competition;
}
