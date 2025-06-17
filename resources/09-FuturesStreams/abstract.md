# Futures, async/await, Event Streams

### Wymagania:
* Znajomość notacji for/yield

### Plan wykładu
* Krótkie wprowadzenie do wątków na JVM
* Koncepcja Future/Promise
  * Jak zaimplementować Future własnoręcznie (slajdy lub live coding)
  * Jak rozszerzyć implementację do cancellable Future
* Alternatywy dla Future
  * Koncepcja async/await 
  * Dygresja nt suspend w Kotlinie
  * Omówienie direct style w Scali 3
  * Omówienie biblioteki Ox
* Wprowadzenie do Observer pattern
  * Czas życia event streamu: subskrypcja, publikacja, desubskrypcja
  * Dygresja nt diagramu do przedstawiania czasu życia (podać inne przykłady użycia)
  * Klasyczny observer pattern z jednym producentem vs event stream z wieloma producentami
  * Przykłady użycia event streamów: bazy danych, http requests, aplikacje desktopowe, aplikacje mobilne... (co jeszcze?)
* Implementacja event stream
  * Krótkie omówienie biblioteki Signals3
  * Przykład użycia: Wire

### Notatki
Jakie są alternatywy i analogi dla Future i event streams w Javie?