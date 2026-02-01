package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Student;
import java.util.List;

/**
 * Interfejs DAO dla encji Student.
 * Definiuje operacje dostępu do danych studenta.
 */
public interface StudentDao {

    /**
     * Pobiera studenta po identyfikatorze.
     * @param id identyfikator studenta
     * @return student lub null jeśli nie znaleziono
     */
    Student pobierzPoId(Integer id);

    /**
     * Pobiera studenta po numerze indeksu.
     * @param nrIndeksu numer indeksu studenta
     * @return student lub null jeśli nie znaleziono
     */
    Student pobierzPoNumerzeIndeksu(String nrIndeksu);

    /**
     * Pobiera studenta po loginie.
     * @param login login studenta
     * @return student lub null jeśli nie znaleziono
     */
    Student pobierzPoLoginie(String login);

    /**
     * Pobiera studenta po adresie email.
     * @param email email studenta
     * @return student lub null jeśli nie znaleziono
     */
    Student pobierzPoEmail(String email);

    /**
     * Pobiera wszystkich studentów.
     * @return lista wszystkich studentów
     */
    List<Student> pobierzWszystkich();

    /**
     * Pobiera studentów z danego roku studiów.
     * @param rokStudiow rok studiów
     * @return lista studentów
     */
    List<Student> pobierzPoRokuStudiow(Integer rokStudiow);

    /**
     * Wyszukuje studentów po nazwisku (częściowe dopasowanie).
     * @param nazwisko nazwisko lub jego część
     * @return lista pasujących studentów
     */
    List<Student> wyszukajPoNazwisku(String nazwisko);

    /**
     * Uwierzytelnia studenta na podstawie loginu i hasła.
     * @param login login studenta
     * @param haslo hasło studenta
     * @return student jeśli dane są poprawne, null w przeciwnym razie
     */
    Student uwierzytelnij(String login, String haslo);

    /**
     * Zapisuje nowego studenta.
     * @param student encja studenta do zapisania
     */
    void zapisz(Student student);

    /**
     * Aktualizuje dane istniejącego studenta.
     * @param student encja studenta do aktualizacji
     * @return zaktualizowany student
     */
    Student aktualizuj(Student student);

    /**
     * Usuwa studenta.
     * @param student encja studenta do usunięcia
     */
    void usun(Student student);

    /**
     * Usuwa studenta po identyfikatorze.
     * @param id identyfikator studenta
     */
    void usunPoId(Integer id);

    /**
     * Sprawdza czy istnieje student o podanym numerze indeksu.
     * @param nrIndeksu numer indeksu
     * @return true jeśli istnieje, false w przeciwnym razie
     */
    boolean czyIstniejeNrIndeksu(String nrIndeksu);

    /**
     * Sprawdza czy istnieje student o podanym loginie.
     * @param login login
     * @return true jeśli istnieje, false w przeciwnym razie
     */
    boolean czyIstniejeLogin(String login);

    /**
     * Sprawdza czy istnieje student o podanym emailu.
     * @param email email
     * @return true jeśli istnieje, false w przeciwnym razie
     */
    boolean czyIstniejeEmail(String email);

    /**
     * Zlicza wszystkich studentów.
     * @return liczba studentów
     */
    long zliczWszystkich();
}
