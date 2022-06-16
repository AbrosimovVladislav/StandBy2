package pro.standby.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model2.Competition;
import pro.standby.repo.CompetitionRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompetitionService {

  private final CompetitionRepository competitionRepository;

  public Competition save(Competition competition) {
    return competitionRepository.save(competition);
  }

  public List<Competition> getAll() {
    log.info("CompetitionService:getAll");
    List<Competition> competitions = competitionRepository.findAll();
    log.info("RESULT: " + competitions);
    return competitions;
  }

}
