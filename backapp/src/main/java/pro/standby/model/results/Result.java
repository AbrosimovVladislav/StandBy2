package pro.standby.model.results;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pro.standby.model.Competition;

@Getter
@Setter
//@Entity
@Accessors(chain = true)
public class Result {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long resultId;

  @OneToMany(mappedBy = "result")
  private List<ResultItem> resultItems;

  @JsonIgnore
  @OneToOne
  @JoinColumn(name = "competition_id")
  private Competition competition;



}
