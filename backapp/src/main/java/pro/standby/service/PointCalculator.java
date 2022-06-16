package pro.standby.service;

import org.springframework.data.util.Pair;

public interface PointCalculator {

  Pair<Integer, Integer> calculate(Integer paperTargetNumber, Integer steelTargetNumber);
}
