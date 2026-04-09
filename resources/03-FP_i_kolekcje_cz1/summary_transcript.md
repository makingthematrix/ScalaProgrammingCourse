# Wykład 3



**Główne punkty:**

- Używaj niemutowalnych kolekcji i referencji w Scali, aby poprawić przewidywalność kodu i uniknąć nieoczekiwanych błędów.

- Zastąp tradycyjne pętle (for/while) i instrukcje `return` wczesnego wyjścia funkcjonalnymi operatorami kolekcji, takimi jak `map`, `filter`, `flatMap` i `collect`, aby pisać bardziej idiomatyczny kod Scali.

- Wykorzystaj `flatMap` do spłaszczania zagnieżdżonych kolekcji i do tworzenia wielu lub zero elementów wynikowych z jednego elementu wejściowego.

- Rozważ użycie mutable buffers (np. `ListBuffer`, `ArrayBuffer`, `HashMap`) jako „builderów” do efektywnego konstruowania kolekcji w sytuacjach wymagających wielu modyfikacji.

- Implementuj metody `unapply` w obiektach towarzyszących, aby ułatwić dopasowywanie wzorców i efektywne filtrowanie/transformowanie elementów kolekcji, zwłaszcza w połączeniu z `collectFirst`.

- Unikaj nadużywania `var` dla referencji do kolekcji i mutable kolekcji z mutable referencjami, ponieważ może to prowadzić do trudnych do wykrycia błędów i zmniejsza przejrzystość kodu.


#### Transkrypcja

Cześć, witam na kolejnym wykładzie. Poprzednio rozmawialiśmy o głównych typach danych, o operatorach, o składni, Scali, trochę również o tych właśnie o `class`, `trait`, Object, formach prywatności, no i generalnie tego, jak to wszystko ma się do Javy. Dzisiaj chciałbym kontynuować ten temat. Przejdziemy sobie dzisiaj przez kolekcje oraz o... przez właśnie pogadamy o podstawowych operacjach na kolekcjach, jak również o Total i Partial Functions oraz jak to się ma wszystko do pattern matchingu. Zacznijmy może od założenia sobie nowego projektu. Nazwijmy go po prostu early `return`. I napiszmy sobie jakiś tylko `pr`Int`ln`, "Hello world". 

Aby mi również było dzisiaj łatwiej, ustawię sobie set next edit suggestions. Kliknę sobie tutaj, pójdę do settingsów, włączymy. Creative, advanced, local, cloud and local, dobra. Wszystko powinno w miarę działać, zobaczymy. 

Zróbmy sobie ``case` `class ` user`. . Klasa będzie miała jakieś `id` typu `Int`, będzie miała name, string... nie, nil, name. String, ok. `email` też się przyda oraz `age` też typu `Int`.

I zróbmy sobie `val` `users`, która będzie jakimś tam właśnie `Seq` of `user`. I to będzie... no na przykład tak, niech będzie takich trzech. I możemy sobie teraz ich tutaj wydrukować. Tego fora już znacie.

Dobra. Wrócimy do niego i będziemy dzisiaj używać innych metod niż tego zwykłego w zwykłej pętli `for`. W każdym razie mamy tutaj pierwszą rzecz, którą chciałbym was zainteresować, to jest właśnie ten sequence of `users`. Sequence jest jedną z... jednym ze sposobów... jedną z podstawowych właśnie z tych kolekcji Scali. Inne możliwości byłoby... to byłoby właśnie array of `users`. To działałoby w sumie w dokładnie ten sam sposób, tylko że... o, tutaj trzeba zmienić.

Różnica jest tylko taka, że array jest właśnie prostym typem, który faktycznie działa tylko jako pewien taki wrapper wokół javowej tablicy. Natomiast `Seq` jest `trait`em.

Jeśli sobie wrócę tutaj... `Seq` to jest pewien... Tak, dokładnie, mogę sobie teraz... Control, bo tutaj może mi się wyświetli... Tak. `Seq` jest rodzajem... jest po prostu `trait`em, czyli tą cechą.

To nie jest jeszcze w środku, pod spodem. Mogę tworzyć... `Seq` będzie prawdopodobnie `Vector`, czasem będzie to lista i ewentualnie jakieś tam wersje tych dwóch głównych kolekcji.

 Jedyna, co jest ważne, to że właśnie `Seq` łączy taki jeszcze wyższy `trait` typu iterable, czyli że wszystkie kolekcje, które można po prostu po nich przejść, jeden po drugim, w jakiejś ciągłej, stałej kolejności, to są właśnie iterable.

`Seq` dodaje do tego dość dużo takich użytecznych metod. Array natomiast jest już takim prostym tylko wrapperem nad... nad właśnie tą...

Jest tylko wrapperem nad javową tablicą, więc jest bardziej performatywny, kiedy używamy go dla konkretnej takiej po prostu tablicy jakichś instancji, jakichś danych.  Natomiast to nie jest... no Wszelkie operacje na takiej tablicy no są siłą rzeczy w związku z tym dość ograniczone, ponieważ żeby cokolwiek z niej zrobić, tak naprawdę najczęściej po prostu ją bierzemy i kopiujemy, albo no generalnie najlepiej najlepiej nic nie robić poza właśnie iterowaniem na nią.

Jest to też taki rodzaj... Jest to też rodzaj kolekcji, którą trzymamy głównie dla właśnie jakiejś kompatybilności z Javą. Gdybyśmy jej nie chcieli, a chcielibyśmy, żeby nadal było performatywnie, prawdopodobnie właśnie użyłbym typu `Seq`, dlatego że z tego, co co wiem, pod spodem jest `Vector`. `Vector` to jest specjalistyczny właśnie... specjalistyczna klasa, która która właśnie jest również dość dość dobra, dość szybka do iterowania, ale właśnie jest również... ma te wszystkie metody, ma tam tą... jest w tej hierarchii klas Scali, w przeciwieństwie do array, która jest trochę tak bardziej na uboczu.

Inną jeszcze metodą... inną jeszcze `List`ą... właśnie, inną kolekcją jest jeszcze `List`, która jest również... która również dziedziczy po w tym wypadku abstract `Seq`, ale ma generalnie te same wszystkie... To jest trochę bardziej skomplikowane, nie chcę w to wchodzić, dlaczego abstract `Seq` a nie `Seq`. W każdym razie to jest... to działa w dokładnie taki sam sposób, mogę na przykład napisać `Seq` of `user` `List`.

Lista to jest lista... lista jednokierunkowa wtedy. Ona jest wolniejsza do iteracji. też Natomiast to, co ma fajnego, to możliwość właśnie... a jeżeli teraz zrobię, to możliwość prependowania, czyli dodawania nowych obiektów na początku. Jeżeli teraz robię na przykład `val` new `List` równa się `user` jakieś tam 4 derek

at derek com i 10, dobra, to mamy tego jednego użytkownika. Mogę go dodać takim operatorem dwóch dwukropków do obecnej listy. I to działa. New `List`. Tutaj. I jeśli teraz zrobię... I teraz to, co się tutaj stało, to właśnie to, że tak to jest nadal do tej listy, która jest zawiera tych trzech użytkowników od początku. Jakby ten wzięliśmy ten nowy element, dołączyliśmy go do przodu. Stara lista pozostała jak jest. Ten nowy element staje się jakby tym tym tą głową, tym pierwszym elementem listy. Jest to właśnie jakby O(1). W przypadku w przypadku innych innych innych tych kolekcji dodawanie nowych elementów z reguły jest jednak trochę bardziej skomplikowane, więc bardziej może O(n).

Poza tym oczywiście możecie też pomyśleć o tym, że cały czas mówimy o o listach, które są niemutowalne, więc ja tutaj mówię o tym, że dodaję jakiś element, tak naprawdę nie dodaję go, tworzę nową kolekcję, która ma wszystkie stare elementy plus ten jeden. No i w przypadku właśnie tablicy, w przypadku wektora to będzie to będzie polegało na przekopiowaniu zawartości takiej kolekcji plus dodaniu tego jednego elementu. W przypadku listy jest inaczej.

Właśnie to jest nadal... to jest po prostu... tablica polega na tym, że... znaczy lista polega na tym, że mamy po prostu uchwyt do tego pierwszego elementu, a ten pierwszy element ma uchwyty do wszystkich pozostałych, więc no jest to pod tym względem dużo szybsze.

Łatwiejsze jest również rozbijanie listy na fragmenty, no bo to tylko polega na tym, że ta referencja z jednego elementu do drugiego jest tam przecinana i bierzemy sobie tylko kawałek. Więc pod tym względem lista jest lepsza, powiedzmy.

Natomiast to, co jednak zazwyczaj się w Scali robimy, to jeżeli mamy już jakąś kolekcję, która jest niemutowalna, raczej będziemy się starali nie nie powodować... nie używać tych transformacji wszystkich tak dosłownie. Czyli nie będziemy po prostu dodawać do nich tych elementów, nie będziemy ich usuwać. Usuwać raczej będziemy wykorzystywać pewne metody standardowej z biblioteki i Scali i ona już pod spodem będzie to robiła. My możemy tam zaufać, że to jest w miarę performatywne.

