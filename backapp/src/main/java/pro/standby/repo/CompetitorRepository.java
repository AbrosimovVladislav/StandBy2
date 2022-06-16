package pro.standby.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Competitor;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

}
