package pro.standby.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.Competitor;
import pro.standby.model.dto.CompetitorDto;
import pro.standby.service.PersonService;
import pro.standby.service.SquadService;

@Component
@RequiredArgsConstructor
public class CompetitorMapper {

  private final PersonService personService;
  private final SquadService squadService;

  public Competitor dto2Competitor(CompetitorDto dto) {
    String firstName = dto.getPersonName().split(" ")[0];
    String lastName = dto.getPersonName().split(" ")[1];
    return new Competitor()
        .setPerson(personService.findByName(firstName, lastName))
        .setSquad(squadService.findByName(dto.getSquadName()))
        .setGunType(dto.getGunType())
        .setGunClass(dto.getGunClass());
  }

}