Natomiast ważne tutaj słowo kluczowe, którego użyłem, to że na początku, że jeżeli już mamy taką kolekcję, to to właśnie działamy w ten sposób i o tym... i No bo dobra, opowiedzmy o tym teraz. Co jest w zasadzie możliwe? Możliwe jest na przykład, jeżeli mamy tą nową `List`ę i mamy 4, 1, 2, 3, możemy ich sobie posortować.

Możemy zrobić `val` new new `List` i to będzie new `List`. Tutaj po napisaniu kropki mamy właśnie całą `List`ę. Możecie sobie przejść po tych wszystkich, popatrzeć na na to, jaka jest... na dokumentację każdej z tych metod. Jest ich cała masa. Ja tutaj tak dla próby po prostu zrobimy sort with. Sorted wymagałoby orderingu. O tym jeszcze będziemy mówić na jednych późniejszych zajęciach. Zrobimy jednak sort with. Sort with. To, co tutaj potrzebujemy, to jest `user` pierwszy, `user` drugi. Porównujemy ich sobie jakoś, na przykład po `age`. I teraz 10, 25, 30, 28. Pamiętajcie, jaki był wtedy, jaka była kolejność. Teraz jest 10, 25, 28, 30.

Druga opcja jest sort by, ponieważ jakby... Jeżeli sort with jest taką metodą, która działa na wszystko, prawda? Jesteśmy po prostu... potrzebujemy podać tutaj taką funkcję jako ten parametr i ta funkcja zwraca nam true, jeżeli pierwszy z elementów podanych jako parametr do tej funkcji jest mniejszy od drugiego albo równy. I wtedy tylko jeżeli jest większy, to wtedy zamieniana jest kolejność odpowiednio z algorytmem tego sortowania.

Natomiast mamy takie... mamy w Scali także taką opcję, że pewne typy danych mają już pewne domyślne sortowanie i wtedy możemy użyć sort by. Możemy użyć sort by na przykład właśnie na ciągach znaków, na liczbach, na znakach pojedynczych. Natomiast nie możemy... mamy tutaj `List`ę `user`ów. Jeśli po prostu zrobię sort by tak, to to mi wyświetli błąd, że no sorry, no given instance of type ordering, czyli właśnie, że nie ma możliwości sortowania.

Natomiast to, co możemy jednak zrobić, to posortować na przykład w ten sposób. To jest taka... taki wildcard, taka zaślepka. Mogłoby być, że `user` hop, `user` `age`, ale ponieważ ten `user` jest... czyli to jest nasz parametr tej funkcji, to jest wynikiem tej funkcji jest po prostu wyciągnięcie tego `age` z tego `user`. Natomiast możemy to sobie skrócić. Zresztą w to takich przypadkach po prostu piszemy w ten sposób. OK, i to powinno nam dać dokładnie ten sam wynik, co poprzednio.

Tak. Jeżeli sama lista jest właśnie `List`ą takich elementów, na przykład możemy zrobić new `List` `Map` i to już będzie lista wtedy tych... to już będzie lista `Int`ów. Natomiast mogę teraz zrobić tutaj sorted w ogóle, ponieważ wiemy, jak posortować liczby, więc to sorted to jest już takie... generalnie już mamy ten ordering.

Natomiast gdybym chciał po prostu zrobić new `List` sorted, to znowu dostałbym błąd, że potrzebuję tego orderingu. Co to jest ordering? Na razie zostawmy. Znaczy, jak się robi własne orderingi, to na razie zostawmy.

 Kolejna rzecz, którą chciałbym powiedzieć, na przykład możemy sobie to... oczywiście jakby mamy metodę `foreach`. Tutaj mamy `user` new new `List` i sobie `pr`Int`ln`'ujemy. Zresztą czemu ja to tak robię? Można byłoby po prostu zrobić w `user`... `user`, prawda? To sobie w końcu to jest `case` klasa. Pięknie.

Natomiast to, co tutaj można by zrobić, to po prostu new new `List` `.` `foreach`. I teraz to jest `user`. O, właśnie to jest coś ciekawego, mi się już `Int`elliJ podpowiada. To mogłoby być tak. I to sobie wtedy wywala i wyświetla.

Natomiast to, co mogę zrobić, na przykład gdybym chciał po prostu `pr`Int`ln` usera, prawda? Mógłbym napisać w ten sposób. ``case` `class`` już dostarcza mi tę pewną metodę toString, więc to zadziała w ten sposób. Ale podobnie jak tutaj mieliśmy sytuację, kiedy właśnie ta zaślepka pozwoliła mi skrócić sobie z `user` strzałka `user` `age`, tak samo mogę zrobić tutaj. Mogę zrobić `pr`Int`ln` i zaślepkę w tym miejscu.

Co więcej, też już tutaj dostaję podpowiedź. Jeśli mam sytuację... nie, mam podpowiedź, mam tylko jakieś podświetlenie. Ech. Jeśli mam sytuację, kiedy mam wywołanie funkcji i jedyny jej argument jest właśnie tego typu wildcard, mogę to po prostu stąd wywalić. No bo `foreach` po prostu jest... `foreach` pobiera funkcję, która ma coś zrobić. Nie nie jakieś side effect, czyli coś, co co co wykona... na przykład wyświetli się właśnie coś na ekranie. Natomiast rezultat tej funkcji jest ignorowany. `pr`Int`ln` jest dokładnie taką funkcją. Ona ma wyświetlić coś na ekranie. Jej rezultat jest nieważny.

Więc to, co mogę zrobić, to po prostu podać ją jako parametr do foreacha. To jest to jest exactly the same thing. Wrócimy do tego jeszcze, kiedy będziemy mówić o tym, jak wygląda generowanie funkcji, czyli zwracanie funkcji przez funkcję. Na być może następnych zajęciach. OK. Teraz lecimy... tak, i to był `foreach`.

Zróbmy jeszcze... czyli właśnie możemy zastąpić jakby tą tą pętlę `for` albo pętlę while. Czasem możemy zastąpić właśnie takim foreachem. Natomiast często nasze pętle polegają na tym, że chcemy właśnie stworzyć nową nową tą kolekcję, która jest z czegoś zrobiona inaczej. Na przykład właśnie możemy zrobić kolekcję `age`List, tak jak tam wcześniej trochę robiłem. I do tego potrzebujemy... i do tego potrzebujemy metody `Map`. Metoda `Map` również pobiera element, ale w przeciwieństwie do foreacha właśnie tutaj liczy się nasz rezultat.

To jest to jest funkcja. To jest w ogóle funkcja. Znaczy tak, no bo ma z tym jednym elementem, pod który jest przedstawiony jako parametr funkcji. To, co ta funkcja zwraca, to jest ten parametr kropka `age`. I na pewno ta funkcja będzie zawsze brała tylko typ... ten właśnie bierze typ `user`, więc to będzie działać. Natomiast i tutaj możemy spojrzeć właśnie, to jest f od a do b na jakiejś tam liście typu a. Natomiast to, co dostajemy, to jest lista typu b. W tym wypadku akurat mam patrzę na implementację `List`, ale mogłaby... mógłby to być implementacja wektora. Działałoby... środek byłby trochę inny, ale deklaracja bardzo podobna. Teraz mamy `age`List. `List` of `Int`. Właśnie. Natomiast jeśli teraz zrobię tutaj `age`List.`foreach`, to co mi się wyświetli, to po prostu liczba... znaczy liczby, ten ten wiek tych tych wszystkich tych postaci, tych `user`ów. No dobra, ale to jest stosunkowo proste i chciałbym tutaj troszeczkę namieszać, żeby nie było aż tak proste.

Przede wszystkim powiedzmy sobie, że to jest jakaś nasza baza danych użytkowników, którzy mają między sobą konwersację i mamy właśnie ``case` `class`` conversation. ``case` `class`` conversation, która ma właśnie `id`, jakby user1 `id`, `Int`, user2 `id`, `Int`.

Tak.

To pozwolę sobie powiedzieć. Albo dobra, dobra, zacznijmy od tego. Więc mamy tutaj konwersację. Chcielibyśmy mieć w związku z tym na przykład konwersację pomiędzy każdymi, dowolnymi dwoma użytkownikami. Tutaj musimy zrobić `users`

`Map` i to jest właśnie ten `user` i pierwszy. I chcielibyśmy również użyć `user`... Oj, `user`... Nie, nie, nie. Chcielibyśmy zrobić znowu `users` `Map`, user2. To jest to był pierwszy, to jest drugi. I to, co robimy, to jest conversation tych dwóch `user`ów. I już tutaj widzę pewien element, który trochę spoileruje. Natomiast conversations... I spróbujmy... O właśnie, spróbujmy sobie to wyświetlić.

Co tu się dzieje? Mamy teraz `List`ę konwersacji, ale tam znowu jest lista konwersacji w środku i są jeszcze jedna lista konwersacji. Zróbmy w ten sposób, że to jest jakby...

