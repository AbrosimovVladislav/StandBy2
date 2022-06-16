package pro.standby.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import pro.standby.model2.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

  public List<Person> findByFirstNameAndLastName(String firstName, String lastName);

}
