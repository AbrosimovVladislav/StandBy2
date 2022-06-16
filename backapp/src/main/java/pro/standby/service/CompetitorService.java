package pro.standby.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Competitor;
import pro.standby.repo.CompetitorRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompetitorService {

  private final CompetitorRepository competitorRepository;

  public Competitor save(Competitor competitor) {
    return competitorRepository.save(competitor);
  }

}