Jakby mamy teraz dziewięć konwersacji. Poza tym są to konwersacje również między użytkownikami, którzy gadają sami ze sobą i mamy trzy listy. To dla każdego użytkownika user1 stworzyliśmy `List`ę, prawda? Tam mapowanie dla wszystkich użytkowników, konwersacji z tym pierwszym użytkownikiem. Potem mamy `List`ę konwersacji z drugim użytkownikiem i `List`ę konwersacji z trzecim użytkownikiem. I w sumie no trochę tak, nie bardzo.

Mamy To, co jednak chcielibyśmy, to jest właśnie to, co wcześniej tutaj się wyświetliło samo, czyli użycie metody flatten. I metoda conversation `users` flatten daje mi nam tutaj właśnie wszystkie te konwersacje w jednej liście. No chciałbym to jednak to troszeczkę może ładniej zrobić.

`pr`Int`ln` o dada da. I na dole też. Albo to, co mogę zrobić ewentualnie, to jeszcze tutaj te wyświetlić tutaj. I użyć takiej metody, która nazywa się mkstring, która zamienia... Używa toString na każdej właśnie takiej instancji klasy conversation w tym wypadku i dzieli je przecinkami.

Więc teraz mamy o. Dobra, ale to nie zadziałało tak, jak bym chciał. Dlaczego?

`List` of conversation. Dobra.

`val` fuł.

Aha, bym to łączył w jednego wielkiego o. Tak, i teraz mogę `pr`Int`ln` fuł po prostu o w ten sposób. I teraz to mi daje... a Zróbmy jeszcze jedną rzecz. Spróbujmy...

O, to sobie puśćmy i użyjmy również metody filter, czyli jesteśmy... Aha, no i no i aha, dobra, jedna rzecz wcześniej. `Map` i flatten może być zastąpione metodą flatmap, która jakby w najprostszej postaci robi dokładnie to samo. Czyli teraz mogę to użyć. `users` flatmap daje mi dokładnie ten sam efekt.

Flatmap polega na tym, jeżeli mamy `Map`ę, to mamy zawsze mapowanie jeden do jednego, prawda? Tak jak wcześniej, dlatego wcześniej było to problemem, bo zawsze dla `users` `Map` tworzy nam... Jeżeli użyjemy drugiego `users` `Map`, to znaczy, że tworzymy sobie `List`ę dla każdego użytkownika. Natomiast jeżeli dzięki temu mamy `List`ę. `List`. Natomiast to, co robi flatmap, czy albo też `Map`.i później flatten, to jest to, że możemy wziąć sobie taką... że właśnie utworzyć taką `List`ę `List` i ją właśnie spłaszczyć, czyli wyciągnąć te elementy z z tej wewnętrznej listy do zewnętrznej listy i stworzyć właśnie taką...

To to to nie jest to nie jest nesting, to znaczy jakby to była lista listy listy, to tylko na jednym poziomie byśmy sobie spłaszczyli, nie na wszystkich naraz. Trzeba byłoby wielokrotnie używać wtedy metody flatten, a flatmap albo metody flatmap również na każdym poziomie.

Natomiast to, co flatmap nam daje, jakby jeszcze poza tym, że jest właśnie potrafi to... potrafi to tak w ten sposób tworzyć, to je tak tak stłamszać, tak rozpłaszczać, to jest to, że w przeciwieństwie do mapy, w przypadku flatmap możemy z jednego elementu oryginalnego tworzyć kilka elementów. Jeden również jeden element wynikowy. Kilka elementów wynikowych, prawda? Dla jednego użytkownika może być kilka konwersacji.

Albo to, co możemy zrobić również, to sprawić, że dla jednego użytkownika, tego tutaj jednego elementu tego oryginalnego, utworzymy zero elementów wynikowych, w związku z czym żaden z tych elementów nie dostanie się do do tej wynikowej listy w tym wypadku.

I zróbmy to teraz. Zróbmy sobie taki właśnie przykład. Chodzi o to, aby pozbyć się konwersacji, które są pomiędzy dwoma tymi samymi jakby... nie żeby nasi użytkownicy nie gadali sami ze sobą. Więc to, co się dzieje, to bym chciał w tych użytkowników po prostu...

`users`... A, tylko teraz będzie to trochę inna... Ale już mówiłem wam już o opcji, więc mogę z jednej strony mogę tutaj użyć filtra. Filter. Czyli to jest właśnie ten... To ma być taki `user`, który jest różny od user1. W sumie mogę też ich porównać od razu po `id`, skoro jestem pewien, że to chodzi o `id`. OK, to jest podkreślenie, tak? I to mi już to wywali. OK.

Alternatywną metodą do tego filtra byłoby zrobienie czegoś takiego, że mamy `Map`ę. If user1 `id` jest różne od user2 `id`, to wtedy robimy option, czyli some conversation. Natomiast else none. I tutaj jeszcze jedno flatten... jest tutaj potrzebne. I ponieważ bez tego flatten, gdybyśmy to

to o sobie odpuścili, zrobili tylko flatmap, dostalibyśmy w efekcie none. Teraz, jeżeli mamy tutaj jeszcze flatmap i połączone z tym... OK, to nie wygląda tak dobrze. Widzę tutaj pewien pewien pewne zamieszanie, dlaczego mi mogłoby to nie być zbyt najlepiej zrozumiane. Dobra, wróćmy do filtra. A do tego też jeszcze wrócimy w już za parę minut, mam myślę. Tylko zostawmy sobie filtry tutaj.

Jeszcze jedna rzecz, którą chciałbym pokazać, to jest to, że po pierwsze tej klasy conversation wcale nawet nie potrzebujemy tak bardzo, ponieważ może ona być zamieniona na tuple. Zawsze możemy używać tupli, też mówiłem już o tuplach. Więc jesteśmy możemy zrobić coś takiego.

I możemy zrobić po prostu... Wywalić się totalnie. `List`. Oj, nie. `List`. I wtedy będzie to lista `Int`ów. `Int`ów. Tak. Natomiast taką tuple `id` do `id` można także zapisać w tej postaci. Nie wiem, co na co to akurat tutaj pomaga w zrozumieniu, o co chodzi. W każdym razie jest to konwersacja pomiędzy właśnie tak jakby ten user1 namówił do usera2. I to nam wyświetli w tym momencie. O, tylko `List`ę tupli. Bardzo ładnie.

Jednak to, co jeszcze można zrobić i co się właśnie przydaje w związku z tym, że w związku z tuplami, jest to, że istnieje coś takiego jak name tuple od pewnego czasu w Scali 3. Znowu możemy teraz zamienić. Tak jak poprzednio robiliśmy... A, właśnie. W zasadzie możemy... Po pierwsze możemy zrobić po prostu taki typ alias. W tym momencie to nie jest ``case` `class``, a więc nie będzie się tworzyła żadna nowa instancja żadnych danych, poza tym, że no cóż, używamy tupli. Więc mogę to zmienić tu. Jak widać, `Int`elliJ podświetla mi to troszeczkę inaczej. Wszystko działa dokładnie tak samo, jakby to były tuple. OK.

To, co jednak mogę zrobić teraz, mając taki type alias, to właśnie user1 `id` i user2 `id`. Nie, równa się tylko o. User2 `id`. Hop. Dobra. I to również będzie działało dokładnie w ten sam sposób, ale mając te conversations na przykład w tym miejscu, mogę też jedną taką konwersację... Jak widzicie, jest tutaj opcja dostępu do tych dwóch elementów w tej postaci. Jak gdyby tej gdybyśmy tego named nie zrobili, to dostęp byłby taki. Teraz już nie jest, musicie mi wierzyć na słowo. Albo ewentualnie mogę to z powrotem przywrócić do `Int`a i wtedy będziecie możecie zobaczyć, że tak jest. Podkreślenie 1, podkreślenie 2. Teraz jednak możemy sobie `pr`Int`ln` c user1 o w ten sposób zrobić. Czyli użyć tego tego tej właśnie tego elementu pierwszego w tej tupli. I to do pewnego stopnia nam jakby zastępuje `case` `class`, zwłaszcza jeżeli dodamy do tego możliwość tworzenia pewnych... Jeszcze właśnie dodawania metod, które działają na takim type aliasie oraz, czyli extension metods. Albo jeszcze jest coś takiego jak opactype. Albo dobra, wrócimy do tego. Może jeszcze dzisiaj, ale może na następnych zajęciach.

 To, co chciałbym dalej Wam jeszcze pokazać. Aha, no i podobnie tutaj druga sprawa to jest to jest ten... Dobrze, to zostawmy na razie.  Przejdźmy do... Zresztą już przerobiliśmy, przejdźmy sobie do właśnie drugiego zagadnienia. Hop. Nie, nie to. Nie to. Aha.

Podobnie jak type conversation, możemy też na przykład zrobić też type userId równe `Int`. I używać tego wszędzie. Również tutaj możemy... Przenieśmy te dwa userId tutaj wysoko. I zamieńmy wszędzie tutaj userId.

