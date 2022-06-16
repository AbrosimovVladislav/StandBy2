package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.CompetitorStageResult;
import pro.standby.model.dto.CompetitorStageResultDto;
import pro.standby.service.CompetitorStageResultService;
import pro.standby.web.mapper.CompetitorStageResultMapper;
import pro.standby.web.validator.CompetitorStageResultValidator;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompetitorStageResultController {

  private final CompetitorStageResultService competitorStageResultService;
  private final CompetitorStageResultMapper competitorStageResultMapper;
  private final CompetitorStageResultValidator validator;

  @ApiOperation(value = "Add competitorStageResult",
      notes = "Add competitorStageResult",
      response = CompetitorStageResult.class)
  @CrossOrigin
  @PostMapping(value = "/competitorStageResult", produces = MediaType.APPLICATION_JSON_VALUE)
  public CompetitorStageResult create(CompetitorStageResultDto dto) {
    log.info("POST request: CompetitorStageResultController: create");
    CompetitorStageResult competitorStageResult =
        competitorStageResultMapper.dto2CompetitorStageResult(dto);
    validator.validate(competitorStageResult);
    return competitorStageResultService.save(competitorStageResult);
  }

}
