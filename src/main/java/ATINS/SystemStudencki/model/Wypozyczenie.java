package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "wypozyczenie")
public class Wypozyczenie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_wypozyczenie", nullable = false)
  private Integer idWypozyczenie;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_student", nullable = false)
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_ksiazka", nullable = false)
  private Ksiazka ksiazka;

  @Column(name = "data_wypozyczenia")
  private Date dataWypozyczenia;

  @Column(name = "termin_zwrotu")
  private Date terminZwrotu;

  @Column(name = "data_oddania")
  private Date dataOddania;

  @Column(name = "status", length = 20)
  private String status;

  public Integer getIdWypozyczenie() { return idWypozyczenie; }
  public void setIdWypozyczenie(Integer idWypozyczenie) { this.idWypozyczenie = idWypozyczenie; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }

  public Ksiazka getKsiazka() { return ksiazka; }
  public void setKsiazka(Ksiazka ksiazka) { this.ksiazka = ksiazka; }

  public Date getDataWypozyczenia() { return dataWypozyczenia; }
  public void setDataWypozyczenia(Date dataWypozyczenia) { this.dataWypozyczenia = dataWypozyczenia; }

  public Date getTerminZwrotu() { return terminZwrotu; }
  public void setTerminZwrotu(Date terminZwrotu) { this.terminZwrotu = terminZwrotu; }

  public Date getDataOddania() { return dataOddania; }
  public void setDataOddania(Date dataOddania) { this.dataOddania = dataOddania; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