To nic nie zmienia. Ten userId dalej jest `Int`em. Wszędzie, gdzie będziemy używać userId, będzie on działał jak `Int`. Przynajmniej w tej postaci, w tej wersji. To, co chciałbym dalej zrobić, to powiedzieć Wam trochę... Aha, no i jeszcze chciałbym coś tutaj do... Wrócić na chwilę do slajdów.

Więc tak, mamy mamy w Scali dla każdej wersji kolekcje, o której mówiłem, właśnie są... jest Aha, jeszcze musiałbym powiedzieć o set is. Jakby możemy też zrobić w tym miejscu `val` `Map` i to będzie na przykład właśnie new `List` to `Map`, ale trzeba byłoby będzie zmapować, kiedy ten `user`... O, właśnie to będzie userId. Albo userId do `id`. Mogę i też tutaj mogę napisać w ten sposób. Prawda? Natomiast to `Map`. O, i teraz ta mapa. Moja. Jest typu userId do `user`. Podobnie mogę zrobić to set, ale na przykład... O, właśnie mogę zrobić `val` set, czyli new `List` `Map` `id` to set. To mi daje właśnie zbiór `user`... Set of userId.

I to są wszystko kolekcje niemutowalne, czyli najlepiej... Czyli właśnie operujemy na nich pewnymi transformacjami, takimi jak `Map`, właśnie flat `Map`, może filter find również. Find to jest na przykład właśnie coś, co nam się zaraz będzie przydawać. Metoda do znajdowania jednego z elementów i zwracania go. Natomiast natomiast chciałbym jeszcze tutaj poruszyć temat... Dobrze, ale jak w takim razie, jeżeli mamy kawałek logiki w programie, która naprawdę potrzebuje dużo... Która potrzebuje właśnie wykonywać wiele obliczeń, dodawać, odejmować, tworzyć taką kolekcję, to co wtedy? Czy to naprawdę musi być wykonywane tych transformacja, które ciągle biorą całą zawartość kolekcji, kopiują ją, dodają, odejmują i tak dalej?

Nie, nie, nie. Absolutnie to nie jest potrzebne. Mamy dwie możliwości praktycznie, żeby to zrobić. Po pierwsze, oczywiście taka kolekcja mogłaby być nie nie nie polem, nie `val`ue, mogłaby być variable. I jeżeli byłaby taką... Byłaby taką variable, mogłaby być... Zejdźmy sobie tutaj nisko. Jeżeli mamy var na przykład `Seq` equals `Seq`, tam nie wiem, one, two, eleven. No i teraz mamy... Nie, nie, nie. I teraz mamy pr`Int`ln `Seq`, zobaczmy, co z tego wyjdzie.

Range one two... Aha, no tak. Czyli mogę to zrobić właśnie one two eleven. Tak. To jest range, to jest jeszcze jeden inny rodzaj kolekcji. To `Seq`. Ale jako jako var, to w następnej kolejności mogę zrobić `Seq` plus equal twelve. O, w taki w taki sposób.

Oho. No trochę to nie działa tak, jak powinno.

Tak. I to z kolei... Jeśli teraz tutaj puszczę play... Właśnie widzimy, że ten... Jakby to też trochę mi tutaj przeszkadza fakt, że jakby pr`Int`ln podaje mi, co jest pod spodem. W tym wypadku niby siłuję powiedzieć, dobra, to jest `Seq` cały czas, ale pod spodem jest range, czyli range, czyli struktura, która pozwala na właśnie powiedzenie od do.

Natomiast potem, kiedy już do tego range'a, który korzystam z niego jako `Seq`, dodałem jeszcze jednego jeszcze jedną sekwencję 13-14, to ona mi się pod spodem zamieniła na `Vector`. Ale zamieniła mi się na `Vector`, ale też chciałbym, aby nadal była używana jako `Seq`. No dobra, nieważne.

Oczywiście tutaj kolejność tych litb nie jest ważna. To tylko przypadkiem tak wyszło. Mogę na przykład zrobić coś takiego i te trzy i cztery i tak dodają się na końcu. Można to zrobić oczywiście w troszeczkę bardziej w krótszej postaci. Właśnie na przykład `Seq` plus plus równa się `Seq` trzy cztery.

No i tak samo można odejmować pewne elementy. Chociaż co tutaj mogę odejąć? Minus minus równa się? Chyba nie ma takiej... Nie, w przypadku zbioru tak. Na przykład mogę zrobić sobie teraz var set równa się `Seq` to set. I od zbioru set.

Aha.

Aha, coś już jest zdefiniowane jako set, tak tutaj. Dobra, to wywalam. Eee I teraz na przykład set minus równa się pięć. Pr`Int`ln set. Jakby na przypadku zbioru mamy tę opcję, że mamy teraz zbiór, który jest pomieszany. Jest pod spodem jest hash set. Nie ma tutaj piątki, ale kolejność się popsuła. Podobnie mapa.

ma Również z mapy mogę odebrać... Jeżeli tutaj już mam `Map`ę, pr`Int`ln `Map`, to mogę sobie z niej... Już już je... Aha, już byłem. Było, ale ale się zbyło. Dobra, skasowałem. Niech będzie. I jeśli na przykład `Map`... Znaczy `Map` minus równa się dwa, to jest ten... Już nie mogę. Niestety mogę. Tak. Ze zbioru mogę, z mapy nie mogę. Dobra, nieważne.

W każdym Na przykład do mapy mogę dodać nowego użytkownika w ten sposób, że po prostu sobie piszę `Map` plus równa się... Co tam? Pięć do `user` pięć i w konto nie. To powinno zadziałać. To powinno zadziałać. Halo.

Aha, ale może zadziałać w ten sposób.

Prawda? Nieprawda? Ach, dlatego. Proszę. Więc być może mogłem. Może dałoby się plus równa się... O, i `Map` minus równa się trzy. O, tak, teraz działa. Czyli jakby dodawanie... Dodaję tuplę, klucz wartość, natomiast odejmuję po prostu po samym kluczu. I to powinno mi w tym wypadku powiedzieć pięć, jeden, dwa, cztery. Nie ma, nie ma trójki. Bardzo dobrze.

Tak, więc mamy tę opcję właśnie używania variable i i wtedy wykonywania operacji, ale to jest właśnie ta wersja, która... To jest w sumie to samo, co gdybyśmy... To jest nadal wersja, która powoduje transformację tego tych elementów i wzięcie całej zawartości, wartości tej kolekcji i dodanie, odjęcie od niej czegoś. W Scali mamy tutaj właśnie wyraźny podział na to, że istnieje różnica między tym, że jakaś referencja jest mutowalna, czyli to var powoduje, że właśnie referencja do jakiejś listy, jakiejś mapy i tak dalej jest mutowalna, czyli po prostu można ją podmienić na inną `List`ę, inną `Map`ę.

A co in na czym innym polega to, że możemy mieć nawet niemutowalną referencję, która ciągle nam się patrzy tylko na jeden element, natomiast jest jest właśnie jej zawartość może być niemutowalna albo mutowalna. Ta druga opcja to jest właśnie... A tutaj wyszło, że tak, to są screenshoty z filmu.  Ta druga opcja zawiera... Oznacza, że to, czym do czego ta nasza referencja prowadzi, musi być innego typu.

I każda taka podstawowa kolekcja w Scali ma swoje odpowiedniki mutowalne, czyli właśnie `List` buffer, hash `Map`, array buffer, array buffer dla wektora, jak samo nazwa wskazuje, hash `Map` dla mapy, `List` buffer dla listy.  I gdybyśmy zrobili to w ten sposób, to mogę tutaj zrobić na przykład `val` mut `List` równa się i tutaj trzeba najpierw zrobić jeszcze import skala

`collect`ion mutable. O, właśnie. I teraz mut `List` to jest moja mutable.

Na przykład `List` buffer. O, i teraz co ja tutaj mogę zrobić? Mam teraz pustą kolekcję.

Mut `List` może mieć na przykład coś takiego jak... Ma takie metody jak insert, insert all, remove, `update`, add all, add one. Również w tym momencie mogę tutaj dodać mu... Jeśli to jest na przykład `List` buffer od od właśnie `Int`, to mogę mu dodać ten element. I to niby operator wygląda tak samo jak tutaj, ale działa inaczej. Mut `List` jest nadal referencją do tego samego... Do tej samej kolekcji. Natomiast jest to...

Tak, jest to `List` buffer. I na koniec takich... Jeżeli dzięki temu właśnie możemy powiedzieć, że jest to łatwiej, że tworzymy sobie sobie właśnie taką naszą kolekcję za pomocą operacji, które są które już są właśnie w miejscu, nie tworzą cały czas nowych wersji całych kolekcji. Natomiast kiedy już kiedy już to zrobiliśmy, możemy znowu sobie zrobić `val` `List` 2 równa się mut `List` to `List`. O, i w ten sposób jakby dostać ten ten końcowy rezultat wszystkich naszych wszystkich naszych operacji.

