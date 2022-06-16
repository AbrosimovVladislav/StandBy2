package pro.standby.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {

  Optional<Stage> findByName(String name);
}
