package pro.standby.model2;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long personId;

  private String firstName;
  private String lastName;

  @OneToMany(mappedBy = "person")
  private List<Contact> contacts;

  @Enumerated(EnumType.STRING)
  private Region region;

  @Enumerated(EnumType.STRING)
  private Rank rank;

  public enum Rank {
    MASTER, AMATEUR
  }

  public enum Region {
    SRB, RUS
  }
}
