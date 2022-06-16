package pro.standby.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Competition {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long competitionId;

  @OneToMany(mappedBy = "competition")
  private Set<Stage> stages;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person matchDirector;

  @ManyToOne
  @JoinColumn(name = "referee_id")
  private Referee referee;

  @OneToMany(mappedBy = "competition")
  private List<Squad> squads;

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
