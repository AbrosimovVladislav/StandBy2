package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Competitor;
import pro.standby.model.dto.CompetitorDto;
import pro.standby.service.domain.CompetitorService;
import pro.standby.web.mapper.CompetitorMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitorController {

  private final CompetitorService competitorService;
  private final CompetitorMapper competitorMapper;

  @ApiOperation(value = "Create new competitor",
      notes = "Create new competitor",
      response = Competitor.class)
  @CrossOrigin
  @PostMapping(value = "/competitor", produces = MediaType.APPLICATION_JSON_VALUE)
  public Competitor create(CompetitorDto dto) {
    log.info("POST request: CompetitionController: create");
    Competitor competitor = competitorMapper.dto2Competitor(dto);
    return competitorService.save(competitor);
  }

}
