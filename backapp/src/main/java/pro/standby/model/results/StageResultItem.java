package pro.standby.model.results;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class StageResultItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stageResultItemId;

  private Integer stageNumber;
  private String stageName;
  private Integer place;
  private Double percentage;
  private Integer points;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "stage_result_id")
  private StageResult stageResult;

}
