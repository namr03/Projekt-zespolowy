INSERT INTO student (nr_indeksu, pesel, imie, nazwisko, email, login, haslo, adres, rok_studiow)
VALUES
('7911', '93010112345', 'Adam', 'Kowalski', 'adam.kowalski@atins.pl', 'akowalski', '1234', 'Wrocław, ul. Legnicka 2', 3),
('8999', '90120554321', 'Anna', 'Nowak', 'anna.nowak@atins.pl', 'anowak', '1234', 'Wrocław, ul. Grabiszyńska 10', 2),
('9999', '99052957279', 'Krzysztof', 'Malarz', 'krzysztof.malarz@atins.pl', 'kmalarz', '1234', 'Wrocław, ul. Zachodnia 4', 1);

INSERT INTO wykladowca (imie, nazwisko, tytul_naukowy, email, login, haslo)
VALUES
('Piotr', 'Pawłowski', 'dr inż.', 'piotr.pawlowski@atins.pl', 'ppawlowski', '1234'),
('Paweł', 'Piotrowski', 'dr inż.', 'pawel.piotrowski@atins.pl', 'ppiotrowski', '1234'),
('Ewa', 'Pajor', 'magister', 'ewa.pajor@atins.pl', 'epajor', '1234');

INSERT INTO przedmiot (nazwa, ects, semestr, opis, limit_miejsc)
VALUES
('Analiza Matematyczna', 4, 'Zima 2025', 'Przedmiot matematyczny', 30),
('Grafika Wektorowa', 5, 'Lato 2025', 'Przedmiot zawodowy', 20),
('JAVA I', 5, 'Zima 2024', 'Przedmiot zawodowy', 20);

INSERT INTO sylabus (id_przedmiot, nazwa, tresc)
VALUES
(1, 'Sylabus Analiza Matematyczna', 'To jest sylabus do przedmiotu...'),
(2, 'Sylabus Grafika Wektorowa', 'To jest sylabus do przedmiotu...'),
(3, 'Sylabus JAVA I', 'To jest sylabus do przedmiotu...');

INSERT INTO plan_zajec (id_przedmiot, id_wykladowca, dzien_tygodnia, godzina_start, godzina_koniec, sala, typ)
VALUES
(2, 1, 'Poniedziałek', '10:10:00', '11:40:00', '2.04', 'WYKLAD'),
(1, 2, 'Wtorek', '08:30:00', '10:00:00', '3.11', 'ĆWICZENIA'),
(3, 3, 'Środa', '08:00:00', '09:30:00', '1.05', 'LABORATORIUM');

INSERT INTO zapis (id_student, id_przedmiot, data_zapisu, rok_akademicki, status)
VALUES
(1, 1, '2025-09-29', '2025/2026', 'PRZYJĘTY'),
(1, 2, '2025-09-29', '2025/2026', 'PRZYJĘTY'),
(1, 3, '2025-09-29', '2025/2026', 'NIEPRZYJĘTY'),
(2, 1, '2025-09-30', '2025/2026', 'PRZYJĘTY'),
(2, 2, '2025-09-30', '2025/2026', 'OCZEKUJE'),
(2, 3, '2025-09-30', '2025/2026', 'OCZEKUJE'),
(3, 1, '2025-10-01', '2025/2026', 'OCZEKUJE'),
(3, 2, '2025-10-01', '2025/2026', 'PRZYJĘTY'),
(3, 3, '2025-10-01', '2025/2026', 'OCZEKUJE');

