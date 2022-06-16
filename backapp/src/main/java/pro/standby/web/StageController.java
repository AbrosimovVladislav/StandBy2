package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Stage;
import pro.standby.model.dto.StageDto;
import pro.standby.service.StageService;
import pro.standby.web.mapper.StageMapper;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StageController {

  private final StageService stageService;
  private final StageMapper stageMapper;

  @ApiOperation(value = "Create new Stage",
      notes = "Create new Stage",
      response = Stage.class)
  @CrossOrigin
  @PostMapping(value = "/stage", produces = MediaType.APPLICATION_JSON_VALUE)
  public Stage create(StageDto dto) {
    log.info("POST request: StageController: create");
    Stage stage = stageMapper.dto2Stage(dto);
    return stageService.save(stage);
  }

}
