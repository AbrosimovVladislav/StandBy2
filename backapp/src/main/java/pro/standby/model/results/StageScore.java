package pro.standby.model.results;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import pro.standby.model.Competitor;

@Getter
@Setter
@Entity
@Accessors(chain = true)
public class StageScore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stageScoreId;

  private Integer charlies;
  private Integer deltas;
  private Integer misses;
  private Integer noShoots;

  @ManyToOne
  @JoinColumn(name = "competitor_id")
  private Competitor competitor;

  @ManyToOne
  @JoinColumn(name = "stage_id")
  private Stage stage;

}