To, co możecie myśleć o tym jako o builderach, czyli właśnie jakby to jest taki podział, który myślę, że jest najważniejszy, najfajniejszy, że okej, najlepiej, jeżeli mamy właśnie niemutowalne kolekcje z niemutowalnymi referencjami, natomiast mutowalne kolekcje, które nadal mają niemutowalne referencje, to jest fajna sprawa, żeby właśnie zrobić builder, czyli jakby wykonać pewną logikę, która zbuduje nam kolekcję, a potem zwrócić rezultat tej kolekcji już jako ten niemutowalny, czyli znowu idziemy tutaj do góry.

Z drugiej strony, no właśnie, jak był complex `update`, to tam jakiś do complex cokolwiek, można sobie właśnie też pobrać jakąś już istniejącą kolekcję, wrzucić ją do tego do tego buildera, wykonać pewną operację, zwrócić rezultat, wszystko spoko, jesteśmy w miarę performatywni. Po prawej stronie natomiast mamy właśnie coś, co może być jakby naszą jakby stanem naszego programu, stanem gry, stanem świata, tej symulacji, stanem właśnie na serwerze. I on się może zmieniać.

W tym wypadku ja bym... To jest trochę stare. Ja bym tutaj dodał jeszcze private przed tym, żeby właśnie u jakby pokazać, że że w takim wypadku trochę idziemy w stronę Javy znowu z tym, że ponieważ jest to jest to zmienna, to nie powinniśmy mieć jej jej jako publicznej. Powinna ona być za schowana, prywatna i docieramy do niej z zewnątrz jakimiś metodami, dzięki czemu na przykład możemy uniknąć sytuacji, kiedy ktoś nam może zmienić tą zmienną z zewnątrz.

I to, że jest to lepiej działa, jeżeli mamy sytuację, gdzie gdzie właśnie tylko co jakiś czas potrzebujemy tego `update`'u. Nie nie tworzymy w ten sposób całej olbrzymiej kolekcji, tylko on tak tak ten live data w tym wypadku to jest właśnie już jakaś kolekcja, która już gdzieś tam żyje, już sobie jest i co jakiś czas tylko robimy jej `update`.

Natomiast sytuacja, kiedy potrzebujemy zarówno mutowalnej referencji, jak i zarówno mutowalnej zawartości kolekcji, nigdy nie powinna zajść. To to już to jest po prostu zły kod, bo jakby nie widzę sytuacji, w której ktoś potrzebowałby... W której w takiej sytuacji może dojść do do tego, że nie będziemy... Jakby umknie nam to, czy wykonujemy operację na tej samej kolekcji, czy tworzymy nową i na przykład możemy stworzyć nową kolekcję, zmutować jej zawartość, a potem o niej zapomnieć. Ona nigdy nie nie zostanie... Tam ta stara nigdy nie zostanie zastąpiona nową w tym variable.

Więc to to jest dopiero to są... To jest proszenie się o o bugi i to takie, które nie są za dobrze widoczne w kodzie. Okej? Dobra. I to była... To jest koniec pierwszej części wykładu.

Druga część `.`yczy właśnie tego, że dobrze, słuchajcie, mamy ten... Mamy już te wszystkie metody, które nam mogą działać na kolekcjach i wstępują nam pętle `for`. Natomiast to jest... Natomiast no jest jedna rzecz, która często w programowaniu zachodzi i do której przydaje się coś, co właśnie... Tak zwany early `return`, który w programowaniu funkcyjnym jest dość... Może nie trudny, ale nie taki... Nie taki bezpośredni, nie taki naturalny. W w Scali w ogóle... Załóżmy, że właśnie mamy już sobie taką `List`ę użytkowników, mamy sobie tą klasę `user` i to, co chcemy zrobić, to...

Tak, mamy... Tak, możemy sobie tutaj jeszcze od razu zrobić `val` `user` `Map`, czyli właśnie tych `users`ów do do mapy.

Tutaj jeszcze sobie type application, dobra. I to, co byśmy chcieli zrobić, to jest jakiś...

Tak, to wyobraźmy sobie tutaj sytuację, kiedy kiedy właśnie mamy znaleźć pierwszego prawidłowego użytkownika, czyli mamy właśnie taką definicję, taką metodę `findFirstValidUser`i to, co dostaniemy, to jest właśnie its, czyli ten `Seq` of `user` `id`, a to, co chcemy dostać, no właśnie, to jest to powinien... Dobra, na razie zostańmy przy tym, że to ma być po prostu `user`.

Nie, teraz to mi przeszkadza, Zmizek. I taka bardzo imperatywna metoda, podobna do Javowej, wyglądałaby mniej więcej tak... Nie, dziękuję. Wyglądałaby mniej więcej tak. Dla każdego identyfikatora... Nie, dla każdego identyfikatora w tej właśnie... W tych identyfikatorach... W identyfikatorów potrzebujemy najpierw `val` `user`, czyli pobieramy sobie go z tej mapy od `id`, następnie...

A następnie właśnie wykonujemy jakieś sprawdzenie, czyli na przykład if `user` `age` większe od 18, ale też jeżeli `user` has `val``id` email, ten `user`, to wtedy go zwracamy. Natomiast jeżeli nie, to zwracamy nulę. No i to jest...

I potrzebujemy teraz metody has `val``id` email.

U`Boolean`. Tak, ale nie do końca. Trzeba byłoby właśnie zrobić counts.

Counts.

Tak, już mi się w skutlinie troszeczkę miesza. I teraz to jest jeden. No, no i tyle.

Dobra, zignorujmy na razie to, że mamy tutaj właśnie te te `return`e. I zróbmy `val` its równa się `users` `Map` it. I `findFirstValidUser`pr`Int` line. Zobaczmy, co nam wyjdzie. Tak, pierwsza Alicja.

Dobrze. To, co tutaj `Int`elliJ nam teraz podświetla, to fakt, iż generalnie w Scali bardzo nie lubimy używać `return`ów. Jest inna inna konstrukcja. Pokażę ją może na chwilę tutaj, ale potem wrócimy do tej wersji, bo jest ona jakby bardziej trochę czytelna. To się nazywa break import skala break. Nie, nie, nie.

Skala util boundary i skala boundary break.

Skala util boundary. I to, co by trzeba było zrobić, to jest zrobić właśnie tutaj boundary. I nazwać ją jakoś tam.

Boundary

exit.

I break.

Te stare jakieś.

Jeszcze chwilę.

Już boundary typu typu właśnie `user` w takim razie. I to, co mamy tutaj, robimy break. Ech. Break `user`.

Missing argument.

Okej. To powinno chyba zadziałać. Tak. Ale co, jeżeli nic by nie zadziałało?

No. Okej. No więc, ale jest to jest taki trochę jakby `return` z jakimś labelem, że właśnie widzimy, że że chcemy stąd pójść `.`ąd. Możemy to nawet zrobić w ten sposób. I ale wygląda to trochę gorzej, moim zdaniem, przynajmniej dla celów uczenia i pokazywania, jak to jest inaczej niż w Javie. Więc zostańmy, wróćmy do tej wersji `return` i po prostu zignorujmy, że tutaj się że kod będzie się wyświetlał, że o już tego że my tego w Scali nie lubimy.

Dobra. To, czego potrzebuję teraz, to chciałbym teraz podzielić te dwie rzeczy, bo możecie sobie wyobrazić, że na przykład jeżeli taka taka forma keychaina na `return` jest ten early `return` jest dość łatwy do przeczytania, jest po prostu jedna pętla, jest jeden `return` i to wystarcza, to jest dość częste i możecie sobie powiedzieć, no dobra, przecież tamten kod nie będzie go widać. Problemy zaczynają się dopiero wtedy, kiedy ten kod zaczyna rosnąć.

Dlatego chciałbym Was tutaj poprosić trochę o takie właśnie użycie wyobraźni. Wyobraźmy sobie, że ta ten użytkownik, którego tutaj pobieramy na podstawie `id`, to jest jakaś bardzo skomplikowana operacja, jakieś sięgamy do bazy danych, albo sięgamy gdzieś jakimś requestem do Usosa. Wiadomo, Usos nie jest najlepszym naszym... Nie jest najszybszy na świecie. Generalnie ten ten ten request wymaga jakiegoś jakiejś autentykacji, masy rzeczy.

Dlatego, żeby troszeczkę może było łatwiej nam sobie to wyobrazić, to zrobimy funkcję `convert`. I ona będzie miała taką, że bierzemy `id`, typu tego `user` `id`, i zwracamy użytkownika. I to jest właśnie ten... To jest właśnie ta... Zamiast po prostu sięgać do `user` `Map`, tutaj zwracamy... Po prostu tutaj właśnie używamy `convert`. Natomiast ta druga metoda to będzie metoda `validate`. I metoda `validate` na podstawie `user` `user` ma nam zwrócić `Boolean`. `Boolean` właśnie wtedy, kiedy... Właśnie wtedy, ponieważ nie potrzebujemy tych... Właśnie wtedy, kiedy tutaj mamy użytkownika w wieku większego już 18 i on ma prawidłowy `email`. Więc `validate`.

