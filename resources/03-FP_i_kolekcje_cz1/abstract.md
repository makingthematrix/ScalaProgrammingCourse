# Wprowadzenie do programowania funkcyjnego

Może to powinno być po wykładzie o Scala Collections? Albo połączyć te dwa wykłady?

### Plan wykładu
* Funkcje jako dane
  * Co to jest funkcja (postać def i val)
  * Funkcje anonimowe
  * Przekazywanie funkcji jako parametrów
  * Funkcje częściowe i totalne
  * Zwracanie i składanie funkcji (generatory, currying)
* System typów
  * Higher Kinded Types na przykładzie Seq
  * Option jako alternatywa dla nullability - napisać własne Option
  * Covariance i contravariance na przykładzie producenta i konsumenta
  * Inlay hints + X-Ray
* Przykład z "Many Happy Early Returns"
  * Wersja imperatywna
  * Omówienie kodu wspólnego dla wszystkich wersji
  * Wersja naiwna FP, za pomocą find i map
  * Wersja FP wykorzystująca funkcje częściowe - collectFirst
  * Wersja FP wykorzystująca collectFirst + unapply
  * Skomplikowana wersja imperatywna
  * Skomplikowana wersja FP
  * Refaktoryzacja przykładu FP z wykorzystanie Higher Kinded Types
* Jak korzystać z AI Assistant (ewentualnie można z tego zrobić osobny wykład)
  * Chat
  * Code completion

### Notatki:
* [IntelliJ IDEA x Scala: Inlay Hints and X-Ray Mode](https://www.youtube.com/watch?v=akKLlEcCSBg)
* 