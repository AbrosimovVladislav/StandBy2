package pro.standby.service.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Competition;
import pro.standby.repo.CompetitionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompetitionService {

  private final CompetitionRepository competitionRepository;

  public Competition save(Competition competition) {
    return competitionRepository.save(competition);
  }

  public Competition findById(Long competitionId) {
    return competitionRepository.findById(competitionId).orElseThrow(
        () -> new RuntimeException("There are no competition with this id: " + competitionId)
    );
  }

  public Competition findByName(String name) {
    return competitionRepository.findByName(name).orElseThrow(
        () -> new RuntimeException("There are no competition with this name: " + name)
    );
  }

  public List<Competition> getAll() {
    log.info("CompetitionService:getAll");
    List<Competition> competitions = competitionRepository.findAll();
    log.info("RESULT: " + competitions);
    return competitions;
  }

}
