package pro.standby.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Squad;
import pro.standby.repo.SquadRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class SquadService {

  private final SquadRepository squadRepository;

  public Squad findByName(String name) {
    return squadRepository.findByName(name).orElseThrow(
        () -> new RuntimeException("There is no squad with this name: " + name)
    );
  }

  public Squad save(Squad squad) {
    return squadRepository.save(squad);
  }

}
