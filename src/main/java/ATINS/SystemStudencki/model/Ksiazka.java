package ATINS.SystemStudencki.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ksiazka")
public class Ksiazka {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_ksiazka", nullable = false)
  private Integer idKsiazka;

  @Column(name = "tytul", length = 50)
  private String tytul;

  @Column(name = "autor", length = 100)
  private String autor;

  @Column(name = "isbn", length = 40)
  private String isbn;

  @Column(name = "ilosc")
  private Integer ilosc;

  @Column(name = "dostepna")
  private Boolean dostepna;

  @OneToMany(mappedBy = "ksiazka", fetch = FetchType.LAZY)
  private List<Wypozyczenie> wypozyczenia = new ArrayList<>();

  public Integer getIdKsiazka() { return idKsiazka; }
  public void setIdKsiazka(Integer idKsiazka) { this.idKsiazka = idKsiazka; }

  public String getTytul() { return tytul; }
  public void setTytul(String tytul) { this.tytul = tytul; }

  public String getAutor() { return autor; }
  public void setAutor(String autor) { this.autor = autor; }

  public String getIsbn() { return isbn; }
  public void setIsbn(String isbn) { this.isbn = isbn; }

  public Integer getIlosc() { return ilosc; }
  public void setIlosc(Integer ilosc) { this.ilosc = ilosc; }

  public Boolean getDostepna() { return dostepna; }
  public void setDostepna(Boolean dostepna) { this.dostepna = dostepna; }

  public List<Wypozyczenie> getWypozyczenia() { return wypozyczenia; }
  public void setWypozyczenia(List<Wypozyczenie> wypozyczenia) { this.wypozyczenia = wypozyczenia; }
}
