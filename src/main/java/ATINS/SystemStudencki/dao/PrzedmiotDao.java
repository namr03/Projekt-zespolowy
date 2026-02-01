package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Przedmiot;
import java.util.List;

/**
 * Interfejs DAO dla encji Przedmiot.
 * Definiuje operacje dostępu do danych przedmiotów.
 */
public interface PrzedmiotDao {

    /**
     * Pobiera przedmiot po identyfikatorze.
     * @param id identyfikator przedmiotu
     * @return przedmiot lub null jeśli nie znaleziono
     */
    Przedmiot pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie przedmioty.
     * @return lista wszystkich przedmiotów
     */
    List<Przedmiot> pobierzWszystkie();

    /**
     * Pobiera przedmioty dla danego semestru.
     * @param semestr oznaczenie semestru
     * @return lista przedmiotów w danym semestrze
     */
    List<Przedmiot> pobierzPrzedmiotyWSemestrze(String semestr);

    /**
     * Pobiera przedmioty z wolnymi miejscami (gdzie liczba zapisów < limit miejsc).
     * @return lista dostępnych przedmiotów
     */
    List<Przedmiot> pobierzDostepnePrzedmioty();

    /**
     * Pobiera przedmiot po nazwie.
     * @param nazwa nazwa przedmiotu
     * @return przedmiot lub null jeśli nie znaleziono
     */
    Przedmiot pobierzPoNazwie(String nazwa);

    /**
     * Wyszukuje przedmioty po fragmencie nazwy.
     * @param fragmentNazwy fragment nazwy do wyszukania
     * @return lista pasujących przedmiotów
     */
    List<Przedmiot> wyszukajPoNazwie(String fragmentNazwy);

    /**
     * Pobiera liczbę zapisanych studentów na przedmiot.
     * @param idPrzedmiot identyfikator przedmiotu
     * @return liczba zapisanych studentów
     */
    Long pobierzLiczbeZapisanychStudentow(Integer idPrzedmiot);

    /**
     * Zapisuje nowy przedmiot.
     * @param przedmiot przedmiot do zapisania
     */
    void zapisz(Przedmiot przedmiot);

    /**
     * Aktualizuje istniejący przedmiot.
     * @param przedmiot przedmiot do aktualizacji
     * @return zaktualizowany przedmiot
     */
    Przedmiot aktualizuj(Przedmiot przedmiot);

    /**
     * Usuwa przedmiot.
     * @param przedmiot przedmiot do usunięcia
     */
    void usun(Przedmiot przedmiot);

    /**
     * Usuwa przedmiot po identyfikatorze.
     * @param id identyfikator przedmiotu do usunięcia
     */
    void usunPoId(Integer id);
}
