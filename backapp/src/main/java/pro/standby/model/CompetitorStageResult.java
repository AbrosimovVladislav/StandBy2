package pro.standby.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

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
    private Integer time;
    private Double hitFactor;

}
