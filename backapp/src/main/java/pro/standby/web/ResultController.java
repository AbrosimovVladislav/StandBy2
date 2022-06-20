package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ResultController {

  @ApiOperation(value = "",
      notes = "",
      response = Object.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/overall", produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getOverallResults(@PathVariable Long competitionId) {
    log.info("GET_OVERALL_RESULTS");
    log.info("Id: " + competitionId);

    return null;
  }

  @ApiOperation(value = "",
      notes = "",
      response = Object.class)
  @CrossOrigin
  @GetMapping(value = "/competition/{competitionId}/stageView", produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getStageViewResults(@PathVariable Long competitionId) {
    log.info("GET_STAGE_VIEW_RESULTS");
    log.info("Id: " + competitionId);

    return null;
  }

}
