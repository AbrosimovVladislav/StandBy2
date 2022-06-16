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
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Competitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competitorId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "squad_id")
    private Squad squad;

    @Enumerated(EnumType.STRING)
    private GunType gunType;

    @Enumerated(EnumType.STRING)
    private GunClass gunClass;

}