I to jest pewien taki... To jest pewien taki pattern, którego który tak naprawdę w aplikacjach jest... to Pojawia się dość często, w dość nawet nietrywialnych sytuacjach, kiedy mamy właśnie jakąś kolekcję, głównie jakichś identyfikatorów albo jakiejś prostej struktury danych. Natomiast na podstawie tej elementu takiej kolekcji możemy wyciągnąć skądś albo jakby skonwertować tą prostą strukturę danych do czegoś dużo bardziej skomplikowanego. Ewentualnie wcale nie efekt nie musi być bardziej skomplikowany, ale sama operacja tej konwersji jest skomplikowana i trwa długo.

Natomiast później, kiedy już mamy tą tą strukturę tą wynikową po tej długiej konwersji, a musimy ją zwalidować, sprawdzić, czy właśnie te pola tej struktury są takie, jak chcemy. Nie znaczy, że one muszą być jakby obiektywnie `val``id` w ramach całego programu, tylko że po prostu dla naszych potrzeb w danym momencie są takie, jakie powinny być. I jeżeli trafimy na takiego taki element, który ma ten ten już w tej konwertowanej już struktury, który ma już taką właśnie taką postać, która nam pasuje, to wtedy go zwracamy. Natomiast nie `Int`eresuje nas już, co się dzieje później.

To jest też ważne, bo zaraz do tego dojdziemy, właśnie że generalnie to, że i konwersja, i walidacja trwają długo, jest o tyle jest dla nas ważne, ponieważ jakby chcemy... To jest ważne dla naszego dla tego, o czym dzisiaj mówię, ponieważ chcielibyśmy uniknąć sytuacji, kiedy wykonujemy zbędne konwersje i zbędne walidacje. Okej? Więc tak, to jest jakby nasza pierwsza wersja, która faktycznie łatwo działa, jest łatwo widzialna, rozumiemy, co się dzieje. Super. A jedyny problem właśnie polega na tym, że być może, gdyby ta jeżeli ta pętla `for` stanie się bardziej skomplikowana, zaraz ją skomplikujemy, to już możemy mieć ten problem.

I to jest właśnie taki argument przeciwko `return`om w w programowaniu funkcyjnym, że te `return`y się nam... Że te `return`y się jakby ukrywają. Jeżeli w kodzie, którego czytamy, `return` jest gdzieś głęboko, to w tym momencie urywa nam się ten wątek, bo tak to widzimy, tylko że dobra, taka transformacja, taka, taka, taka, taka, a tutaj nagle... Ha, stąd to się kończy. Tutaj... Ale tylko w tym wypadku, tylko tylko ten branch tego tej naszej logiki się kończy. Inne branche naszej logiki się nie kończą, one dalej gdzieś krążą i docieramy do innego miejsca, gdzie może być `return`, albo możemy tu coś do końca całej funkcji albo metody.

 No, generalnie jest to to właśnie to utrudnia nam zrozumienie kodu, co również może się przekładać na to, że ten kod zrozumiemy w pewnym momencie źle, jeśli będzie bardzo skomplikowany i to doprowadzi do błędu. Więc skomplikujmy sobie. Zróbmy po pierwsze `def` nullable albo właśnie `nullableConvert`,

które... Czyli znaczy generalnie nasz `convert` już jest nullable. Więc to będzie wyglądało dokładnie tak samo, chcę tylko Wam... Także ta pierwsza wersja jest taka naiwna, jesteśmy pewni, że już wszystko będzie dobrze.

 Druga wersja, ten `nullableConvert`, chodzi mi o to, że mogę... Znaczy ta wersja się wywali... Nie, ta wersja się wywali, jeśli będzie... Tak, true of `NoSuchElementException`. Robimy tutaj get or else no. Or no. Okej?

I teraz ten `user` może być nulem, więc musimy sobie to wziąć to pod uwagę.

To wtedy robimy to. W przeciwnym wypadku... Więc co ja robimy?

Aha.

O Natomiast nasze `validate` zamienimy na `unsafeValidate`. I to będzie polegało na tym, że

mamy taką metodę... Ach, tutaj musi być równa się. Taką metodę random w Scali. Tak, `nextBoolean`. I teraz to sobie... O, sięgamy po to. If `Random.nextBoolean`, then throw new illegal argument exception. Boom. A jeżeli w przeciwnym wypadku zróbmy sobie właśnie to po raz kolejny? O, tylko że jeszcze zróbmy coś innego. Mamy tutaj `user` `age` większy od 18. I zróbmy sobie jeszcze `def` `otherValidate`. `user` `Boolean`. I tutaj zróbmy dopiero, że ten `hasValidEmail`. Oraz zróbmy jeszcze coś takiego. Mamy ``case` `class `user`. Zamieńmy ją na zwykłą klasę w takim razie. Czy to nam coś tutaj właśnie... Tak, to nam to oznacza, że potrzebujemy tego emaila. Czy możemy zrobić to w ten sposób, żeby sobie ułatwić życie? To jest zwykła klasa, ale ma wszystkie te pola publiczne. I zróbmy sobie `class` student, który ma dokładnie wszystko to samo. Plus jeszcze ma `val` faculty string. I ten, że student extends `user` `id` name email `age`. Proszę bardzo, name email `age`.

Tak, no i tutaj wszędzie teraz trzeba będzie jeszcze wpisać `override`. 

Dobra, i poprosimy naszego AI asystenta generate a few students and add them to the `users` `List`. Go. Sending request, planning changes.

I mamy. Accept all. Dobra, jeśli teraz wrzucę tutaj maila, to co to jeszcze używa starych? Aha, no właśnie. Find first. Aha, no i tego usera w takim razie dajmy mu tego `def` to string. Niech mu będzie `override`. O, nie. `user`. O, bardzo ładnie. To nam wystarczy w zupełności, super. I student będzie miał w takim razie swojego własnego. O, też pięknie. Tak. I teraz to, co możemy zrobić, to...

Super. Okej, to, co teraz możemy zrobić, to właśnie zmienić ten `findFirstValidUser`tak, żeby właśnie był trochę bardziej skomplikowany. Więc tutaj możemy... Tutaj jest `nullableConvert`. Tak, tutaj mamy właśnie ten `unsafeValidate`. Musi być w tym wypadku w try'u. Więc if `unsafeValidate` `user`, to wtedy `return` `user`. Ale właśnie może się okazać, że nie. To się nie uda.

To wtedy znowu zrobimy... Jeżeli się nie udało pierwszym sposobem, to wtedy jest `otherValidate`. Albo możemy też zrobić tak, że mamy tego studenta, czyli jeszcze jest taka opcja if `user` is instance of... If instance of student, to wtedy... And...

To jest strasznie brzydkie już. A, jeszcze jest takie coś jak... I jeszcze zrobimy tutaj sobie `def` student `validate`.

Student, student. I to jest to, że `Boolean`. Student faculty i równa się mini. Tak. I wtedy go... A, student faculty nie powinien być... Oj, oj, oj, oj. Nie `Int`, tylko string. Dobra. I to będzie mini. A to będzie... Dobra, nie chcę nikomu... Nie chcę nikogo obrazić, więc niech będzie tam no faculty. I jeszcze jeden. To będzie mini. Dobra. Ok, i teraz możemy zrobić właśnie student `validate`. Tylko teraz jest `user` as instance of student. Tak. No, ok, co on mi tutaj próbuje? No, to jest dokładnie to samo. Nie, nie potrzebuję tego. Dobra, ja jest tutaj jeszcze więcej tego, no bo mogę tak, faktycznie mogę zrobić to type matchingiem. I to zróbmy to, żeby pokazać w ogóle, jaka jest opcja, bo to strasznie brzydko wygląda. To wygląda odrobinka lepiej, ale wrócimy do tego. Na razie zostawmy to tak. No i to powinno nadal działać. Mamy tutaj play. Dalej ta Alice jest pierwszą postacią. Zróbmy tak, że ona ma złego... Złego maila. I teraz nam powinno wyskoczyć... Aha, ale ma wiek prawidłowy. Dobra, dajmy jej 17 lat.

Dobra, i teraz drugi, ten Bob jest... Nam wyskoczył, on ma `age` 30. Dobrze. Dobrze, że ten `user` `age` to dajmy to ten. No, ok, przeszliśmy przez to.

Więc jak widzimy, robi się tu już trochę brzydsze i coraz bardziej skomplikowane. Mamy wiele tych `return`ów, mamy je... Mamy tu jakieś try'e, catche i w ogóle. I... No... No, łatwo nie jest.

A to, co możemy teraz... To, co moglibyście powiedzieć, no dobra, ale to w takim razie możemy dalej, prawda, stworzyć prywatne metody, które nam tutaj zakapsulują część tego naszego kodu i będzie nam łatwiej. Owszem, super, bardzo lubię jak takie podejście. Problem w tym, że właśnie w przypadku tych `return`ów to on się nie do końca sprawdza.

Popatrzcie, zróbmy metodę save. Ta metoda save przyjmuje usera. Nie, przyjmuje funkcję. Przyjmuje funkcję. Jakąś `validate`. Funkcję. I ta funkcja `validate` jest właśnie usera do `Boolean`a, a save również jest buser... O, to się już działa. Już widzę tutaj już pewne... Zróbmy to troszeczkę najpierw w ten sposób, żeby wiadomo było, o co chodzi, dlaczego tak, a nie inaczej. O, co my tu mamy? Więc i tu, i jeszcze tu. Dobra, i co to robi? Jesteśmy... Mamy taką... Zamiast... Możemy napisać teraz coś takiego.

