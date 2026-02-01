package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "plan_zajec")
public class PlanZajec {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_plan", nullable = false)
  private Integer idPlan;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_przedmiot", nullable = false)
  private Przedmiot przedmiot;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_wykladowca", nullable = false)
  private Wykladowca wykladowca;

  @Column(name = "dzien_tygodnia", nullable = false, length = 15)
  private String dzienTygodnia;

  @Column(name = "godzina_start")
  private Time godzinaStart;

  @Column(name = "godzina_koniec")
  private Time godzinaKoniec;

  @Column(name = "sala", length = 10)
  private String sala;

  @Column(name = "typ", length = 20)
  private String typ;

  public Integer getIdPlan() { return idPlan; }
  public void setIdPlan(Integer idPlan) { this.idPlan = idPlan; }

  public Przedmiot getPrzedmiot() { return przedmiot; }
  public void setPrzedmiot(Przedmiot przedmiot) { this.przedmiot = przedmiot; }

  public Wykladowca getWykladowca() { return wykladowca; }
  public void setWykladowca(Wykladowca wykladowca) { this.wykladowca = wykladowca; }

  public String getDzienTygodnia() { return dzienTygodnia; }
  public void setDzienTygodnia(String dzienTygodnia) { this.dzienTygodnia = dzienTygodnia; }

  public Time getGodzinaStart() { return godzinaStart; }
  public void setGodzinaStart(Time godzinaStart) { this.godzinaStart = godzinaStart; }

  public Time getGodzinaKoniec() { return godzinaKoniec; }
  public void setGodzinaKoniec(Time godzinaKoniec) { this.godzinaKoniec = godzinaKoniec; }

  public String getSala() { return sala; }
  public void setSala(String sala) { this.sala = sala; }

  public String getTyp() { return typ; }
  public void setTyp(String typ) { this.typ = typ; }
}
