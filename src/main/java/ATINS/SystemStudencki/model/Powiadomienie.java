package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "powiadomienie")
public class Powiadomienie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_powiadomienie", nullable = false)
  private Integer idPowiadomienie;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_student", nullable = false)
  private Student student;

  @Column(name = "tytul", length = 100)
  private String tytul;

  @Column(name = "tresc", length = 1000)
  private String tresc;

  @Column(name = "data_wyslania")
  private Date dataWyslania;

  public Integer getIdPowiadomienie() { return idPowiadomienie; }
  public void setIdPowiadomienie(Integer idPowiadomienie) { this.idPowiadomienie = idPowiadomienie; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }

  public String getTytul() { return tytul; }
  public void setTytul(String tytul) { this.tytul = tytul; }

  public String getTresc() { return tresc; }
  public void setTresc(String tresc) { this.tresc = tresc; }

  public Date getDataWyslania() { return dataWyslania; }
  public void setDataWyslania(Date dataWyslania) { this.dataWyslania = dataWyslania; }
}
