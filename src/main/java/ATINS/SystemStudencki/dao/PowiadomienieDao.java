package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Powiadomienie;
import java.util.List;

/**
 * Interfejs DAO dla encji Powiadomienie.
 * Definiuje operacje dostępu do danych powiadomień studenta.
 */
public interface PowiadomienieDao {

    /**
     * Pobiera powiadomienie po identyfikatorze.
     * @param id identyfikator powiadomienia
     * @return powiadomienie lub null jeśli nie znaleziono
     */
    Powiadomienie pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie powiadomienia.
     * @return lista wszystkich powiadomień
     */
    List<Powiadomienie> pobierzWszystkie();

    /**
     * Pobiera wszystkie powiadomienia danego studenta.
     * @param studentId identyfikator studenta
     * @return lista powiadomień studenta
     */
    List<Powiadomienie> pobierzPowiadomieniaStudenta(Integer studentId);

    /**
     * Pobiera najnowsze powiadomienia studenta.
     * @param studentId identyfikator studenta
     * @param limit maksymalna liczba powiadomień do pobrania
     * @return lista najnowszych powiadomień
     */
    List<Powiadomienie> pobierzNajnowszePowiadomienia(Integer studentId, int limit);

    /**
     * Zlicza powiadomienia studenta.
     * @param studentId identyfikator studenta
     * @return liczba powiadomień
     */
    Long zliczPowiadomieniaStudenta(Integer studentId);

    /**
     * Zapisuje nowe powiadomienie.
     * @param powiadomienie powiadomienie do zapisania
     */
    void zapisz(Powiadomienie powiadomienie);

    /**
     * Aktualizuje istniejące powiadomienie.
     * @param powiadomienie powiadomienie do aktualizacji
     * @return zaktualizowane powiadomienie
     */
    Powiadomienie aktualizuj(Powiadomienie powiadomienie);

    /**
     * Usuwa powiadomienie.
     * @param powiadomienie powiadomienie do usunięcia
     */
    void usun(Powiadomienie powiadomienie);

    /**
     * Usuwa powiadomienie po identyfikatorze.
     * @param id identyfikator powiadomienia do usunięcia
     */
    void usunPoId(Integer id);

    /**
     * Usuwa wszystkie powiadomienia danego studenta.
     * @param studentId identyfikator studenta
     */
    void usunWszystkiePowiadomieniaStudenta(Integer studentId);
}
