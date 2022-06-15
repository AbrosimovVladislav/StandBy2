package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
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

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "result_id")
  private Result result;

}
