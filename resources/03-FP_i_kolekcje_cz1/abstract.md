# Wprowadzenie do programowania funkcyjnego

### Plan wykładu
* Funkcje jako dane
  * Co to jest funkcja (postać def i val)
  * Funkcje anonimowe
  * Przekazywanie funkcji jako parametrów
  * Funkcje częściowe i totalne
* Rodzaje kolekcji
  * Seq (wspomnieć o Array, Iterable i Vector)
  * List (wspomnieć o użyciu w rekurencji i pattern matching)
  * Set, Map
* System typów
  * Higher Kinded Types na przykładzie Seq
  * Option jako alternatywa dla nullability
  * Inlay hints + X-Ray
* Przykład z "Many Happy Early Returns"
  * Wersja imperatywna
  * Omówienie kodu wspólnego dla wszystkich wersji
  * Wersja naiwna FP, za pomocą find i map
  * Wersja FP wykorzystująca funkcje częściowe - collectFirst
  * Wersja FP wykorzystująca collectFirst + unapply


### Notatki:
* [IntelliJ IDEA x Scala: Inlay Hints and X-Ray Mode](https://www.youtube.com/watch?v=akKLlEcCSBg)

Nie zdążyłem opowiedzieć o:
* Zwracanie i składanie funkcji (generatory, currying)
* Covariance i contravariance na przykładzie producenta i konsumenta
* Refaktoryzacja przykładu early returns FP z wykorzystanie Higher Kinded Types
  * Skomplikowana wersja imperatywna
  * Skomplikowana wersja FP
* Jak korzystać z AI Assistant 