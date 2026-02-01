package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "student",
    uniqueConstraints = {
        @UniqueConstraint(name = "duplikat_peselu_student", columnNames = "pesel"),
        @UniqueConstraint(name = "duplikat_indeksu_student", columnNames = "nr_indeksu"),
        @UniqueConstraint(name = "duplikat_loginu_student", columnNames = "login"),
        @UniqueConstraint(name = "duplikat_emaila_student", columnNames = "email")
    }
)
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_student", nullable = false)
  private Integer idStudent;

  @Column(name = "nr_indeksu", nullable = false, length = 20)
  private String nrIndeksu;

  @Column(name = "pesel", nullable = false, length = 11)
  private String pesel;

  @Column(name = "imie", nullable = false, length = 30)
  private String imie;

  @Column(name = "nazwisko", nullable = false, length = 30)
  private String nazwisko;

  @Column(name = "email", nullable = false, length = 50)
  private String email;

  @Column(name = "login", nullable = false, length = 30)
  private String login;

  @Column(name = "haslo", nullable = false, length = 30)
  private String haslo;

  @Column(name = "adres", nullable = false, length = 100)
  private String adres;

  @Column(name = "rok_studiow")
  private Integer rokStudiow;

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  private List<Zapis> zapisy = new ArrayList<>();

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  private List<Wypozyczenie> wypozyczenia = new ArrayList<>();

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  private List<Platnosc> platnosci = new ArrayList<>();

  @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
  private List<Powiadomienie> powiadomienia = new ArrayList<>();

  public Integer getIdStudent() { return idStudent; }
  public void setIdStudent(Integer idStudent) { this.idStudent = idStudent; }

  public String getNrIndeksu() { return nrIndeksu; }
  public void setNrIndeksu(String nrIndeksu) { this.nrIndeksu = nrIndeksu; }

  public String getPesel() { return pesel; }
  public void setPesel(String pesel) { this.pesel = pesel; }

  public String getImie() { return imie; }
  public void setImie(String imie) { this.imie = imie; }

  public String getNazwisko() { return nazwisko; }
  public void setNazwisko(String nazwisko) { this.nazwisko = nazwisko; }

  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  public String getLogin() { return login; }
  public void setLogin(String login) { this.login = login; }

  public String getHaslo() { return haslo; }
  public void setHaslo(String haslo) { this.haslo = haslo; }

  public String getAdres() { return adres; }
  public void setAdres(String adres) { this.adres = adres; }

  public Integer getRokStudiow() { return rokStudiow; }
  public void setRokStudiow(Integer rokStudiow) { this.rokStudiow = rokStudiow; }

  public List<Zapis> getZapisy() { return zapisy; }
  public void setZapisy(List<Zapis> zapisy) { this.zapisy = zapisy; }

  public List<Wypozyczenie> getWypozyczenia() { return wypozyczenia; }
  public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) { this.wypozyczenia = wypozyczenia; }

  public List<Platnosc> getPlatnosci() { return platnosci; }
  public void setPlatnosci(List<Platnosc> platnosci) { this.platnosci = platnosci; }

  public List<Powiadomienie> getPowiadomienia() { return powiadomienia; }
  public void setPowiadomienia(List<Powiadomienie> powiadomienia) { this.powiadomienia = powiadomienia; }
}
