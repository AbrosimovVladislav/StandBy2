package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
//@Entity
@Accessors(chain = true)
public class Place {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long placeId;

  private String name;

  @JsonIgnore
  @OneToMany(mappedBy = "place")
  private Set<Competition> competitions = new HashSet<>();
}
