package pro.standby.model2;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "squad_id")
    private Squad squad;

    @Enumerated(EnumType.STRING)
    private GunType gunType;

    @Enumerated(EnumType.STRING)
    private GunClass gunClass;

}
