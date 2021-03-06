package pro.standby.web.mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pro.standby.model.Stage;
import pro.standby.model.dto.StageDto;
import pro.standby.service.domain.CompetitionService;
import pro.standby.service.pointCalculator.PointCalculator;

@Slf4j
@Component
@RequiredArgsConstructor
public class StageMapper {

  private final CompetitionService competitionService;
  private final PointCalculator pointCalculator;

  public Stage dto2Stage(StageDto dto) {
    var shotsAndPoints = pointCalculator.calculateMaximumShotsAndPoints(
        dto.getPaperTargetsNumber(),
        dto.getSteelTargetsNumber()
    );
    return new Stage()
        .setCompetition(competitionService.findByName(dto.getCompetitionName()))
        .setName(dto.getName())
        .setNumber(dto.getNumber())
        .setPaperTargetsNumber(dto.getPaperTargetsNumber())
        .setSteelTargetsNumber(dto.getSteelTargetsNumber())
        .setNoShootsNumber(dto.getNoShootsNumber())
        .setMaximumShots(shotsAndPoints.getFirst())
        .setMaximumPoints(shotsAndPoints.getSecond());
  }

}
