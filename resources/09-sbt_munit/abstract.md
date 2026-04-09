# Kompilator + Build tools

### Plan wykładu
* Kompilator Scali
  * Linia poleceń
  * Najważniejsze opcje
* sbt
  * Stworzenie prostego projektu w IntelliJ IDEA + Scala Plugin
  * Omówienie podstawowych poleceń
  * Zarządzanie zależnościami
    * Podział na main i test
  * Przykład bardziej zaawansowanego pliku build.sbt na podstawie jakiegoś większego projektu
  * project/build.properties
  * Pluginy do sbt - jak dodawać, jak używać
    * Dygresja: scalafix plugin
  * Wsparcie Scala Plugin dla sbt
* Mill (ten fragment może być w oparciu o film na YT na ten temat)
  * Omówienie Milla na podstawie prelekcji Li Haoyi na ten temat
  * Przykład konfiguracji: biblioteka OSLib
  * Tabelka porównująca feature'y sbt i Mill
  * Krótkie omówienie BSP
* ScalaCLI
  * Powody dlaczego powstało ScalaCLI
    * Wspomnieć o ScalaREPL i Ammonite
  * Przykład: może Scalatheque jeśli zdążę, albo inny prosty ale nietrywialny projekt
  * Linia poleceń i opcje
  * Tabelka porównująca feature'y sbt, Mill i ScalaCLI
  * Podkreślić różnice w zastosowaniu ScalaCLI, a sbt i Mill
* Gradle
  * Ogólne omówienie Gradle
    * Wspomnieć, że Gradle jest w Scala Advisory Board
  * Scala plugin i Scala Android plugin
  * Przykład: szablonowa aplikacja LibGDX
  * Przykład: szablonowa aplikacja Android
  * Tabelka porównująca feature'y sbt, Mill, ScalaCLI i Gradle