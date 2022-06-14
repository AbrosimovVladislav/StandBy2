package pro.standby.service;

import pro.standby.model.Competition;
import pro.standby.repo.CompetitionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompetitionService {

  private final CompetitionRepository competitionRepository;

  public List<Competition> getAll() {
    return competitionRepository.findAll();
  }

}
