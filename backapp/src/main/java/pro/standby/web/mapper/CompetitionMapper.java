package pro.standby.web.mapper;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.Competition;
import pro.standby.model.dto.CompetitionDto;
import pro.standby.service.PersonService;
import pro.standby.service.RefereeService;

@Component
@RequiredArgsConstructor
public class CompetitionMapper {

  private final PersonService personService;
  private final RefereeService refereeService;

  public Competition dto2competition(CompetitionDto competitionDto) {
    String refFirstName = competitionDto.getReferee().split(" ")[0];
    String refLastName = competitionDto.getReferee().split(" ")[1];
    String matchDirectorFirstName = competitionDto.getMatchDirector().split(" ")[0];
    String matchDirectorLastName = competitionDto.getMatchDirector().split(" ")[1];

    return new Competition()
        .setName(competitionDto.getName())
        .setStartDate(prepareDate(competitionDto.getStartDate()))
        .setFinishDate(prepareDate(competitionDto.getFinishDate()))
        .setPlace(competitionDto.getPlace())
        .setOrganizer(competitionDto.getOrganizer())
        .setPrice(competitionDto.getPrice())
        .setDescription(competitionDto.getDescription())
        .setLevel(competitionDto.getLevel())
        .setGunType(competitionDto.getGunType())
        .setReferee(refereeService.findByName(refFirstName, refLastName))
        .setMatchDirector(personService.findByName(matchDirectorFirstName, matchDirectorLastName));
  }

  /**
   * 16.06.2022
   **/
  private Date prepareDate(String date) {
    String[] splited = date.split("\\.");
    return new Date(
        Integer.parseInt(splited[2]),
        Integer.parseInt(splited[1]),
        Integer.parseInt(splited[0])
    );
  }

}
