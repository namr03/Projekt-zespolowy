package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Ocena;
import ATINS.SystemStudencki.model.Zapis;

import java.util.List;

/**
 * Interfejs DAO dla encji Ocena.
 * Zapewnia metody dostępu do danych ocen studentów.
 */
public interface OcenaDao {

    /**
     * Pobiera ocenę po identyfikatorze.
     * @param id identyfikator oceny
     * @return encja Ocena lub null jeśli nie znaleziono
     */
    Ocena pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie oceny.
     * @return lista wszystkich ocen
     */
    List<Ocena> pobierzWszystkie();

    /**
     * Pobiera wszystkie oceny dla danego zapisu.
     * @param zapisId identyfikator zapisu
     * @return lista ocen dla danego zapisu
     */
    List<Ocena> pobierzOcenyDlaZapisu(Integer zapisId);

    /**
     * Pobiera wszystkie oceny studenta.
     * @param studentId identyfikator studenta
     * @return lista wszystkich ocen studenta
     */
    List<Ocena> pobierzOcenyStudenta(Integer studentId);

    /**
     * Pobiera oceny studenta z danego przedmiotu.
     * @param studentId identyfikator studenta
     * @param przedmiotId identyfikator przedmiotu
     * @return lista ocen studenta z przedmiotu
     */
    List<Ocena> pobierzOcenyStudentaZPrzedmiotu(Integer studentId, Integer przedmiotId);

    /**
     * Pobiera oceny według kategorii dla danego zapisu.
     * @param zapisId identyfikator zapisu
     * @param kategoria kategoria oceny (np. "egzamin", "kolokwium")
     * @return lista ocen danej kategorii
     */
    List<Ocena> pobierzOcenyWedlugKategorii(Integer zapisId, String kategoria);

    /**
     * Pobiera ostatnią ocenę z danego zapisu.
     * @param zapisId identyfikator zapisu
     * @return ostatnia wystawiona ocena lub null
     */
    Ocena pobierzOstatniaOcene(Integer zapisId);

    /**
     * Zapisuje nową ocenę.
     * @param ocena encja oceny do zapisania
     */
    void zapisz(Ocena ocena);

    /**
     * Aktualizuje istniejącą ocenę.
     * @param ocena encja oceny do zaktualizowania
     * @return zaktualizowana encja oceny
     */
    Ocena aktualizuj(Ocena ocena);

    /**
     * Usuwa ocenę.
     * @param ocena encja oceny do usunięcia
     */
    void usun(Ocena ocena);

    /**
     * Usuwa ocenę po identyfikatorze.
     * @param id identyfikator oceny do usunięcia
     */
    void usunPoId(Integer id);

    /**
     * Oblicza średnią ocen dla danego zapisu.
     * @param zapisId identyfikator zapisu
     * @return średnia ocen lub null jeśli brak ocen
     */
    Double obliczSredniaOcenZapisu(Integer zapisId);

    /**
     * Oblicza średnią wszystkich ocen studenta.
     * @param studentId identyfikator studenta
     * @return średnia ocen studenta lub null jeśli brak ocen
     */
    Double obliczSredniaOcenStudenta(Integer studentId);
}
