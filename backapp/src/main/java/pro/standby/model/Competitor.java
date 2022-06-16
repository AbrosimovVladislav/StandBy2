package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pro.standby.model.Competition.GunType;

@Getter
@Setter
//@Entity
@Accessors(chain = true)
public class Competitor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long competitorId;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person person;

  @Enumerated(EnumType.STRING)
  private GunType gunType;

  @Enumerated(EnumType.STRING)
  private GunClass gunClass;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "squad_id")
  private Squad squad;

  public enum GunClass {
    OPEN, OPTICS, STANDART
  }

}
