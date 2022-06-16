package pro.standby.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Stage;
import pro.standby.repo.StageRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StageService {

  private final StageRepository stageRepository;

  public Stage findByName(String name) {
    return stageRepository.findByName(name).orElseThrow(
        () -> new RuntimeException("There is no stage with this name: " + name)
    );
  }

  public Stage save(Stage stage) {
    return stageRepository.save(stage);
  }

}
