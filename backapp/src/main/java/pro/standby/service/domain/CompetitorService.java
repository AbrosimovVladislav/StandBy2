package pro.standby.service.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model.Competitor;
import pro.standby.model.Person;
import pro.standby.repo.CompetitorRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompetitorService {

  private final CompetitorRepository competitorRepository;
  private final PersonService personService;

  public Competitor findByName(String name) {
    String firstName = name.split(" ")[0];
    String lastName = name.split(" ")[1];
    Person person = personService.findByName(firstName, lastName);
    return competitorRepository.findByPerson(person).orElseThrow(
        () -> new RuntimeException("There is no competitor with such person: " + person)
    );
  }

  public Competitor save(Competitor competitor) {
    return competitorRepository.save(competitor);
  }

}
