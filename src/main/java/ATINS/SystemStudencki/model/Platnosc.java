package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "platnosc")
public class Platnosc {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_platnosc", nullable = false)
  private Integer idPlatnosc;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_student", nullable = false)
  private Student student;

  @Column(name = "tytul", nullable = false, length = 50)
  private String tytul;

  @Column(name = "kwota", nullable = false)
  private Double kwota;

  @Column(name = "opis", length = 100)
  private String opis;

  @Column(name = "data_wplaty")
  private Date dataWplaty;

  @Column(name = "status", length = 20)
  private String status;

  public Integer getIdPlatnosc() { return idPlatnosc; }
  public void setIdPlatnosc(Integer idPlatnosc) { this.idPlatnosc = idPlatnosc; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }

  public String getTytul() { return tytul; }
  public void setTytul(String tytul) { this.tytul = tytul; }

  public Double getKwota() { return kwota; }
  public void setKwota(Double kwota) { this.kwota = kwota; }

  public String getOpis() { return opis; }
  public void setOpis(String opis) { this.opis = opis; }

  public Date getDataWplaty() { return dataWplaty; }
  public void setDataWplaty(Date dataWplaty) { this.dataWplaty = dataWplaty; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
}
