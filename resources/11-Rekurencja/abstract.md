# Rekurencja

### Wymagania:
* Do wyjaśnienia trampolin potrzebna jest znajomość by-name parameters
* Do przykładu z implementacją drzewa binarnego potrzebna jest znajomość enums vs sealed traits
* Trampoliny w wersji for/yield wymagają znajomości for/yield (z wykładu o monadach)

### Plan wykładu
* Przykłady struktur danych i zastosowań, w których przydaje się rekurencja
  * Lista (struktury danych z zapisem O(1), journal, alokacja pamięci)
  * Drzewo binarne (struktury danych z wyszukiwaniem O(log n), systemy plików, systemy eksperckie)
  * Graf (sieci społecznościowe, gry komputerowe, modelowanie fizyczne i geograficzne)
* Jak działa rekurencja
  * Co to jest stos
  * Jak działa odkładanie na stosie
  * Kiedy następuje Stack Overflow Exception
* Przykłady
  * Silnia
  * Ciąg Fibonacciego
* Jak debugger pomaga w zrozumieniu działania pfunkcji rekurencyjnej
* Tail recurrency
  * Teoria
  * Te same dwa przykłady w nowej implementacji
* Trampoliny
  * Teoria
  * Te same dwa przykłady w nowej implementacji
  * Wersja for/yield
* Implementacja drzewa binarnego na enumach
  * Wersja hardcoded dla typu Int
  * Rekurencyjna unkcja print
  * Refaktoryzacja z Int do typu generycznego
  * Rekurencyjna funkcja add
  * Funkcja create napisana za pomocą foldLeft