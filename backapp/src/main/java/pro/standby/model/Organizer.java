package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Organizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long organizerId;

  private String name;

  @OneToMany(mappedBy = "organizer")
  private Set<Contact> contacts;

  @JsonIgnore
  @OneToMany(mappedBy = "organizer")
  private Set<Competition> competitions = new HashSet<>();

}
