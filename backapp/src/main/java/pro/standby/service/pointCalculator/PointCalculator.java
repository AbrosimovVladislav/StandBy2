package pro.standby.service.pointCalculator;

import org.springframework.data.util.Pair;

public interface PointCalculator {

  Pair<Integer, Integer> calculateMaximumShotsAndPoints(Integer paperTargetNumber,
      Integer steelTargetNumber);

  Integer calculatePoints(
      Integer alphas,
      Integer charlies,
      Integer deltas,
      Integer misses,
      Integer noShoots,
      Integer procedurals
  );

  Double calculateResult(Integer points, Double time);
}
