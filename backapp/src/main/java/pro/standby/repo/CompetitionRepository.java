package pro.standby.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

  public Optional<Competition> findByName(String name);
}
