package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.PlanZajec;
import java.util.List;

/**
 * Interfejs DAO dla encji PlanZajec.
 * Definiuje operacje dostępu do danych planu zajęć.
 */
public interface PlanZajecDao {

    /**
     * Pobiera plan zajęć po identyfikatorze.
     * @param id identyfikator planu
     * @return plan zajęć lub null jeśli nie znaleziono
     */
    PlanZajec pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie plany zajęć.
     * @return lista wszystkich planów zajęć
     */
    List<PlanZajec> pobierzWszystkie();

    /**
     * Pobiera plan zajęć dla danego przedmiotu.
     * @param przedmiotId identyfikator przedmiotu
     * @return lista planów zajęć dla przedmiotu
     */
    List<PlanZajec> pobierzPlanDlaPrzedmiotu(Integer przedmiotId);

    /**
     * Pobiera plan zajęć dla danego wykładowcy.
     * @param wykladowcaId identyfikator wykładowcy
     * @return lista planów zajęć wykładowcy
     */
    List<PlanZajec> pobierzPlanDlaWykladowcy(Integer wykladowcaId);

    /**
     * Pobiera plan zajęć dla danego dnia tygodnia.
     * @param dzienTygodnia nazwa dnia tygodnia
     * @return lista planów zajęć w danym dniu
     */
    List<PlanZajec> pobierzPlanDlaDnia(String dzienTygodnia);

    /**
     * Pobiera plan zajęć studenta na podstawie jego zapisów.
     * @param studentId identyfikator studenta
     * @return lista planów zajęć studenta
     */
    List<PlanZajec> pobierzPlanStudenta(Integer studentId);

    /**
     * Pobiera zajęcia w danej sali.
     * @param sala numer sali
     * @return lista zajęć w sali
     */
    List<PlanZajec> pobierzZajeciaWSali(String sala);

    /**
     * Pobiera zajęcia według typu (np. wykład, ćwiczenia, laboratorium).
     * @param typ typ zajęć
     * @return lista zajęć danego typu
     */
    List<PlanZajec> pobierzZajeciaPoTypie(String typ);

    /**
     * Zapisuje nowy plan zajęć.
     * @param planZajec plan zajęć do zapisania
     */
    void zapisz(PlanZajec planZajec);

    /**
     * Aktualizuje istniejący plan zajęć.
     * @param planZajec plan zajęć do aktualizacji
     * @return zaktualizowany plan zajęć
     */
    PlanZajec aktualizuj(PlanZajec planZajec);

    /**
     * Usuwa plan zajęć.
     * @param planZajec plan zajęć do usunięcia
     */
    void usun(PlanZajec planZajec);

    /**
     * Usuwa plan zajęć po identyfikatorze.
     * @param id identyfikator planu do usunięcia
     */
    void usunPoId(Integer id);
}
