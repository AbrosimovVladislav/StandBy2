package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long squadId;

    private String name;

    @OneToMany(mappedBy = "squad")
    private List<Competitor> competitors;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

}
