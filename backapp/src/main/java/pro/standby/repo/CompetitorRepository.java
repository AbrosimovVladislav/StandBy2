package pro.standby.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model.Competitor;
import pro.standby.model.Person;

public interface CompetitorRepository extends JpaRepository<Competitor, Long> {

  Optional<Competitor> findByPerson(Person person);
}
