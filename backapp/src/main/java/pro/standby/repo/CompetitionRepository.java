package pro.standby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Competition;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {

}
