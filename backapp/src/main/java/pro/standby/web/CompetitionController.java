package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Competition;
import pro.standby.model.dto.CompetitionDto;
import pro.standby.model.dto.result.CompetitionDetails;
import pro.standby.service.CompetitionService;
import pro.standby.web.mapper.CompetitionMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitionController {

  private final CompetitionService competitionService;
  private final CompetitionMapper competitionMapper;

  @ApiOperation(value = "Get all competitions",
      notes = "Get all competitions",
      response = List.class)
  @CrossOrigin
  @GetMapping(value = "/competition")
  public List<CompetitionDto> getAll() {
    log.info("GET request: CompetitionController: getAll");
    List<Competition> competitions = competitionService.getAll();
    List<CompetitionDto> competitionDtos =
        competitionMapper.competitions2Dtos(competitions);
    return competitionDtos;
  }

  @ApiOperation(value = "Get competition by id",
      notes = "Get competition by id",
      response = CompetitionDetails.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public CompetitionDetails getById(@PathVariable Long competitionId) {
    Competition competition = competitionService.findById(competitionId);
    CompetitionDetails competitionDetails = competitionMapper.competition2Details(competition);
    return competitionDetails;
  }

  @ApiOperation(value = "Create new competition",
      notes = "Create new competition",
      response = Competition.class)
  @CrossOrigin
  @PostMapping(value = "/competition", produces = MediaType.APPLICATION_JSON_VALUE)
  public Competition create(CompetitionDto competitionDto) {
    log.info("POST request: CompetitionController: create");
    Competition competition = competitionMapper.dto2competition(competitionDto);
    return competitionService.save(competition);
  }

//  @ApiOperation(value = "Get competition by id",
//      notes = "Get competition by id",
//      response = Competition.class)
//  @CrossOrigin
//  @GetMapping(value = "/competition/{competitionId}", produces = MediaType.APPLICATION_JSON_VALUE)
//  private Competition getById(@PathVariable Long competitionId) {
//    Competition competition = competitionService.getById(competitionId);
//    log.info("GET competition by id: " + competitionId);
//    return competition;
//  }

}