Tak. Co? Nie, `validate` po prostu będzie od...

O, w ten sposób.

I to też wywalamy. Dobrze, czemu? And `Boolean`. Try `return` `validate`.

Aha, i teraz mamy wyrzucić `Boolean`. Dobra, zróbmy taką metodę. I teraz mamy save.

A, i możemy tutaj wypisać... O, i tak będzie jeszcze lepiej. Dobra, mała dygresja.

To, co się tutaj dzieje, to jest zwrócenie przez lazy, czyli jakby ten `validate` w stanie dopiero... Ok, save. Trzeba było zrobić to z tego po prostu save `validate` i już. Dobra.

Zrobimy tutaj save `validate`. I on weźmie właśnie `user`, `user`. I zwróci `Boolean`a. I to jest `return` `unsafeValidate` z tego usera. I teraz robimy tak. O, dobrze.

No, jest trochę niby łatwiej, owszem, ale... Czekaj, może tak zasunęło.

To jest trudniej.

I jeszcze raz. I zobaczmy, czy to działa. Ok. I teraz, co tu się stało? To mamy właśnie tego find first `validUser`. Albo tak, już wystawmy go tak, ale... Ale mimo tego, że tutaj przesunęliśmy niby ten... Niby właśnie ten `unsafeValidate` i to try dookoła do save `validate`, nadal potrzebujemy tego `return`a.

Nie możemy użyć `return`a tutaj w środku w tym try'u po to, żeby się wy`return`ować z tej metody find first `validate` `validUser` wyżej. `return` nam działa tylko jeden poziom, a z tego nowego poziomu znowu potrzebujemy `return`a. No i... No i w związku z tym właśnie early `return` jest pewnym takim imperatywnym programowaniem, czymś, co nam trochę ten kod tak psuje.

Robi się to trochę coraz brzydsze, jeżeli... Bo tam mamy właśnie funkcję, która ma early `return`, a potem chcemy ją właśnie w pewnym momencie jakoś podzielić, ale i tak potrzebujemy tego, żeby zrobić jeszcze raz tego early `return` i tak dalej, i tak dalej. No... Nigdy nie będzie to wyglądać za pięknie. Natomiast to, co możemy zrobić dalej, to jest...

Natomiast możemy iść w tym, napisać sobie... Napiszmy sobie więc najpierw taką... Znając już te metody, o których mówiłem wcześniej właśnie, z kolekcji Scali, napiszmy naive version. I wersja naiwna będzie dalej brała to samo.

Natomiast to, co będzie robiła... Wróćmy troszeczkę do tej wersji. Spójrzmy na to tak, jak było to poprzednio. Bez `nullableConvert`, bez save `validate`, tylko dla przykładu. Mamy więc its. I możemy to, co możemy zrobić, to przede wszystkim zmapować sobie takiego każdego its na właśnie `convert`. Czyli A potem zrobić find `validate`. Zwykły `validate`, proszę. Mamy `id`. `convert` `id`. I potem mamy `validate` find `user`.

`validate` `user`. I trzecia rzecz, którą chcę zrobić, to jest taka... Tak, bo skoro na razie posługujemy się tymi właśnie możliwością nulowania, to to będzie wyglądać w ten sposób. Czyli teraz zrobimy sobie `val` first `validate` `user`. Naive version. Its. Play. Dobra. To, co jednak jest trochę bardziej... Mówiłem już o optionach, więc jak tutaj użyję, mogę wywalić tego geta. I zamienić naive version na option of `user`. W ten sposób. I to, co dostanę tutaj teraz, to jest albo właśnie pewien some, albo jeżeli nie będzie takiego itsa, to dostanę none. Więc jakby unikam pracy z nulami, unikam możliwości `NullPointerException` i tak dalej.  Do option jeszcze też wrócimy.  No tak, ale co tutaj się dzieje? Przede wszystkim najpierw dla każdego identyfikatora przeprowadzamy konwersję, a jak mówiliśmy, to może być bardzo długo. Trwać bardzo długo. Natomiast mamy też właśnie... I potem dopiero wywołujemy find po to, aby walidować tego użytkownika i znaleźć pierwszego, który jest prawidłowy. Wszyscy pozostali, którzy zostali... Którzy później zostali skonwertowani, to jest praca na darmo. To nie jest fajne. Czy możemy zrobić troszeczkę mniej naiwną wersję? Trochę improved. No i zróbmy sobie improved naive version, która będzie działać odrobinę lepiej, nadal korzystając z tych samych metod. Mianowicie najpierw robimy find.

A potem robimy jeszcze raz `Map`.

Tak. I tutaj, jeżeli teraz zrobię improved naive version.

Tylko to muszę sobie zakomentować. Tak, to dalej będzie działać. Co tu się dzieje? To ta metoda find pozwala nam na to, że dla każdego identyfikatora konwertujemy go do usera, potem od razu walidujemy. I jeżeli on jest prawidłowy, no to find zwraca nam identyfikator, musimy zrobić jeszcze jedną konwersję. Więc jest lepiej niż tutaj, ale wciąż robimy dwie konwersje zamiast jednej.

I to jest moment, kiedy chciałbym znowu przejść do slajdów i pokazać Wam właśnie jeszcze i wrócić jeszcze do tego, co mówiłem na poprzednich zajęciach. Otóż mamy taki sposób na to, aby traktować w pewnym sensie każdą funkcję jako rodzaj mapowania. Prawda?

Mamy tutaj funkcję multiply multiplication. Ona ma dwa parametry. Można powiedzieć, że to jest parametr... Również jest... Może być tuplą w tym wypadku. Prawda? Mamy dwa `Int`y. I on zwraca nam `Int`a. Czyli jakby mamy właśnie dla danej struktury danych na wejściu, otrzymujemy, mapujemy ją na jakąś strukturę danych na wyjściu. To już jest ta domena i kodomena. I ten kod, który nam tę transformację przeprowadza. I to jest tak zwana funkcja totalna. Czyli dla każdej kombinacji tych parametrów wejściowych dostaniemy jakiś prawidłowy rezultat.

Ale popatrzmy sobie na przykład na metodę dzielenia, div. Tutaj niby jakby możemy ją zapisać w ten sam dokładnie w tej samej postaci. Zawsze tylko się zmienia tutaj operator zmnożenia na dzielenie. No i jeden jeden mankament jest taki, że oczywiście jest to dzielenie na `Int`ach, więc nam się zaokrągli. Ale to już tam nieważne. Bardziej ważne jest to, że dla y równego 0 nie mamy prawidłowego wyniku w tej naszej kodomenie `Int`ów. To nie jest ani 0, ani `Int` max, ani nic takiego. Ta funkcja jest częściowa. Czyli działa, mimo iż ma opisane właśnie tę swoją domenę i kodomenę, to jeszcze dodatkowo potrzebujemy gdzieś tam informacji zawartej, że taka funkcja częściowa jest tylko... Działa tylko dla jakiegoś podzbioru tego tej kodomeny i tej domeny.

Więc wygląda to tak, że jeżeli popatrzymy na to właśnie w postaci mapowania, czyli mamy jakiś zbiór tych parametrów wejściowych i zbiór tych rezultatów, to ma to funkcja to jest mapowanie od takiego właśnie jednego elementu do jeden do jednego. Natomiast jeżeli funkcja jest częściowa, to dla niektórych tych elementów wejściowych nie ma elementu wyjściowego. Sorry. Ale to nie jest źle. To się czasami przydaje, bo to jest jakby właśnie takie połączenie filtrowania z mapowaniem. Prawda?

Mamy... Możemy powiedzieć sobie, że mamy pewien pewien mapping, ale ten mapping działa tylko dla jakiegoś podzbioru funkcji. No i to jest właśnie ten... Właśnie mamy takie metody jak `collect`, również czasami zwane filter `Map` w niektórych w innych w innych językach. I ten `collect` na przykład działa właśnie nad czymś, co jest taką funkcją częściową. W tym sensie...

O, tutaj jest akurat głupi przykład, że mamy koty. Koty to jest struktura danych, które mają imię i kolor. I jeśli byśmy chcieli dostać tylko koty, które są... Tylko imiona kotów, które są czarnymi kotami, to byśmy zrobili właśnie filtrowanie po kolorze i potem mapowanie na imię. Ale można to samo zrobić właśnie w ten sposób, czyli użyć metody `collect` po to, żeby wpisać to słówko kluczowe `case`. Znowu. To jest właśnie... Ten to słówko nam daje informację, że tutaj będzie funkcja częściowa i że w tym wypadku jest to funkcja, która dla każdego kota, który ma kolor czarny, zwraca jego imię. Tylko że jeżeli kot nie jest czarny, to ta funkcja nie działa w ogóle, wywali się. Tak samo jak to dzielenie się wywali.

