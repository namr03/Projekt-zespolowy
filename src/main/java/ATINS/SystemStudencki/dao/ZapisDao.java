package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Zapis;
import ATINS.SystemStudencki.model.Student;
import ATINS.SystemStudencki.model.Przedmiot;

import java.util.List;

/**
 * Interfejs DAO dla encji Zapis.
 * Obsługuje operacje związane z zapisami studentów na przedmioty.
 */
public interface ZapisDao {

    /**
     * Pobiera zapis po identyfikatorze.
     * @param id identyfikator zapisu
     * @return encja Zapis lub null jeśli nie znaleziono
     */
    Zapis pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie zapisy.
     * @return lista wszystkich zapisów
     */
    List<Zapis> pobierzWszystkie();

    /**
     * Pobiera zapisy danego studenta.
     * @param studentId identyfikator studenta
     * @return lista zapisów studenta
     */
    List<Zapis> pobierzZapisyStudenta(Integer studentId);

    /**
     * Pobiera zapisy na dany przedmiot.
     * @param przedmiotId identyfikator przedmiotu
     * @return lista zapisów na przedmiot
     */
    List<Zapis> pobierzZapisyNaPrzedmiot(Integer przedmiotId);

    /**
     * Pobiera aktywne zapisy studenta (status = 'AKTYWNY').
     * @param studentId identyfikator studenta
     * @return lista aktywnych zapisów
     */
    List<Zapis> pobierzAktywneZapisyStudenta(Integer studentId);

    /**
     * Pobiera zapisy studenta w danym roku akademickim.
     * @param studentId identyfikator studenta
     * @param rokAkademicki rok akademicki (np. "2024/2025")
     * @return lista zapisów w danym roku
     */
    List<Zapis> pobierzZapisyStudentaWRoku(Integer studentId, String rokAkademicki);

    /**
     * Sprawdza czy student jest zapisany na dany przedmiot.
     * @param studentId identyfikator studenta
     * @param przedmiotId identyfikator przedmiotu
     * @return true jeśli student jest zapisany
     */
    boolean czyStudentZapisany(Integer studentId, Integer przedmiotId);

    /**
     * Liczy ilość zapisów na dany przedmiot.
     * @param przedmiotId identyfikator przedmiotu
     * @return liczba zapisów
     */
    Long policzZapisyNaPrzedmiot(Integer przedmiotId);

    /**
     * Zapisuje nowy zapis do bazy danych.
     * @param zapis encja do zapisania
     */
    void zapisz(Zapis zapis);

    /**
     * Aktualizuje istniejący zapis.
     * @param zapis encja do aktualizacji
     * @return zaktualizowana encja
     */
    Zapis aktualizuj(Zapis zapis);

    /**
     * Usuwa zapis z bazy danych.
     * @param zapis encja do usunięcia
     */
    void usun(Zapis zapis);

    /**
     * Usuwa zapis po identyfikatorze.
     * @param id identyfikator zapisu do usunięcia
     */
    void usunPoId(Integer id);

    /**
     * Zmienia status zapisu.
     * @param zapisId identyfikator zapisu
     * @param nowyStatus nowy status
     */
    void zmienStatus(Integer zapisId, String nowyStatus);
}
