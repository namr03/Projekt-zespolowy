package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zapis")
public class Zapis {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_zapis", nullable = false)
  private Integer idZapis;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_student", nullable = false)
  private Student student;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_przedmiot", nullable = false)
  private Przedmiot przedmiot;

  @Column(name = "data_zapisu")
  private Date dataZapisu;

  @Column(name = "rok_akademicki", length = 20)
  private String rokAkademicki;

  @Column(name = "status", length = 30)
  private String status;

  @OneToMany(mappedBy = "zapis", fetch = FetchType.LAZY)
  private List<Ocena> oceny = new ArrayList<>();

  public Integer getIdZapis() { return idZapis; }
  public void setIdZapis(Integer idZapis) { this.idZapis = idZapis; }

  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }

  public Przedmiot getPrzedmiot() { return przedmiot; }
  public void setPrzedmiot(Przedmiot przedmiot) { this.przedmiot = przedmiot; }

  public Date getDataZapisu() { return dataZapisu; }
  public void setDataZapisu(Date dataZapisu) { this.dataZapisu = dataZapisu; }

  public String getRokAkademicki() { return rokAkademicki; }
  public void setRokAkademicki(String rokAkademicki) { this.rokAkademicki = rokAkademicki; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }

  public List<Ocena> getOceny() { return oceny; }
  public void setOceny(List<Ocena> oceny) { this.oceny = oceny; }
}
