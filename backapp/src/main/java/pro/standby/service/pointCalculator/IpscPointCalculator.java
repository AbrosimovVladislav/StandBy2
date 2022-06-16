package pro.standby.service.pointCalculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IpscPointCalculator implements PointCalculator {

  private final Integer ALPHA_FACTOR = 5;
  private final Integer CHARLIE_FACTOR = 3;
  private final Integer DELTA_FACTOR = 1;
  private final Integer MISS_PENALTY = 10;
  private final Integer NO_SHOOT_PENALTY = 10;
  private final Integer PROCEDURAL_PENALTY = 15;

  @Override
  public Pair<Integer, Integer> calculateMaximumShotsAndPoints(Integer paperTargetNumber,
      Integer steelTargetNumber) {
    int numberOfShots = paperTargetNumber * 2 + steelTargetNumber;
    return Pair.of(numberOfShots, numberOfShots * 5);
  }

  @Override
  public Integer calculatePoints(Integer alphas, Integer charlies, Integer deltas, Integer misses,
      Integer noShoots, Integer procedurals) {
    Integer receivedPoints =
        alphas * ALPHA_FACTOR + charlies * CHARLIE_FACTOR + deltas * DELTA_FACTOR;
    Integer penaltyPoints =
        misses * MISS_PENALTY + noShoots * NO_SHOOT_PENALTY + procedurals * PROCEDURAL_PENALTY;
    return receivedPoints - penaltyPoints;
  }

  @Override
  public Double calculateResult(Integer points, Double time) {
    return points / time;
  }

}
