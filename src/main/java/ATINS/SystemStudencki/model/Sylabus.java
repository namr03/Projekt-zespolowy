package ATINS.SystemStudencki.model;

import javax.persistence.*;

@Entity
@Table(name = "sylabus")
public class Sylabus {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_sylabus", nullable = false)
  private Integer idSylabus;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_przedmiot", nullable = false)
  private Przedmiot przedmiot;

  @Column(name = "nazwa", length = 50)
  private String nazwa;

  @Column(name = "tresc", length = 2000)
  private String tresc;

  public Integer getIdSylabus() { return idSylabus; }
  public void setIdSylabus(Integer idSylabus) { this.idSylabus = idSylabus; }

  public Przedmiot getPrzedmiot() { return przedmiot; }
  public void setPrzedmiot(Przedmiot przedmiot) { this.przedmiot = przedmiot; }

  public String getNazwa() { return nazwa; }
  public void setNazwa(String nazwa) { this.nazwa = nazwa; }

  public String getTresc() { return tresc; }
  public void setTresc(String tresc) { this.tresc = tresc; }
}
