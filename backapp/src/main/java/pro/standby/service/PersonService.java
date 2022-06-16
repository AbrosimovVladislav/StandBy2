package pro.standby.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model2.Person;
import pro.standby.repo.PersonRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository personRepository;

  public Person findByName(String firstName, String lastName) {
    List<Person> persons = personRepository.findByFirstNameAndLastName(firstName,
        lastName);
    if (persons.size() != 1) {
      throw new RuntimeException("There are less that 0 or more than 1 person");
    }
    return persons.get(0);
  }

  public Person save(Person person) {
    return personRepository.save(person);
  }
}
