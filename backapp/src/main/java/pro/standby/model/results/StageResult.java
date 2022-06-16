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
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
//@Entity
@Accessors(chain = true)
public class StageResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long stageResultId;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "result_item_id")
  private ResultItem resultItem;

  @OneToMany(mappedBy = "stageResult")
  private List<StageResultItem> stageResultItems;



}
