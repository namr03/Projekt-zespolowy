package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ocena")
public class Ocena {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ocena", nullable = false)
  private Integer idOcena;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_zapis", nullable = false)
  private Zapis zapis;

  @Column(name = "wartosc")
  private Double wartosc;

  @Column(name = "kategoria", length = 20)
  private String kategoria;

  @Column(name = "komentarz", length = 200)
  private String komentarz;

  @Column(name = "data_wystawienia")
  private Date dataWystawienia;

  public Integer getIdOcena() { return idOcena; }
  public void setIdOcena(Integer idOcena) { this.idOcena = idOcena; }

  public Zapis getZapis() { return zapis; }
  public void setZapis(Zapis zapis) { this.zapis = zapis; }

  public Double getWartosc() { return wartosc; }
  public void setWartosc(Double wartosc) { this.wartosc = wartosc; }

  public String getKategoria() { return kategoria; }
  public void setKategoria(String kategoria) { this.kategoria = kategoria; }

  public String getKomentarz() { return komentarz; }
  public void setKomentarz(String komentarz) { this.komentarz = komentarz; }

  public Date getDataWystawienia() { return dataWystawienia; }
  public void setDataWystawienia(Date dataWystawienia) { this.dataWystawienia = dataWystawienia; }
}
