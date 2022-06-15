package pro.standby.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.standby.model.Competitor;
import pro.standby.repo.CompetitorRepository;

@Service
@RequiredArgsConstructor
public class CompetitorService {

  private final CompetitorRepository competitorRepository;

  public Competitor getById(Long competitorId) {
    Competitor competitor = competitorRepository.findById(competitorId)
        .orElseThrow(
            () -> new RuntimeException("There is no competitor with id: " + competitorId)
        );

    return competitor;
  }
}
