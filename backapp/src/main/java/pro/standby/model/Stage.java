package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stageId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    private String name;
    private Integer number;

    private Integer paperTargetsNumber;
    private Integer steelTargetsNumber;
    private Integer noShootsNumber;
    private Integer maximumPoints;
    private Integer maximumShots;
}
