package pro.standby.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
//@Entity
@Accessors(chain = true)
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long contactId;

  @Enumerated(EnumType.STRING)
  private ContactType contactType;

  private String value;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "organizer_id")
  private Organizer organizer;

  public enum ContactType {
    PHONE, EMAIL, TELEGRAMM, INSTAGRAMM, WHATSAPP, VIBER
  }

}
