package pro.standby.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.standby.model.Person;
import pro.standby.service.PersonService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @ApiOperation(value = "Create new person",
      notes = "Create new person",
      response = Person.class)
  @CrossOrigin
  @PostMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person create(Person person) {
    log.info("POST request: PersonController: create");
    return personService.save(person);
  }

}
