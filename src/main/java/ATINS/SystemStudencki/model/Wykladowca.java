package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "wykladowca",
    uniqueConstraints = {
        @UniqueConstraint(name = "duplikat_loginu_wykladowca", columnNames = "login"),
        @UniqueConstraint(name = "duplikat_emaila_wykladowca", columnNames = "email")
    }
)
public class Wykladowca {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_wykladowca", nullable = false)
  private Integer idWykladowca;

  @Column(name = "imie", nullable = false, length = 30)
  private String imie;

  @Column(name = "nazwisko", nullable = false, length = 30)
  private String nazwisko;

  @Column(name = "tytul_naukowy", length = 50)
  private String tytulNaukowy;

  @Column(name = "email", nullable = false, length = 50)
  private String email;

  @Column(name = "login", nullable = false, length = 30)
  private String login;

  @Column(name = "haslo", nullable = false, length = 30)
  private String haslo;

  @OneToMany(mappedBy = "wykladowca", fetch = FetchType.LAZY)
  private List<PlanZajec> planZajec = new ArrayList<>();

  public Integer getIdWykladowca() { return idWykladowca; }
  public void setIdWykladowca(Integer idWykladowca) { this.idWykladowca = idWykladowca; }

  public String getImie() { return imie; }
  public void setImie(String imie) { this.imie = imie; }

  public String getNazwisko() { return nazwisko; }
  public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

  public String getTytulNaukowy() { return tytulNaukowy; }
  public void setTytulNaukowy(String tytulNaukowy) { this.tytulNaukowy = tytulNaukowy; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getLogin() { return login; }
  public void setLogin(String login) { this.login = login; }

  public String getHaslo() { return haslo; }
  public void setHaslo(String haslo) { this.haslo = haslo; }

  public List<PlanZajec> getPlanZajec() { return planZajec; }
  public void setPlanZajec(List<PlanZajec> planZajec) { this.planZajec = planZajec; }
}
