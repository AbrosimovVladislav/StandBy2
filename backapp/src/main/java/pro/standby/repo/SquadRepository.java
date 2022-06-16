package pro.standby.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Squad;

public interface SquadRepository extends JpaRepository<Squad, Long> {
  public Optional<Squad> findByName(String name);
}
