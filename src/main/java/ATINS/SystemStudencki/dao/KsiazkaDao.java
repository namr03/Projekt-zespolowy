package ATINS.SystemStudencki.dao;

import ATINS.SystemStudencki.model.Ksiazka;
import java.util.List;

/**
 * Interfejs DAO dla encji Ksiazka.
 * Definiuje operacje dostępu do danych książek w systemie bibliotecznym.
 */
public interface KsiazkaDao {

    /**
     * Pobiera książkę po identyfikatorze.
     * @param id identyfikator książki
     * @return książka lub null jeśli nie znaleziono
     */
    Ksiazka pobierzPoId(Integer id);

    /**
     * Pobiera wszystkie książki.
     * @return lista wszystkich książek
     */
    List<Ksiazka> pobierzWszystkie();

    /**
     * Pobiera dostępne książki (gdzie dostepna = true i ilosc > 0).
     * @return lista dostępnych książek
     */
    List<Ksiazka> pobierzDostepneKsiazki();

    /**
     * Pobiera książkę po numerze ISBN.
     * @param isbn numer ISBN książki
     * @return książka lub null jeśli nie znaleziono
     */
    Ksiazka pobierzPoIsbn(String isbn);

    /**
     * Wyszukuje książki po tytule (częściowe dopasowanie).
     * @param tytul tytuł lub jego fragment
     * @return lista pasujących książek
     */
    List<Ksiazka> wyszukajPoTytule(String tytul);

    /**
     * Wyszukuje książki po autorze (częściowe dopasowanie).
     * @param autor autor lub jego fragment
     * @return lista pasujących książek
     */
    List<Ksiazka> wyszukajPoAutorze(String autor);

    /**
     * Pobiera niedostępne książki (wszystkie egzemplarze wypożyczone).
     * @return lista niedostępnych książek
     */
    List<Ksiazka> pobierzNiedostepneKsiazki();

    /**
     * Zapisuje nową książkę.
     * @param ksiazka książka do zapisania
     */
    void zapisz(Ksiazka ksiazka);

    /**
     * Aktualizuje istniejącą książkę.
     * @param ksiazka książka do aktualizacji
     * @return zaktualizowana książka
     */
    Ksiazka aktualizuj(Ksiazka ksiazka);

    /**
     * Usuwa książkę.
     * @param ksiazka książka do usunięcia
     */
    void usun(Ksiazka ksiazka);

    /**
     * Usuwa książkę po identyfikatorze.
     * @param id identyfikator książki do usunięcia
     */
    void usunPoId(Integer id);

    /**
     * Zmniejsza ilość dostępnych egzemplarzy książki o 1.
     * @param id identyfikator książki
     */
    void zmniejszIlosc(Integer id);

    /**
     * Zwiększa ilość dostępnych egzemplarzy książki o 1.
     * @param id identyfikator książki
     */
    void zwiekszIlosc(Integer id);

    /**
     * Zlicza wszystkie książki w systemie.
     * @return liczba książek
     */
    long zliczWszystkie();
}
