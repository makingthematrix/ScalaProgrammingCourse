# Programowanie w języku Scala

# Informacje ogólne

| Kod przedmiotu: |  |
| :---- | :---- |
| Kod Erasmus / ISCED: |  |
| Nazwa przedmiotu: | Programowanie w języku Scala |
| Jednostka: | [Wydział Matematyki, Informatyki i Mechaniki](https://usosweb.uw.edu.pl/kontroler.php?_action=katalog2/jednostki/pokazJednostke&kod=10000000) |
| Grupy: | [Przedmioty obieralne narzędziowe dla informatyki](https://usosweb.uw.edu.pl/kontroler.php?_action=katalog2/przedmioty/szukajPrzedmiotu&method=faculty_groups&jed_org_kod=10000000&grupaKod=1000-OBIER-N) |
| Punkty ECTS i inne: | 4.00 |
| Język prowadzenia: | polski |
| Wymagania (lista przedmiotów): | [Wstęp do programowania](https://usosweb.uw.edu.pl/kontroler.php?_action=katalog2/przedmioty/pokazPrzedmiot&prz_kod=1000-211bWPI) 1000-211bWPI |
| Założenia | Grupą docelową są studenci 2go lub 3go roku. Znają już przynajmniej jeden język programowania – np. Java, Python lub C/C++. Potrafią korzystać z IDE (choć niekoniecznie z IntelliJ IDEA), ale prawdopodobnie mają niewielkie lub zerowe doświadczenie w pracy jako programiści.  |
|  |  |
| Typ zajęć | Wykłady (13-15 x 1.5h) \+ projekt na zaliczenie |
|  |  |

# Skrócony opis

Scala to język programowania łączący wielozadaniowość ekosystemu JVM z ekspresywnością i bezpieczeństwem programowania funkcyjnego, oraz z najnowszymi osiągnięciami w dziedzinie projektowania języków programowania. Za jego rozwój  odpowiada zespół pracujący na École Polytechnique Fédérale de Lausanne (EPFL) w Szwajcarii, prowadzony przez twórcę Scali, prof. Martina Odersky’ego. Do najważniejszych zastosowań Scali należą platformy streamingowe, oprogramowanie serwerów www, oraz data mining.

# Pełny opis

Po zakończeniu kursu student powinien być w stanie używać Scali do tworzenia prostych, ale praktycznych aplikacji, takich jak np. aplikacja webowa przyjmująca dane od użytkownika, zapisująca je, wyświetlająca oraz umożliwiająca ich modyfikację i usunięcie (inne możliwe przykłady: aplikacja desktopowa, aplikacja na Androida, gra wideo). Powinien znać składnię Scali, podstawowe pojęcia programowania funkcyjnego oraz ich implementację w Scali, a także potrafić zaplanować i skonfigurować projekt w Scali oraz rozwijać go jako programista pracujący w zespole.

Na zajęciach omówione zostaną między innymi następujące zagadnienia:

1. **Składnia Scali**: val vs var, kolekcje niemutowalne vs mutowalne, case class, case object, companion object, sealed trait, enum, apply i unapply, dopasowanie wzorców (pattern matching).  
2. **Główne pojęcia programowania funkcyjnego:** funkcje jako dane, niemutowalność, leniwość (lazy evaluation), system typów.   
3. **Główne metody operacji na kolekcjach danych:** filter, map, collect, find, collectFirst, flatMap, fold.  
4. **System kontroli wersji** na przykładzie systemu git. Komendy: init, clone, checkout, branch, commit, push. Rozwiązywanie konfliktów za pomocą merge i rebase. Omówienie licencji open source, jak napisać README, do czego służy .gitignore, jak zrobić code review, co to są GitHub Actions.  
5. **Budowa aplikacji webowej w Play Framework.**   
6. **Futures, async/await, strumienie zdarzeń, model aktorów, Akka/Pekko.**   
7. **Rekurencja:** rekurencja ogonowa (tailrec), trampoliny. Zaawansowane dopasowanie wzorców: przypomnienie enum i unapply; jak zbudować i manipulować drzewem binarnym.   
8. **Wprowadzenie do debuggera** oraz innych funkcji IntelliJ IDEA pomocnych przy refaktoryzacji, uzupełnianiu kodu itd.  
9. **Monady:**  Teoria, obsługa błędów przy użyciu Option/Either/Try, monada IO w Cats Effect.  
10. **Mapa drogowa dalszej nauki:** Omówienie głównych stron www, kanałów YouTube itd. Przegląd głównych dziedzin rozwoju oprogramowania i tego, jakie frameworki i biblioteki Scali je wspierają: parsowanie JSON, ORM, obsługa żądań HTTP, narzędzia budowania, frameworki GUI, frameworki webowe, testowanie.

# Literatura

1. “Functional Programming in Scala, Second Edition”, 2023, Michael Pilquist, Rúnar Bjarnason, and Paul Chiusano ([https://www.manning.com/books/functional-programming-in-scala-second-edition](https://www.manning.com/books/functional-programming-in-scala-second-edition))  
2. Interaktywny kurs “Functional Programming in Scala”, JetBrains ([https://plugins.jetbrains.com/plugin/23833-functional-programming-in-scala](https://plugins.jetbrains.com/plugin/23833-functional-programming-in-scala))

# Metody i kryteria oceniania

Forma: projekt programistyczny.

Zadaniem studentów będzie sformowanie 3-5 osobowych zespołów programistycznych, a następnie wybór projektu, założenie repozytorium na platformie GitHub i zaimplementowanie wielopoziomowej aplikacji (np. aplikacja webowa, przyjmująca dane od użytkownika, zapisująca je, wyświetlająca oraz umożliwiająca ich modyfikację i usunięcie, aplikacja desktopowa o podobnej strukturze, aplikacja mobilna na system Android, prosta gra komputerowa, itp.   
Ocenie podlegać będzie nie tylko końcowy efekt, ale również praca zespołowa (podział zadań, komunikacji między członkami zespołu), jakość kodu, oraz obecność i jakość testów. Pośrodku semestru, oraz na ostatnich zajęciach, studenci będą mieli okazję zaprezentować swój projekt.