INSERT INTO ocena (id_zapis, wartosc, kategoria, komentarz, data_wystawienia)
VALUES
(1, 4.5, 'CZĄSTKOWA', 'Kolokwium 1', '2025-11-15'),
(1, 3.0, 'CZĄSTKOWA', 'Kolokwium 2', '2026-02-01'),
(1, 4.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-15'),
(2, 3.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-11-20'),
(2, 4.0, 'CZĄSTKOWA', 'Kolokwium 2', '2026-02-07'),
(2, 2.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-28'),
(3, 5.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-12-15'),
(3, 3.5, 'CZĄSTKOWA', 'Kolokwium 2', '2026-02-03'),
(3, 4.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-10'),
(4, 3.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-11-30'),
(4, 3.5, 'CZĄSTKOWA', 'Kolokwium 2', '2026-01-010'),
(4, 4.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-10'),
(5, 3.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-12-20'),
(5, 4.5, 'CZĄSTKOWA', 'Kolokwium 2', '2026-01-20'),
(5, 3.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-20'),
(6, 4.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-11-12'),
(6, 3.0, 'CZĄSTKOWA', 'Kolokwium 2', '2026-01-10'),
(6, 4.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-26'),
(7, 2.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-12-20'),
(7, 5.0, 'CZĄSTKOWA', 'Kolokwium 2', '2026-01-15'),
(7, 3.5, 'KOŃCOWA', 'Ocena końcowa', '2026-02-10'),
(8, 4.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-12-12'),
(8, 3.0, 'CZĄSTKOWA', 'Kolokwium 2', '2026-01-12'),
(8, 3.5, 'KOŃCOWA', 'Ocena końcowa', '2026-02-12'),
(9, 4.0, 'CZĄSTKOWA', 'Kolokwium 1', '2025-12-11'),
(9, 3.5, 'CZĄSTKOWA', 'Kolokwium 2', '2026-02-01'),
(9, 4.0, 'KOŃCOWA', 'Ocena końcowa', '2026-02-22');

INSERT INTO ksiazka (tytul, autor, isbn, ilosc, dostepna)
VALUES
('Czysty Kod', 'Robert C. Martin', '978-83-283', 20, TRUE),
('Dzieci z Bulerbyn', 'Mark Twin', '997-998-999', 100, FALSE),
('Podstawy JAVA', 'Krzysztof Columb', '999-779-889', 30, TRUE),
('C#-od zera do średniaka', 'Lucjan Bareja', '98-831-282', 10, TRUE),
('Matematyka-czyli jak zająć sobie czas', 'Kamil Jordanesku', '10-10-483', 2, TRUE),
('Poradnik typera', 'Zbigniew Kartka', '240-020-200', 200, FALSE);

INSERT INTO wypozyczenie (id_student, id_ksiazka, data_wypozyczenia, termin_zwrotu, data_oddania, status)
VALUES (1, 2, '2025-12-20', '2026-12-20', '', 'WYPOZYCZONA'),
VALUES (2, 2, '2025-10-20', '2026-03-20', '', 'WYPOZYCZONA'),
VALUES (2, 1, '2025-11-20', '2026-11-20', '2025-11-22', 'ZWRÓCONA'),
VALUES (3, 6, '2026-01-04', '2026-04-04', '2026-02-02', 'ZWRÓCONA'),
VALUES (3, 5, '2026-01-20', '2026-05-20', '', 'WYPOZYCZONA');

INSERT INTO platnosc (id_student, tytul, kwota, opis, data_wplaty, status)
VALUES (1, 'Czesne', 5000.00, 'Wpłata za semestr zimowy', '2024-09-25', 'ZAKSIEGOWANA'),
VALUES (1, 'Czesne', 5300.00, 'Wpłata za semestr zimowy', '2025-10-02', 'ZAKSIEGOWANA'),
VALUES (2, 'Czesne', 5000.00, 'Wpłata za semestr letni', '2025-03-01', 'ZAKSIEGOWANA'),
VALUES (3, 'Czesne', 5700.00, 'Wpłata za semestr zimowy', '2025-09-29', 'ZAKSIEGOWANA'),
VALUES (3, 'Czesne', 4999.00, 'Wpłata za semestr letni', '2026-02-28', 'ZAKSIEGOWANA');

INSERT INTO powiadomienie (id_student, tytul, tresc, data_wyslania)
VALUES (1, 'Zalegasz z płatnościami', 'Przypominamy o zapłaceniu za semestr', '2025-10-01');
VALUES (1, 'Pomyłka', 'Jednak nie zalegasz z płatnościami', '2025-10-20');
VALUES (2, 'Udanej sesji', 'Do zobaczenia w kolejnym semestrze', '2026-02-10');
VALUES (2, 'Pospiesz się z płatnością', 'Uczelnia potrzebuje pieniędzy na prąd i ogrzewanie', '2025-10-01');
VALUES (3, 'Wymierz przedmioty', 'Zapisz się na przedmioty w ramach kolejnego semestru', '2025-09-20');
VALUES (3, 'Zalegasz z płatnościami', 'Zapłać za kolejny semestr', '2026-02-28');
