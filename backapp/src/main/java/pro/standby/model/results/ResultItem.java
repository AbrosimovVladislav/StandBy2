package pro.standby.model.results;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pro.standby.model.Competitor;

@Getter
@Setter
//@Entity
@Accessors(chain = true)
public class ResultItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long resultItemId;

  private Integer place;
  private Double percentage;
  private Integer points;

  @OneToOne
  @JoinColumn(name = "competitor_id")
  private Competitor competitor;

  @OneToMany(mappedBy = "resultItem")
  private List<StageResult> stageResults;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "result_id")
  private Result result;

}
