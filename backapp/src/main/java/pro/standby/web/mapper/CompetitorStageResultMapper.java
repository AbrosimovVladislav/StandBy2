package pro.standby.web.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.CompetitorStageResult;
import pro.standby.model.dto.CompetitorStageResultDto;
import pro.standby.service.CompetitorService;
import pro.standby.service.pointCalculator.PointCalculator;
import pro.standby.service.StageService;

@Component
@RequiredArgsConstructor
public class CompetitorStageResultMapper {

  private final StageService stageService;
  private final CompetitorService competitorService;
  private final PointCalculator pointCalculator;

  public CompetitorStageResult dto2CompetitorStageResult(CompetitorStageResultDto dto) {
    Integer points = pointCalculator.calculatePoints(
        dto.getAlphas(),
        dto.getCharlies(),
        dto.getDeltas(),
        dto.getMisses(),
        dto.getNoShoots(),
        dto.getProcedurals()
    );
    Double hitFactor = pointCalculator.calculateResult(points, dto.getTime());
    return new CompetitorStageResult()
        .setStage(stageService.findByName(dto.getStageName()))
        .setCompetitor(competitorService.findByName(dto.getCompetitorName()))
        .setAlphas(dto.getAlphas())
        .setCharlies(dto.getCharlies())
        .setDeltas(dto.getDeltas())
        .setMisses(dto.getMisses())
        .setNoShoots(dto.getNoShoots())
        .setProcedurals(dto.getProcedurals())
        .setTime(dto.getTime())
        .setPoints(points)
        .setHitFactor(hitFactor);
  }

}
