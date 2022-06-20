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
import pro.standby.model.dto.result.CompetitorViewResult;
import pro.standby.model.dto.result.OverallResultItem;
import pro.standby.model.dto.result.StageViewResult;
import pro.standby.service.ResultService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ResultController {

  private final ResultService resultService;

  @ApiOperation(value = "",
      notes = "",
      response = List.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/overall", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<OverallResultItem> getOverallResults(@PathVariable Long competitionId) {
    log.info("GET OVERALL RESULTS for ID: " + competitionId);
    List<OverallResultItem> overallResults = resultService.getOverallResultsById(
        competitionId);
    return overallResults;
  }

  @ApiOperation(value = "",
      notes = "",
      response = List.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/stageView", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<StageViewResult> getStageViewResults(@PathVariable Long competitionId) {
    log.info("GET STAGE VIEW RESULTS for ID: " + competitionId);
    List<StageViewResult> stageViewResults = resultService.getStageViewResultsById(competitionId);
    return stageViewResults;
  }

  @ApiOperation(value = "",
      notes = "",
      response = List.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/competitor", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CompetitorViewResult> getCompetitorViewResults(@PathVariable Long competitionId) {
    log.info("GET COMPETITOR VIEW RESULTS for ID: " + competitionId);
    List<CompetitorViewResult> competitorViewResults = resultService.getCompetitorViewResultsById(
        competitionId);
    return competitorViewResults;
  }

}
