package pro.standby.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IpscPointCalculator implements PointCalculator {

  @Override
  public Pair<Integer, Integer> calculate(Integer paperTargetNumber, Integer steelTargetNumber) {
    int numberOfShots = paperTargetNumber * 2 + steelTargetNumber;
    return Pair.of(numberOfShots, numberOfShots * 5);
  }
}
