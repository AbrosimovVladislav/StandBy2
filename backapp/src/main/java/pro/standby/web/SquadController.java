package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Squad;
import pro.standby.model.dto.SquadDto;
import pro.standby.service.domain.SquadService;
import pro.standby.web.mapper.SquadMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SquadController {

  private final SquadService squadService;
  private final SquadMapper squadMapper;

  @ApiOperation(value = "Create new Squad",
      notes = "Create new Squad",
      response = Squad.class)
  @CrossOrigin
  @PostMapping(value = "/squad", produces = MediaType.APPLICATION_JSON_VALUE)
  public Squad create(SquadDto dto) {
    log.info("POST request: SquadController: create");
    Squad squad = squadMapper.dto2Squad(dto);
    return squadService.save(squad);
  }

}
