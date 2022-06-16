package pro.standby.model.dto;

import lombok.Data;

@Data
public class CompetitorStageResultDto {

  private String stageName;
  private String competitorName;

  private Integer alphas;
  private Integer charlies;
  private Integer deltas;
  private Integer misses;
  private Integer noShoots;
  private Integer procedurals;
  private Double time;
}
