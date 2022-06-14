package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Squad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long squadId;

  private String squadName;

  @OneToMany(mappedBy = "squad")
  private Set<Competitor> competitors;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "competition_id")
  private Competition competition;

}