Więc możemy dzięki temu... Jakby metoda `collect` na tej na tym worku z kotami działa równocześnie jako filtr i jako `Map`. Istnieje też metoda `collectFirst`, która będzie działać w ten sam sposób, ale tak jak `collect` jest jakby odpowiednikiem filtr, to `collectFirst` jest odpowiednikiem find. Czyli zadziała w ten sposób, że znajdzie pierwszy element, dla którego ta funkcja częściowa działa i wtedy, jeżeli ten element... ten Jeżeli ta transformacja zadziała, to mapowanie, to zwróci wynik tego mapowania. Więc jakby nam załatwia to właśnie to filtrowanie i mapowanie wspólnie.

No i dobra, użyjmy tego, co nie? Więc def. Jakby better version. Też its. I też do option.

I to, co my tutaj robimy. W its. `collectFirst`. Zrobimy w ten sposób. `case`.

`id` i w `validate`. I na razie to nam, jak widzicie, pomogło tylko tak, że ten kod trochę inaczej wygląda. Może no może bardziej fancy. Natomiast nadal... O, tylko sobie sprawdzimy, czy to to rzeczkolwiek jest w porządku.

Nadal robimy konwersję, walidację i znowu drugą konwersję. O, to nie jest to, nie jest to, czego byśmy chcieli zrobić.

Na szczęście w poprzednim tygodniu mówiliśmy o `unapply`. I `unapply` to jest metoda, która właśnie dla jakichś elementów, dla jakiejś struktury danych potrafi je rozbić na części. Ale też to to nie jest jedyna rzecz, którą ona potrafi robić.

Poza tym to nie jest też tak, że dla każdego tutaj użytkownika, prawda? Jedyne, co taka `unapply` może zrobić, to to to właśnie rozbić... to to Musi to być `unapply` dla w tym singletonie, w tym companion object usera i może tylko rozbijać tylko te `id`, name, email, `age`. Tak naprawdę może być... Możemy zrobić to inaczej. Możemy zrobić object. `validUser`.

Def `unapply`. `user`. `user`.

I to jest coś, co... Poprzednio mówiłem o tym, że dla że zawsze na przykład dla jakiejś struktury danych takie rozbicie na elementy zawsze będzie działać. Ale czasami może być tak, że nasza struktura danych właśnie nie da się rozbić i wtedy powinniśmy wrócić. Wtedy powinniśmy użyć tej opcji, że `unapply` zwraca nam opcję jakiejś struktury danych, a nie tylko struktury danych. A proszę. I to, co się dzieje tutaj, to to właśnie walidujemy i zwracamy tylko wtedy, kiedy... To tylko wtedy, kiedy działa. Co więcej, to wcale nie musi być `user` `user`, to może być `user` `id`.

Zrobimy... Zamieniamy tak. Tak.

I teraz robimy tutaj...

`val` `user` równa się `convert` `id`. A to mogę zamienić na... Coś takiego. Co więcej, mogę tutaj łatwiej... Albo dobra, zostawmy to na razie w ten sposób. Som `user` fioto. Som `user` find tak naprawdę. To będzie jeszcze o tym. A i teraz, co mogę zrobić? Wezmę sobie tego `val``id` usera. I go napiszę go tutaj.

Def yet better version. I to dalej... To idzie tak samo.

I to, co mogę zrobić tu, to napisać `case` `validUserId`.

Assolement. Coś coś namieszałem chyba. Hop hop hop.

Full option bar.

A. `case` `validUser` `user`. Zwracam usera. I zróbmy to jeszcze raz. Yet better version.

Aha, no i tutaj wykomentujmy. Dobra, znowu zwracamy Boba.

A i co tu się dzieje? `collectFirst` nadal pobiera funkcję właśnie taką funkcję częściową i ta funkcja częściowa działa w ten sposób, że dla danego użytkownika wywołuje `unapply` w obiekcie `validUser`, czyli to jest `validUser` `.` `unapply`, tutaj by było. Dla każdego dla jakiegoś `id`, do pierwszego `id` stąd.

To, co nam `validUser` daje w efekcie, to jest cały `user`, całą instancję `case` `class`, pod warunkiem, że uda się go skonwertować. Jak się nie uda go skonwertować, daje non i wtedy wiemy, że ta funkcja częściowa nie działa. I wtedy `collectFirst` idzie do kolejnego elementu i sprawdza, czy może tamto działa. Jeżeli się uda, jeżeli dostaniemy jakąś jakieś `user` `id`, które udało się skonwertować na usera, to wtedy zamieniamy, wtedy zwracamy tego usera. Jeśli nie, jeśli przejdziemy przez całą kolekcję ids i nie będzie takiego usera, który będzie pasował, zwrócimy non.

No i to działa tak. Możecie teraz pomyśleć, dobra, no ale co w takim razie w przypadku tego bardziej skomplikowanego? Tutaj jest brzydko, prawda? Czy jeżeli ja teraz się tutaj narobię, zrobię właśnie taki bardziej skomplikowany przykład, to też będzie brzydko? Czy może będzie ładniej? A No dobra, zróbmy to. Po pierwsze, `nullableConvert`. `nullableConvert`. Ale... `nullableConvert`. Proszę. I `nullableConvert` zwraca nam... `user` get it or null.

Ale to, co możemy zrobić tak naprawdę, ponieważ już mówiliśmy, że używamy że optionów, to możemy nawet możemy iść w tym dalej i zrobić zamiast `nullableConvert` coś, co się będzie nazywało... Def optionable `convert`. I to, co optionable `convert` robi, to jest `user` `id`, to zwraca opcję od usera. A to jest po prostu `user` `Map` get `id`. W sumie nie musiałbym tego robić. Ale jeżeli zrobię optionable `convert`, to proszę, to popatrzcie, że tutaj mamy sytuację, kiedy mam już... Właśnie działam na takim som, to jest taka specjalna konstrukcja. Mogę to zrobić tak. Po prostu. Czyli nasz `unapply` tak naprawdę zrobił się prostszy, mimo iż miał być trudniejszy.

No dobra, ale mamy tutaj te tego find'a i tam jest tylko jedno `validate`. Więc zamiast tego find `validate`, trzeba byłoby zrobić coś takiego, że dobra, mamy... Save `validate`. Czyli tutaj mogę muszę zrobić o `user`. I teraz save `validate` `user`. Lub. `otherValidate` `user`. Lub. No i tutaj tutaj jest właśnie ten brzydki jak noc listopadowa fragment, którym... O, trzeba zrobić coś takiego. Eee No okej. No i teraz mamy yet better version. To się nadal... To nadal będzie działać, tylko wygląda tak trochę... hm hm hm Ale to nie koniec. Otóż możemy zrobić sobie wersję, w której mamy właśnie... Zamiast takiej postaci zrobimy po prostu `case`'a. Czyli będzie właśnie `case` `user`. Czyli właśnie jeżeli jesteśmy w stanie... I save `validate` `user`. `user`

Możemy też... Aha, możemy zrobić na przykład coś takiego zamiast tych opcji. To jest `validUser` `unapply`. Możemy też zrobić object other `validUser`. Prawda? I sobie też tutaj rzucić tego `unapply`'a.

Tak, tylko teraz będzie...

Czyli tutaj zostawiamy sobie tylko save `validate`. Tutaj zostawiamy sobie tylko... O Tylko to. Tutaj zostawiamy sobie tylko...

O, bo nie, bo to właśnie brzydko wygląda. Dobra, wróćmy.

To, co ewentualnie możemy zrobić, to właśnie jest `case` `user`. If save `validate` `user`. To wtedy `user`. Następnie... Co on mi tutaj próbuje teraz? Aha, `otherValidate`. Dobra, i `case`.

Student. Typu student. To wtedy... If student `validate`. Student, to wtedy student. Aha, no i wszędzie tutaj powinno być som. Som.

I tutaj też som.

Czy się nie podoba?

Aha. Aha, `case`. Czyli możemy... Aha, to dobra, trochę tutaj namieszałem. `case`, ho ho. `otherValidate`. Tak, to zostaje.

Jeżeli `case` student, to student `validate`. Może być trzecia opcja. Dobra. Unretable. Trzeba go puścić jako pierwszego w takim wypadku. No jak jest tutaj pewnie bez retesta, podstawa, póki sprawdzamy, potem dla wszystkich innych `user`ów będzie to działać w ten sposób.

Ok. Coś jeszcze... Co ja jeszcze chciałem dalej? Jest jeszcze tutaj coś... Jeszcze dwie rzeczy, które chciałbym poruszyć, jeśli będę miał na to czas, ponieważ...

Ale dobra. To będzie jakby dodatek do tego do tego wykładu. Zobaczymy, czy czy zdążymy z nimi. Czyli będzie trzeba tutaj zmienić... Wrócić do tej prostszej metody, a następnie, ponieważ prostsza metoda zawsze... Zawsze `convert`, a potem find, to w takiej to w takim wypadku będzie trzeba... Będzie można to jakby wyekstrahować tą logikę trochę wyżej. Zobaczymy, co z tego wyjdzie. Na razie to tyle.