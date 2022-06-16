package pro.standby.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.Squad;
import pro.standby.model.dto.SquadDto;
import pro.standby.service.CompetitionService;

@Component
@RequiredArgsConstructor
public class SquadMapper {

  private final CompetitionService competitionService;

  public Squad dto2Squad(SquadDto dto) {
    return new Squad()
        .setName(dto.getName())
        .setCompetition(competitionService.findByName(dto.getCompetitionName()));
  }

}
