package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Competition;
import pro.standby.model.results.StageResult;
import pro.standby.service.CompetitionService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitionController {

  private final CompetitionService competitionService;

  @ApiOperation(value = "Get competition by id",
      notes = "Get competition by id",
      response = Competition.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/competitor/{competitorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  private List<StageResult> getStageResultsByCompetitionIdAndCompetitorId(
      @PathVariable Long competitionId, @PathVariable Long competitorId) {
    List<StageResult> stageResults = competitionService
        .getStageResultsByCompetitionIdAndCompetitorId(competitionId, competitorId);
    log.info("GET stageResultsByCompetitionIdAndCompetitorId by competitionId: "
        + competitionId + " and competitorId: " + competitorId);
    return stageResults;
  }

  @ApiOperation(value = "Get all competitions",
      notes = "Get all competitions",
      response = List.class)
  @CrossOrigin
  @GetMapping(value = "/competition")
  private List<Competition> getAll() {
    List<Competition> competitions = competitionService.getAll();
    log.info("GET all competitions");
    return competitions;
  }

  @ApiOperation(value = "Get competition by id",
      notes = "Get competition by id",
      response = Competition.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}", produces = MediaType.APPLICATION_JSON_VALUE)
  private Competition getById(@PathVariable Long competitionId) {
    Competition competition = competitionService.getById(competitionId);
    log.info("GET competition by id: " + competitionId);
    return competition;
  }

}
