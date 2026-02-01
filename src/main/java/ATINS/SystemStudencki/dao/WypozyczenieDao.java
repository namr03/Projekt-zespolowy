package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Wypozyczenie;
import ATINS.SystemStudencki.model.Student;
import ATINS.SystemStudencki.model.Ksiazka;

import java.util.List;

/**
 * Interfejs DAO dla encji Wypozyczenie.
 * Definiuje operacje związane z wypożyczeniami książek w bibliotece.
 */
public interface WypozyczenieDao {

    /**
     * Pobiera wypożyczenie po identyfikatorze.
     * @param id identyfikator wypożyczenia
     * @return wypożyczenie lub null jeśli nie znaleziono
     */
    Wypozyczenie pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie wypożyczenia.
     * @return lista wszystkich wypożyczeń
     */
    List<Wypozyczenie> pobierzWszystkie();

    /**
     * Pobiera wszystkie wypożyczenia danego studenta.
     * @param studentId identyfikator studenta
     * @return lista wypożyczeń studenta
     */
    List<Wypozyczenie> pobierzWypozyczeniaStudenta(Integer studentId);

    /**
     * Pobiera aktywne wypożyczenia studenta (nieoddane książki).
     * @param studentId identyfikator studenta
     * @return lista aktywnych wypożyczeń
     */
    List<Wypozyczenie> pobierzAktywneWypozyczeniaStudenta(Integer studentId);

    /**
     * Pobiera wypożyczenia danej książki.
     * @param ksiazkaId identyfikator książki
     * @return lista wypożyczeń danej książki
     */
    List<Wypozyczenie> pobierzWypozyczeniaKsiazki(Integer ksiazkaId);

    /**
     * Pobiera przeterminowane wypożyczenia (termin zwrotu minął, książka nieoddana).
     * @return lista przeterminowanych wypożyczeń
     */
    List<Wypozyczenie> pobierzPrzeterminowaneWypozyczenia();

    /**
     * Pobiera przeterminowane wypożyczenia danego studenta.
     * @param studentId identyfikator studenta
     * @return lista przeterminowanych wypożyczeń studenta
     */
    List<Wypozyczenie> pobierzPrzeterminowaneWypozyczeniaStudenta(Integer studentId);

    /**
     * Pobiera wypożyczenia według statusu.
     * @param status status wypożyczenia
     * @return lista wypożyczeń o danym statusie
     */
    List<Wypozyczenie> pobierzWypozyczeniaPoStatusie(String status);

    /**
     * Sprawdza czy student ma aktywne wypożyczenie danej książki.
     * @param studentId identyfikator studenta
     * @param ksiazkaId identyfikator książki
     * @return true jeśli student ma aktywne wypożyczenie tej książki
     */
    boolean czyStudentMaWypozyczonaKsiazke(Integer studentId, Integer ksiazkaId);

    /**
     * Liczy aktywne wypożyczenia studenta.
     * @param studentId identyfikator studenta
     * @return liczba aktywnych wypożyczeń
     */
    Long policzAktywneWypozyczeniaStudenta(Integer studentId);

    /**
     * Zapisuje nowe wypożyczenie.
     * @param wypozyczenie wypożyczenie do zapisania
     */
    void zapisz(Wypozyczenie wypozyczenie);

    /**
     * Aktualizuje istniejące wypożyczenie.
     * @param wypozyczenie wypożyczenie do aktualizacji
     * @return zaktualizowane wypożyczenie
     */
    Wypozyczenie aktualizuj(Wypozyczenie wypozyczenie);

    /**
     * Usuwa wypożyczenie.
     * @param wypozyczenie wypożyczenie do usunięcia
     */
    void usun(Wypozyczenie wypozyczenie);

    /**
     * Usuwa wypożyczenie po identyfikatorze.
     * @param id identyfikator wypożyczenia
     */
    void usunPoId(Integer id);
}
