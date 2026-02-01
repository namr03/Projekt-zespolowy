package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "przedmiot",
    uniqueConstraints = {
        @UniqueConstraint(name = "duplikat_nazwa_przedmiot", columnNames = "nazwa")
    }
)
public class Przedmiot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_przedmiot", nullable = false)
  private Integer idPrzedmiot;

  @Column(name = "nazwa", nullable = false, length = 30)
  private String nazwa;

  @Column(name = "ects")
  private Integer ects;

  @Column(name = "semestr", length = 10)
  private String semestr;

  @Column(name = "opis", length = 255)
  private String opis;

  @Column(name = "limit_miejsc")
  private Integer limitMiejsc;

  @OneToMany(mappedBy = "przedmiot", fetch = FetchType.LAZY)
  private List<Sylabus> sylabusy = new ArrayList<>();

  @OneToMany(mappedBy = "przedmiot", fetch = FetchType.LAZY)
  private List<PlanZajec> planZajec = new ArrayList<>();

  @OneToMany(mappedBy = "przedmiot", fetch = FetchType.LAZY)
  private List<Zapis> zapisy = new ArrayList<>();

  public Integer getIdPrzedmiot() { return idPrzedmiot; }
  public void setIdPrzedmiot(Integer idPrzedmiot) { this.idPrzedmiot = idPrzedmiot; }

  public String getNazwa() { return nazwa; }
  public void setNazwa(String nazwa) { this.nazwa = nazwa; }

  public Integer getEcts() { return ects; }
  public void setEcts(Integer ects) { this.ects = ects; }

  public String getSemestr() { return semestr; }
  public void setSemestr(String semestr) { this.semestr = semestr; }

  public String getOpis() { return opis; }
  public void setOpis(String opis) { this.opis = opis; }

  public Integer getLimitMiejsc() { return limitMiejsc; }
  public void setLimitMiejsc(Integer limitMiejsc) { this.limitMiejsc = limitMiejsc; }

  public List<Sylabus> getSylabusy() { return sylabusy; }
  public void setSylabusy(List<Sylabus> sylabusy) { this.sylabusy = sylabusy; }

  public List<PlanZajec> getPlanZajec() { return planZajec; }
  public void setPlanZajec(List<PlanZajec> planZajec) { this.planZajec = planZajec; }

  public List<Zapis> getZapisy() { return zapisy; }
  public void setZapisy(List<Zapis> zapisy) { this.zapisy = zapisy; }
}
