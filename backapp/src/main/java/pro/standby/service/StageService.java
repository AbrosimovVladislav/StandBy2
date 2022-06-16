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

  public Stage save(Stage stage) {
    return stageRepository.save(stage);
  }

}
