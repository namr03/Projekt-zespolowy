package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Wykladowca;
import java.util.List;

/**
 * Interfejs DAO dla encji Wykladowca.
 * Definiuje operacje dostępu do danych wykładowców.
 */
public interface WykladowcaDao {

    /**
     * Pobiera wykładowcę po identyfikatorze.
     * @param id identyfikator wykładowcy
     * @return wykładowca lub null jeśli nie znaleziono
     */
    Wykladowca pobierzPoId(Integer id);

    /**
     * Pobiera wykładowcę po loginie.
     * @param login login wykładowcy
     * @return wykładowca lub null jeśli nie znaleziono
     */
    Wykladowca pobierzPoLoginie(String login);

    /**
     * Pobiera wykładowcę po adresie email.
     * @param email email wykładowcy
     * @return wykładowca lub null jeśli nie znaleziono
     */
    Wykladowca pobierzPoEmail(String email);

    /**
     * Pobiera wszystkich wykładowców.
     * @return lista wszystkich wykładowców
     */
    List<Wykladowca> pobierzWszystkich();

    /**
     * Wyszukuje wykładowców po nazwisku (częściowe dopasowanie).
     * @param nazwisko nazwisko lub jego część
     * @return lista pasujących wykładowców
     */
    List<Wykladowca> wyszukajPoNazwisku(String nazwisko);

    /**
     * Pobiera wykładowców według tytułu naukowego.
     * @param tytulNaukowy tytuł naukowy
     * @return lista wykładowców z danym tytułem
     */
    List<Wykladowca> pobierzPoTytuleNaukowym(String tytulNaukowy);

    /**
     * Uwierzytelnia wykładowcę na podstawie loginu i hasła.
     * @param login login wykładowcy
     * @param haslo hasło wykładowcy
     * @return wykładowca jeśli dane są poprawne, null w przeciwnym razie
     */
    Wykladowca uwierzytelnij(String login, String haslo);

    /**
     * Zapisuje nowego wykładowcę.
     * @param wykladowca encja wykładowcy do zapisania
     */
    void zapisz(Wykladowca wykladowca);

    /**
     * Aktualizuje dane istniejącego wykładowcy.
     * @param wykladowca encja wykładowcy do aktualizacji
     * @return zaktualizowany wykładowca
     */
    Wykladowca aktualizuj(Wykladowca wykladowca);

    /**
     * Usuwa wykładowcę.
     * @param wykladowca encja wykładowcy do usunięcia
     */
    void usun(Wykladowca wykladowca);

    /**
     * Usuwa wykładowcę po identyfikatorze.
     * @param id identyfikator wykładowcy
     */
    void usunPoId(Integer id);

    /**
     * Sprawdza czy istnieje wykładowca o podanym loginie.
     * @param login login
     * @return true jeśli istnieje, false w przeciwnym razie
     */
    boolean czyIstniejeLogin(String login);

    /**
     * Sprawdza czy istnieje wykładowca o podanym emailu.
     * @param email email
     * @return true jeśli istnieje, false w przeciwnym razie
     */
    boolean czyIstniejeEmail(String email);

    /**
     * Zlicza wszystkich wykładowców.
     * @return liczba wykładowców
     */
    long zliczWszystkich();
}
