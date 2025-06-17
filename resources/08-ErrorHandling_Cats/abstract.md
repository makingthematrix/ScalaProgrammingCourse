# Monady

### Wymagania:
* Dla tematu Option/Either potrzebna jest znajomość total vs partial functions
* Dla tematu monady IO potrzebna jest znajomość by-name parameters

### Plan wykładu
* Koncepcja monady
  * Konstruktor (unit)
  * Wartość
  * Metoda bind (flatMap)
* Option
  * Zastosowanie w obsłudze błędów
  * Przykład praktyczny
* Either
  * Zastosowanie w obsłudze błędów
  * Przykład praktyczny
* Try
  * Zastosowanie w obsłudze błędów
  * Przykład praktyczny
* Wyjaśnienie składni for/yield
  * Porównanie z użyciem for/yield dla kolekcji
  * Refaktoryzacja powyższych przykładów (zwłaszcza Option) przy użyciu for/yield
* Prawa monadyczne
  * Left identity
  * Right identity
  * Associativity
  * Jak dzięki zachowaniu tych praw kompilator może przepisać for/yield na flatMap
* Monada IO
  * Wprowadzenie do Cats System 3
  * Przykład praktyczny z czytaniem i pisaniem do pliku
    * Wersja imperatywna
    * Refaktoryzacja do wersji FP

### Notatki
* "IO to takie () => Future[A] owrapowane w pudełko z unsafeRunSync itp", Leszek Biały