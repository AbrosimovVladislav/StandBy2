package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Referee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long refereeId;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @JsonIgnore
  @ManyToMany(mappedBy = "referees")
  private Set<Competition> competitions;

}
