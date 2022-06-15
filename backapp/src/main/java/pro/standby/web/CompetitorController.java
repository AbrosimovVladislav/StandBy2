package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Competitor;
import pro.standby.service.CompetitorService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitorController {

  private final CompetitorService competitorService;

  @ApiOperation(value = "Get competitor by id",
      notes = "Get competitor by id",
      response = Competitor.class)
  @CrossOrigin
  @GetMapping(value = "/competitor/{competitorId}", produces = MediaType.APPLICATION_JSON_VALUE)
  private Competitor getById(@PathVariable Long competitorId) {
    Competitor competitor = competitorService.getById(competitorId);
    log.info("GET competitor by id: " + competitorId);
    return competitor;
  }

}
