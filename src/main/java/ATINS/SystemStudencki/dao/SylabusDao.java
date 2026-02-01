package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Sylabus;
import java.util.List;

/**
 * Interfejs DAO dla encji Sylabus.
 * Definiuje operacje dostępu do danych sylabusów przedmiotów.
 */
public interface SylabusDao {

    /**
     * Pobiera sylabus po identyfikatorze.
     * @param id identyfikator sylabusa
     * @return sylabus lub null jeśli nie znaleziono
     */
    Sylabus pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie sylabusy.
     * @return lista wszystkich sylabusów
     */
    List<Sylabus> pobierzWszystkie();

    /**
     * Pobiera sylabusy dla danego przedmiotu.
     * @param przedmiotId identyfikator przedmiotu
     * @return lista sylabusów dla przedmiotu
     */
    List<Sylabus> pobierzSylabusPrzedmiotu(Integer przedmiotId);

    /**
     * Pobiera sylabus po nazwie.
     * @param nazwa nazwa sylabusa
     * @return sylabus lub null jeśli nie znaleziono
     */
    Sylabus pobierzPoNazwie(String nazwa);

    /**
     * Wyszukuje sylabusy zawierające podany fragment w treści.
     * @param fragmentTresci fragment treści do wyszukania
     * @return lista pasujących sylabusów
     */
    List<Sylabus> wyszukajPoTresci(String fragmentTresci);

    /**
     * Zapisuje nowy sylabus.
     * @param sylabus sylabus do zapisania
     */
    void zapisz(Sylabus sylabus);

    /**
     * Aktualizuje istniejący sylabus.
     * @param sylabus sylabus do aktualizacji
     * @return zaktualizowany sylabus
     */
    Sylabus aktualizuj(Sylabus sylabus);

    /**
     * Usuwa sylabus.
     * @param sylabus sylabus do usunięcia
     */
    void usun(Sylabus sylabus);

    /**
     * Usuwa sylabus po identyfikatorze.
     * @param id identyfikator sylabusa do usunięcia
     */
    void usunPoId(Integer id);
}
