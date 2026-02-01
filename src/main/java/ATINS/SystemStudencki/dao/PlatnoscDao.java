package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Platnosc;
import ATINS.SystemStudencki.model.Student;

import java.util.List;

/**
 * Interfejs DAO dla encji Platnosc.
 * Definiuje operacje związane z płatnościami studentów.
 */
public interface PlatnoscDao {

    /**
     * Pobiera płatność po identyfikatorze.
     * @param id identyfikator płatności
     * @return płatność lub null jeśli nie znaleziono
     */
    Platnosc pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie płatności.
     * @return lista wszystkich płatności
     */
    List<Platnosc> pobierzWszystkie();

    /**
     * Pobiera wszystkie płatności danego studenta.
     * @param studentId identyfikator studenta
     * @return lista płatności studenta
     */
    List<Platnosc> pobierzWszystkiePlatnosciStudenta(Integer studentId);

    /**
     * Pobiera zaległe płatności studenta (nieopłacone).
     * @param studentId identyfikator studenta
     * @return lista zaległych płatności
     */
    List<Platnosc> pobierzZaleglePlatnosci(Integer studentId);

    /**
     * Pobiera opłacone płatności studenta.
     * @param studentId identyfikator studenta
     * @return lista opłaconych płatności
     */
    List<Platnosc> pobierzOplaconePlatnosci(Integer studentId);

    /**
     * Pobiera płatności według statusu.
     * @param status status płatności
     * @return lista płatności o podanym statusie
     */
    List<Platnosc> pobierzPlatnosciPoStatusie(String status);

    /**
     * Oblicza sumę zaległości studenta.
     * @param studentId identyfikator studenta
     * @return suma zaległych kwot
     */
    Double obliczSumeZaleglosci(Integer studentId);

    /**
     * Zapisuje nową płatność.
     * @param platnosc płatność do zapisania
     */
    void zapisz(Platnosc platnosc);

    /**
     * Aktualizuje istniejącą płatność.
     * @param platnosc płatność do aktualizacji
     * @return zaktualizowana płatność
     */
    Platnosc aktualizuj(Platnosc platnosc);

    /**
     * Usuwa płatność.
     * @param platnosc płatność do usunięcia
     */
    void usun(Platnosc platnosc);

    /**
     * Usuwa płatność po identyfikatorze.
     * @param id identyfikator płatności
     */
    void usunPoId(Integer id);
}
