# Programowanie w języku Scala

## Plan kursu

**Długość kursu:** 13 x 1,5 godziny 

**Grupa docelowa:** Studenci 2go lub 3go roku. Znają już przynajmniej jeden język programowania – np. Java, Python lub C/C++. Potrafią korzystać z IDE (choć niekoniecznie z IntelliJ IDEA), ale prawdopodobnie mają niewielkie lub zerowe doświadczenie w pracy jako programiści.

**Skrócony opis:** Scala to język programowania łączący wielozadaniowość ekosystemu JVM z ekspresywnością i bezpieczeństwem języków funkcyjnych, oraz z najnowszymi osiągnięciami w dziedzinie projektowania języków programowania. Za jego rozwój  odpowiada zespół pracujący na École Polytechnique Fédérale de Lausanne (EPFL) w Szwajcarii, prowadzony przez twórcę Scali, prof. Martina Odersky’ego. Do najważniejszych zastosowań Scali należą platformy streamingowe, oprogramowanie serwerów www, oraz data mining.

**Cele:** Po zakończeniu kursu student powinien być w stanie używać Scali do tworzenia prostych, ale praktycznych aplikacji, takich jak np. aplikacja webowa przyjmująca dane od użytkownika, zapisująca je, wyświetlająca oraz umożliwiająca ich modyfikację i usunięcie (inne możliwe przykłady: aplikacja desktopowa, aplikacja na Androida, gra wideo). Powinien znać składnię Scali, podstawowe pojęcia programowania funkcyjnego oraz ich implementację w Scali, a także potrafić zaplanować i skonfigurować projekt w Scali oraz rozwijać go jako programista pracujący w zespole.

**Omawiane narzędzia, frameworki i biblioteki:** Standardowa biblioteka Scali, IntelliJ IDEA \+ Scala Plugin, sbt, GitHub, Play Framework, Akka/Pekko, Cats Effect, ekosystem Li Haoyi. **Warto wspomnieć o:** ZIO, JavaFX/ScalaFX, mill, ScalaCLI, Tapir, Akka HTTP, Scalatra, LibGDX.

**Zaliczenie:** Zadaniem studentów będzie sformowanie 3-5 osobowych zespołów programistycznych, a następnie wybór projektu, założenie repozytorium na platformie GitHub i zaimplementowanie wielopoziomowej aplikacji (np. aplikacja webowa, przyjmująca dane od użytkownika, zapisująca je, wyświetlająca oraz umożliwiająca ich modyfikację i usunięcie, aplikacja desktopowa o podobnej strukturze, aplikacja mobilna na system Android, gra komputerowa, itp.   
Ocenie podlegać będzie nie tylko końcowy efekt, ale również praca zespołowa (podział zadań, komunikacji między członkami zespołu), jakość kodu, oraz obecność i jakość testów. Pośrodku semestru, oraz na ostatnich zajęciach, studenci będą mieli okazję zaprezentować swój projekt.

Plan wykładów:

**Składnia Scali.** Zacznijmy od pokazania, jak stworzyć nowy projekt Scali w IntelliJ IDEA. Pojęcia: val vs var, kolekcje niemutowalne vs mutowalne, case class, case object, companion object, sealed trait, enum, apply i unapply, dopasowanie wzorców (pattern matching).

**Główne pojęcia programowania funkcyjnego:** funkcje jako dane, niemutowalność, leniwość (lazy evaluation), system typów. Proste przykłady dla każdego z tych pojęć.

**Kolekcje Scali:** filter, map, collect, find, collectFirst, flatMap, fold. Przykłady i wizualizacje użycia każdej z tych metod (infografiki, animacje, live coding).

**git i GitHub.** Komendy: init, clone, checkout, branch, commit, push. Rozwiązywanie konfliktów za pomocą merge i rebase. Omówienie licencji open source, jak napisać README, do czego służy .gitignore, jak zrobić code review, co to są GitHub Actions.

**Projekt.** Podział na zespoły, wybór tematu, konfiguracja projektu. Omówienie zasad oceniania: liczy się nie tylko gotowa aplikacja, ale też jakość kodu i zaangażowanie. W drugiej części wykładu omówienie pracy zespołowej: Agile, Scrum, Kanban, GitHub Boards, Trello, JIRA, YouTrack.

**Budowa aplikacji webowej w Play Framework.** Jeden wykład w całości poświęcony stworzeniu od zera prostej strony internetowej z zapisem danych (baza danych lub pliki JSON) i frontendem. Pokazanie, jak zaplanować projekt w Scali i jak połączyć komponenty np. przez wstrzykiwanie zależności i leniwą inicjalizację.

**Futures, async/await, strumienie zdarzeń, model aktorów, Akka/Pekko.** Przykład: aplikacja typu messenger na Androida. Aplikacja musi reagować na dane z wielu źródeł: użytkownika, systemu operacyjnego i serwera.

**Rekurencja:** rekurencja ogonowa (tailrec), trampoliny. Zaawansowane dopasowanie wzorców: przypomnienie enum i unapply, a potem pokazanie, jak zbudować i manipulować drzewem binarnym. Wprowadzenie do debuggera oraz innych funkcji IntelliJ IDEA pomocnych przy refaktoryzacji, uzupełnianiu kodu itd.

**W połowie między startem projektów a zakończeniem:** krótkie prezentacje postępów w projektach i dyskusja o nich (jak wygląda praca zespołowa, jakość kodu, wybrane rozwiązania, interesujące błędy i jak zostały znalezione i naprawione, itp.)

**Monady:**  Teoria, obsługa błędów przy użyciu Option/Either/Try, monada IO w Cats Effect.

**Mapa drogowa dalszej nauki, czyli gdzie szukać materiałów edukacyjnych o Scali.** Omówienie głównych stron www, kanałów YouTube itd. Przegląd głównych dziedzin rozwoju oprogramowania i tego, jakie frameworki i biblioteki Scali je wspierają: parsowanie JSON, ORM-y (ze szczególnym uwzględnieniem ANORM), obsługa żądań HTTP, narzędzia budowania, frameworki GUI, frameworki webowe, testowanie.

**Labirynty z użyciem leniwych list (wykład dodatkowy).** Chcę dać studentom więcej czasu na dokończenie projektów i przygotowanie do egzaminu. Jeśli zdecydują się na dodatkową wiedzę, mogą wziąć udział w wykładzie o leniwych listach w Scali i o tym, jak można ich użyć do generowania plansz do gier komputerowych, lub „labiryntów”, z książki [http://www.mazesforprogrammers.com/](http://www.mazesforprogrammers.com/).

**Końcowe prezentacje projektów.**

Informacje dodatkowe: 

* Można zareklamować studentom plugin JetBrains Academy oraz kurs „Functional Programming in Scala”.  
* Zróbmy na początku ankietę, jakie języki programowania znają studenci, aby nie tracić czasu na rzeczy, które rozpoznają z tych języków. 

Opcjonalne tematy:
* Testowanie (ScalaTest, mUnit, ScalaMock)
* ScalaDoc (pisanie, generowanie statycznych stron www)
