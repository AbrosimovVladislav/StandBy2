package pro.standby.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.standby.model.Competition;
import pro.standby.repo.CompetitionRepository;

@Service
@RequiredArgsConstructor
public class CompetitionService {

  private final CompetitionRepository competitionRepository;

  public List<Competition> getAll() {
    return competitionRepository.findAll();
  }

  public Competition getById(Long competitionId) {
    return competitionRepository.findById(competitionId)
        .orElseThrow(
            () -> new RuntimeException("There is no competition with id: " + competitionId)
        );
  }
}
