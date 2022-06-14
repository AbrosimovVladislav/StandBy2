package pro.standby.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

  private String name;
  private Date startDate;
  private Date endDate;

  @Enumerated(EnumType.STRING)
  private Level level;

  @Enumerated(EnumType.STRING)
  private GunType type;

  @ManyToOne
  @JoinColumn(name = "place_id")
  private Place place;

  @ManyToOne
  @JoinColumn(name = "organizer_id")
  private Organizer organizer;

  private Integer squadCount;
  private Integer squadSize;
  private Integer price;

  @OneToOne
  @JoinColumn(name = "person_id")
  private Person matchDirector;

  @Column(length = 2500)
  private String description;

  @ManyToMany
  @JoinTable(
      name = "competition_referee",
      joinColumns = @JoinColumn(name = "refereeId"),
      inverseJoinColumns = @JoinColumn(name = "competitionId"))
  private Set<Referee> referees;

  @OneToMany(mappedBy = "competition")
  private Set<Squad> squads;

  public enum Level {
    IPSC_LEVEL_III
  }

  public enum GunType {
    HANDGUN, PCC, CARBINE, SHOTGUN
  }


}


