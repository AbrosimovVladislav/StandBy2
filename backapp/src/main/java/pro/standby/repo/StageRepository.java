package pro.standby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Stage;

public interface StageRepository extends JpaRepository<Stage, Long> {

}
