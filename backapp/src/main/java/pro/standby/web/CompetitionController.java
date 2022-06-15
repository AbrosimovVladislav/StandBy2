package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Competition;
import pro.standby.service.CompetitionService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitionController {

  private final CompetitionService competitionService;

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

}
