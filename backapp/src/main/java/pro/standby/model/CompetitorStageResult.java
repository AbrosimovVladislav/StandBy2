package pro.standby.model;

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
public class CompetitorStageResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long competitorStageResultId;

  @ManyToOne
  @JoinColumn(name = "stage_id")
  private Stage stage;

  @ManyToOne
  @JoinColumn(name = "competitor_id")
  private Competitor competitor;

  private Integer alphas;
  private Integer charlies;
  private Integer deltas;
  private Integer misses;
  private Integer noShoots;
  private Integer procedurals;
  private Double time;
  private Integer points;
  private Double hitFactor;

}
