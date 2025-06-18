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

```scala
def doStuffAsynchronously(arg: Arg, callMeLater: (retVal: RetVal) => Unit): Unit = // callMeLater to callback
to do zrozumienia wymaga rozumienia higher order functions czyli że możesz coś co jest dla nowokolegi blokiem kodu przesunąć do przestrzeni wartości, które dla nowokolegów z reguły oznaczają jakieś liczby czy stringi czy może haszmapki i listy, przekazać to jako wartość i następnie ktoś kiedyś Ci to odpali z jakimś argumentem typu RetVal
def doStuffAsynchronously(arg: Arg): js.Promise[RetVal] = // api scala.js bo nasze Future jest jeszcze bardziej złożone
tu do zrozumienia musisz rozumieć HOF plus zrozumieć, że ktoś może zbudować łańcuszek takich funkcji jako wartości powsadzanych w pudełka z innymi HOF służącymi do komponowania pudełek, to jest nietrywialny skok, pamiętam jak usiłowałem zrozumieć co to jest ten Promise w js po roku pisania w nope.js z callbackami i nie było to oczywiste dopóki nie wziąłem q, nie wsadziłem w niego console.logi i nie zobaczyłem co się dzieje w runtime
def doStuffAsynchronously(arg: Arg)(using ExecutionContext): Future[RetVal] = // nagle jeszcze jakiś kontekst?
tu do zrozumienia potrzebujesz to co wyżej plus fakt, że Future odpala na różnych wątkach i że kiedy robisz map to potrzeba EC, a jak robisz Future.successful to nie i dlaczego plus mnóstwo interesujących patodoświadczeń gdzie użyjesz czegoś mutowalnego w kontekście gdzie lecą futurki i nagle shit gets real very hard
def doStuffAsynchronously(arg: Arg): IO[RetVal] = // no niby najprościej ALE
żeby zrozumieć co się dzieje tutaj musisz zrozumieć WSZYSTKO co było wcześniej PLUS zrozumieć suspension czyli jakie wyrażenia są referentially transparent, a jakie nie są
bonus: dlaczego Ox i loom:
def doStuff(arg: Arg): RetVal = ???
```