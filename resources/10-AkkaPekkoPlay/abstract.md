# Akka, Pekko i Play Framework

### Wymagania:
* Znajomość Futures and Streams

### Plan wykładu
* Koncepcja aktora
* Zaimplementujmy aktora na podstawie Future i event streams
  * Zróbmy generator eventów, produkujący nowy event co dany czas t
    * Specjalny przypadek: generator pustych eventów (EventStream[Unit])
  * Dodajmy event stream i sami go zasubskrybujmy - subskrypcja będzie dodawać eventy do kolejki
  * Nowy pusty event uruchamia funkcję, która konsumuje eventy z kolejki i wykonuje działania
* Krótkie omówienie Akka i Pekko
* Przykład użycia Akka/Pekko (wybrać jedno)
  * może jakieś obliczenia rozproszone?
  * np. interfejs akka-http i łączenie się z nim curlem żeby wysłać plik CSV z danymi
  * backend parsuje dane, rozprasza na kilku aktorów, czeka na rezultaty i odsyła nowy plik CSV
  * można nawiązać do Protein Folding na PS3
* Gdzie używa się Akka i Pekko na produkcji?
  * m.in. w Play Framework, które będziemy omawiali na następnych zajęciach (albo już teraz)
* Wprowadzenie do Play Framework
  * Historia, przykłady użycia na produkcji
  * Omówienie przykładowej aplikacji z podziałem na komponenty:
    * Obsługa requestów
    * Połączenie z bazą danych (Slick, Anorm + wspomnieć o bardziej zaawansowanych alternatywach)
    * Generowanie statycznych stron html
  * Wspomnieć o innych frameworkach do budowy www (http4s, tapir, ...?)

### Notatki
* Przejrzeć tę prezentację: https://github.com/polyvariant/flavors-of-scala