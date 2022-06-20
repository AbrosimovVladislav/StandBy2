package pro.standby.web.validator;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pro.standby.model.CompetitorStageResult;
import pro.standby.service.domain.CompetitorStageResultService;

//TODO We need a lot of validations here
//TODO Validation for steel and paper how much A C D we can have
//TODO Validation IF shoots less than targets, miss automatically
@Component
@RequiredArgsConstructor
public class CompetitorStageResultValidator {

  private final CompetitorStageResultService competitorStageResultService;

  public void validate(CompetitorStageResult result) {
    isThisResultAlreadyExists(result);
    shotCountMustBeLessOrEqualsThanMaximumShots(result);
  }

  private void isThisResultAlreadyExists(CompetitorStageResult result) {
    Optional<CompetitorStageResult> opt = competitorStageResultService.findByStageAndCompetitor(
        result.getStage(), result.getCompetitor());
    if (opt.isPresent()) {
      throw new RuntimeException("Results for this competitor and stage already exists");
    }
  }

  private void shotCountMustBeLessOrEqualsThanMaximumShots(CompetitorStageResult result) {
    Integer maximumShots = result.getStage().getMaximumShots();
    Integer shotCount = result.getAlphas() + result.getCharlies() + result.getDeltas();
    if (shotCount > maximumShots) {
      throw new RuntimeException(
          "Shot count more than maximum shots on stage: " + result.getStage().getName());
    }
  }

}
