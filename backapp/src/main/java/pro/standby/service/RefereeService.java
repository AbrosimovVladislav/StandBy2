package pro.standby.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pro.standby.model2.Referee;
import pro.standby.repo.RefereeRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class RefereeService {

  private final RefereeRepository refereeRepository;

  public Referee findByName(String firstName, String lastName) {
    List<Referee> referees = refereeRepository.findAll();
    List<Referee> founded = referees.stream()
        .filter(ref -> ref.getPerson().getFirstName().equals(firstName)
            && ref.getPerson().getLastName().equals(lastName)).toList();
    if (founded.size() != 1) {
      throw new RuntimeException("There are less that 0 or more than 1 referees with such name");
    }
    return founded.get(0);
  }

}
