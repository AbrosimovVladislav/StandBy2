package pro.standby.model2;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long competitionId;

    @OneToMany(mappedBy = "competition")
    private Set<Stage> stages;

    @OneToMany(mappedBy = "competition")
    private Set<Squad> squads;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person matchDirector;

    @ManyToOne
    @JoinColumn(name = "referee_id")
    private Referee referee;

    private String name;
    private Date startDate;
    private Date finishDate;
    private String place;
    private String organizer;
    private Integer price;
    @Column(length = 2500)
    private String description;

    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private GunType gunType;

}
