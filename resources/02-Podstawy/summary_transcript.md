## 🎯 Kluczowe wnioski

**Główne punkty:**

- **Zrozum podstawy Scali:** Zaczynając nowy projekt Scala, zapoznaj się z kluczowymi koncepcjami, takimi jak zmienne `val` (niezmienne) i `var` (zmienne), definicje funkcji (`def`) oraz klasy i `case classy`.
- **Wykorzystaj niemutowalność:** Preferuj użycie `val` i `case class`, aby tworzyć niezmienne struktury danych, co ułatwia testowanie i przewidywanie zachowania kodu.
- **Korzystaj z `case class` dla danych:** Wybieraj `case classy` zamiast zwykłych klas do reprezentowania struktur danych, ponieważ automatycznie generują metody `equals`, `hashCode`, `toString`, `copy` oraz `apply`/`unapply`, co usprawnia kod.
- **Zastosuj `match case` do logiki:** Używaj konstrukcji `match case` do implementacji złożonej logiki warunkowej i destrukturyzacji obiektów, co zwiększa czytelność i ekspresywność kodu w porównaniu do tradycyjnych `if-else`.
- **Funkcje jako wartości:** Traktuj funkcje jako obywateli pierwszej klasy, przekazując je jako parametry i zwracając z innych funkcji, aby zwiększyć elastyczność i bezpieczeństwo typów.
- **Pamiętaj o wyrażeniach:** W Scali wszystko jest wyrażeniem, co oznacza, że każda operacja zwraca wartość. Unikaj słowa kluczowego `return` i skup się na wyrażeniach, które zwracają rezultaty.

## 🔍 Podsumowanie

**Wprowadzenie do Scali i tworzenie projektów**
Podstawy języka Scala są omawiane z perspektywy programistów znających Javę, C++ lub Pythona. W kontekście tworzenia nowego projektu w IntelliJ IDEA, pokazano, jak skonfigurować projekt Scala, wybierając narzędzie do budowania (SBT) oraz wersję JDK i Scali. Wskazano, że Scala 3.8 działa z Javą 17 lub nowszą. Omówiono również opcję pobierania źródeł, co jest pomocne przy korzystaniu ze standardowych bibliotek. Ważnym elementem jest wybór składni: bardziej javowej (z nawiasami) lub bardziej pythonowej (opartej na wcięciach), przy czym ta ostatnia jest dostępna tylko w Scali 3.

**Zmienne, funkcje i klasy**
W Scali zmienne deklaruje się za pomocą `val` (niezmienne wartości, odpowiednik `final` w Javie) lub `var` (zmienne wartości). Preferuje się `val` ze względu na idiomatyczną niemutowalność. Funkcje i metody definiuje się słowem kluczowym `def`. Typ zwracany jest umieszczany po nazwie funkcji, co ułatwia pracę kompilatora. Wartością zwracaną, która odpowiada `void` w Javie, jest `Unit`. Klasy w Scali, podobnie jak w Javie, służą do tworzenia obiektów, ale deklaracja pól jest uproszczona, a domyślnie są one publiczne i niezmienne. Przeładowanie metody `toString` odbywa się za pomocą słowa kluczowego `override`.

**Case Classy i ich zalety**
Jedną z kluczowych różnic w Scali są `case classy`, które są zaprojektowane do reprezentowania struktur danych. `Case classy` automatycznie dostarczają implementacje metod `equals`, `hashCode`, `toString`, `copy` oraz `apply` i `unapply`. Dzięki temu kod jest bardziej zwięzły, a praca z danymi staje się łatwiejsza. Metoda `copy` pozwala na tworzenie nowych instancji obiektów z modyfikacjami, co wspiera niemutowalność. Funkcje `apply` (smart constructor) i `unapply` (destrukturyzator) umożliwiają tworzenie i rozpakowywanie obiektów w bardziej elegancki sposób, np. w ramach dopasowywania wzorców.

**Dopasowywanie wzorców (`match case`)**
Konstrukcja `match case` w Scali jest rozbudowaną wersją instrukcji `switch` znanej z Javy. Pozwala ona na dopasowywanie wartości do złożonych wzorców, w tym do destrukturyzacji obiektów i sprawdzania ich wewnętrznych pól. To narzędzie jest bardzo potężne do implementowania złożonej logiki warunkowej i analizy struktur danych. Rekurencyjna destrukturyzacja pozwala na dopasowywanie wzorców na wielu poziomach zagnieżdżenia obiektów.

**Funkcje jako obiekty pierwszej klasy i niemutowalność**
W Scali funkcje są obywatelami pierwszej klasy, co oznacza, że mogą być przypisywane do zmiennych, przekazywane jako parametry i zwracane z innych funkcji. Zwiększa to elastyczność kodu i wspiera bezpieczeństwo typów. Cały kod w Scali jest traktowany jako wyrażenie (`expression`), a nie instrukcja (`statement`), co oznacza, że każda operacja zwraca wartość. Unikanie mutowalnego stanu i poleganie na niemutowalnych danych (`val`) oraz wyrażeniach prowadzi do kodu łatwiejszego do testowania i przewidywania. Przykłady takie jak obliczanie środka trójkąta z użyciem pętli `while` i `for`, a następnie redukcja za pomocą `reduce`, pokazują ewolucję od imperatywnego do bardziej funkcjonalnego stylu programowania.

**Trace, klasy abstrakcyjne i hierarchie typów**
Scala oferuje `trace` (cechy) jako alternatywę dla interfejsów i klas abstrakcyjnych w Javie. `Trace` pozwalają na definiowanie wspólnych zachowań dla różnych klas, a klasy mogą implementować wiele `trace` za pomocą słowa kluczowego `with`. Enumy, wprowadzone w Scali 3, również pomagają w tworzeniu przejrzystych hierarchii typów. Omówiono także potencjalne problemy związane z wielokrotnym dziedziczeniem (`diamond problem`) i sposób, w jaki Scala je rozwiązuje poprzez kolejność `with`. Wskazano, że złożone hierarchie dziedziczenia należy stosować z ostrożnością, aby uniknąć problemów z czytelnością i błędami

# Translation

Hi, today we'll cover Scala basics: keywords, syntax, and fundamental concepts, similar to Java, C++, or Python. Knowledge of any of these languages should suffice.

Let's start with a new project called '`Trigonometry`.' The setup shows we could create a Git repository (though we won't today), select Scala as the language, and choose a build tool like SBT or Scala CLI. I'll use SBT.

For the JDK, we can choose any version - let's go with 25. Here we also select our SBT version - this is the latest stable version (2.0 is experimental), and the latest Scala version, 3.8.2.

Here on the right, we can download sources for both SBT and the compiler. Downloading SBT sources only makes sense if you're working on an SBT plugin. Downloading Scala sources can be helpful when using standard collections or other library classes, as having the source code will help with your work."

And one last thing: Significant Indentation Syntax, which I mentioned last week. Scala 3 offers two syntax options: Java-like (which I'll use today to avoid confusion) and Python-like (which I may discuss later). In Scala 2.13, only the brace syntax is available. Let's return to Scala 3.8.2.

There are some advanced settings here but we don't need to use them. 'Add sample code' would create a simple main file, but let's disable that - I'll write it myself. The name is '`Trigonometry`'. IntelliJ has created a build.sbt configuration file with the information we provided and version 0.1.0 snapshot, which is fine.

Here in SBT we have build properties in the project directory with the current version. The src/main and test directories are created but currently empty. Double-clicking takes you to project structure, but there's nothing interesting for us yet. Let's create our first file: new, Scala class file, of type object, or simply a `Trigonometry` file.

Ok, this is our main class. Let's create a basic main method. IntelliJ shows live templates here - when I type 'main', it finds the template. If I select it now, I'll get it immediately. Ok, let's select it and write 'hello `Trigonometry`'. Clicking "Play" will compile and show 'hello `Trigonometry`'.

In the terminal, I can go to this new project and run exactly the same thing using SBT. I already have SBT installed, and here I'm using Java 17 only. All Java versions from 17 and above work with any Scala versions. However, Scala 3.8 only works with Java 17 - if you have an earlier Java version than 17, you can only use Scala 3.7 at maximum.

Ok, we've entered the `Trigonometry` project in SBT. We can compile and run to see 'hello `Trigonometry`'. We're here, but before moving to keywords, there's one more thing: in Settings > Appearance you can change the general font size, but the editor font size is changed separately under 'font'. There's also an option to use ligatures instead of ASCII characters. For example, I prefer actual arrow symbols over equals and greater-than signs.

Let's start with annotations - the least important here. They work like Java's, but we prefer compile-time annotations over runtime ones.

Here we have the 'def' keyword for defining methods or functions. Scala follows Kotlin's syntax `def name(params): returnType` rather than Java's `returnType name(params)`. I'll use 'method' and 'function' interchangeably unless the distinction is important. Java's syntax comes from OOC/C++ - it was thought to be good for programmers in the 90s. The reason for this is that having return types at the end makes the compiler's job easier, particularly with complex code.

So we have this main method with Unit return type - which would be void in Java. Then we have parentheses with some expression inside - println that dis"Play"s something on screen but doesn't return Unit. Unit isn't actually void - it's this ultimate singleton with no data inside, just one instance of this Unit type. Well then, let's move on to a new project: main, def/val/var. Of course we can do, we can do here for example val x equals 1 and then dis"Play" this x. x equals x, and here I have code completion that immediately suggests x equals 1.

And here on the side we'll turn on this roadmap - it'll be a good reminder for me. We've just gone through this, covered IntelliJ IDEA, and now we're at the learning basics stage. Before we move to standard operators, method calls, conditions, some String basics, functions as data, and main data structures. We'll handle types separately, but it's good to have this reminder.

Okay then, why val? Val is how we declare an immutable value. If I try x = x + 1, that's an error. But I can do val y = x + 1, and then y = x is fine. But if I actually wanted a mutable variable, I'd need to do something like this... and now it works, x is actually mutable. Having this ability to make variables is useful. But idiomatically in Scala, we prefer immutability - situations where if we need to calculate something, we calculate using immutable values. 

Constant is a word that means something is truly 100% immutable, forever. In Scala we use constants so often that it's become much easier for us to use this concept. So we talk more about values. Here I simply have x = 1 - if I want to change or calculate something based on it, I'll create y. With immutable collections, I transform them and create new collections instead of modifying the existing ones, and so on

So we have val values, var variables, functions defined with def, and classes. Here we can create a Point class with x and y of type Int, and now I can make val p with Point(1, 2) for example. This is also correct. I'm using AI assistant to speed things up - it can be annoying sometimes but helpful in other cases. With more complex work, its suggestions become less accurate - then you can go to settings and turn it off. For now, it just makes my live coding a bit better, so I'll keep using it. If anything is unclear, ask questions, raise your hand - I can stop at any time to explain something.

Okay, so a class is the same as in Java, but field declaration differs. Here we have x and y fields. Instead of Java-style separate lines, we can declare them this way. For mutable fields, I could use var here. Anyway, we usually use classes to hold data, and now we can declare data this way. This also serves as constructor. In Scala 3, constructors don't need 'new' (Scala 2 did). Sometimes 'new' helps - we'll get to that. Unlike the primary constructor that sets fields, using Point() directs us to the apply method constructor which can do more. Okay, let's do something like this.

Let's click 'Play' now - you should know this from Java too. Instead of displaying something familiar, we get just a reference to this `Point`. Do we need a `toString` method to display this `Point` properly? Of course we can do that - we can write override `toString` here, and it would be called '`Point` x y'. If I do that now, it will display '`Point` in the'. The override keyword works like in Java. We're using the fact that every class, like in Java, has some super type, so `toString` already exists somewhere, but we're making a new version, overriding the old `toString`.

But there's one thing that clearly distinguishes Scala from Java. Long ago when people programmed in C (when mammoths roamed the earth), there were no classes, just data structures. A data structure simply declared what data was inside - that data could be other structures or `Point`ers to them, or primitive types of specific kind and size. Then you wrote functions that took such a structure as a parameter and returned another - for example after some modifications it could return the same or another data structure. Functions and data structures were separate, but often the functions depended on the specific data structure.

We had sets of functions that worked well with specific data structures. In C++ (and not only - I'm simplifying, this isn't a programming history lesson), ideas emerged for classes - data structures that besides having fields also have methods that work on those fields. This exploded quickly - we started having classes that could be very complex, with many different methods for many different data types. We could override these methods, concepts of abstract classes and interfaces emerged, data became public or protected or private. Generally, C++ still has a big mess in this regard. But if we look at how we actually use classes in production code - in market applications - we'll see we actually have this on a spectrum: on one side classes that are mainly data structures with maybe some small set of specific simple methods, and on the other side managers, factories, builders, facades and so on.

These are classes that have little or no data - often they only have references to instances of other classes, and have methods that simplify using those classes because those classes somehow work together. We have methods that reach through references to call methods on one instance, then send results to methods on other instances, and so on. In the middle between these extremes we have collections for example, which have quite a lot of data but can also have complex methods and deep hierarchies of abstract classes. In any case, we can see there was a need to have a separate language construct that clearly distinguishes data classes from logic classes.

And that's why concepts like case class emerged in Scala, in Kotlin we have data class, in Rust we have structures. Case class is primarily... if we go back here, I can make case class `Point` and the case class describes these x and y for me, and I don't need to override toString anymore because case class already has an overridden toString, so it works.

Moreover, IntelliJ highlights this differently. I couldn't use this x because by default it's inaccessible. With case class we assume x is immutable and public, so I can use it here. Now I only have a highlight that this does nothing because it's just a pure expression that isn't used. I can delete it. Case class primarily treats its fields as immutable by default - as if there was val here. val is unnecessary - IntelliJ already grays it out. I could declare it as variable but that's bad code - I would never allow that in review. Case class should be an immutable data structure and doesn't need override def here - it's completely unnecessary and will work fine.

Moreover, case classes have additional methods provided by the compiler. For example, we have val qp copy - this method takes the original `Point` and creates a new `Point` instance while allowing modifications. With original 1, 2, if I run this now, I'll get 3, 2. This is the more idiomatic, functional way of programming in Scala - when we have immutable data structures and perform operations that create new structures based on the old one with modifications. We can also compare them - for example I can check if p equals q. This shows false, but it's false not because these are references to different classes, but because they're different instances with different values.

In Java, == would compare references, while I'd need p.equals(q) for value comparison that must be overridden. In Scala's case class, comparison between instances compares internal field values. For example, if I set x=1 (no change), I could delete this entirely - then if I do this and run it, I'll get true. What else do we have here - hashCode, yes, because we need it with equals. We also get apply and unapply methods.

The `apply` method is what's called a smart constructor. We create it using a companion object - I can write companion object `Point` which will be associated with the `Point` case class. Now I can write an `apply` method that takes an Int parameter and returns Point(a). Now I can do `Point(5)`. What happened is that this called not the constructor directly, but called the `apply` method, which then called the constructor. There's also `def this` for secondary constructors, but we most often use the `apply` method.

The `apply` method is kind of a trick because all it does is call the method defined in the object - it's as if I wrote `Point`.`apply`. But the special property of `apply` is that it's called automatically when you use parentheses with data - the compiler checks if it should call `apply` with this data. That's all there is to it. On the other hand, un`apply` is a bit more... maybe a bit less intuitive, especially when we have `unapply` here.

The unapply method takes a `Point` and returns an Option of tuple by default. A tuple is like in Python - I can have a variable t with (2, 3) and that works too. But let's not worry about Option for now. unapply can return directly if we're certain the destructuring will succeed, because sometimes it fails - we might have a class instance that can't be decomposed. But here we have a simple case where it's certain to succeed, so at this `Point` we can do something like this... and now I want to do println(x1).

Ok, what happened here. This line works in reverse compared to that line. In that line, we have a constant (5) that is wrapped in a Point via apply method, creating an instance with x=5, y=5. But here something happens in reverse, only because the compiler knows what to do. We have this reference to `Point` q, and on the left side we declare constants px and py. Through destructuring q (by calling unapply), unapply should return a tuple with px and py values. Because this declaration matches how q can be destructured, the compiler assigns these values to the fields.

Of course, because I mentioned that case class fields x and y are always public. Actually, in regular classes too, not just case classes, we can have... let's go back here. Yes, it highlights red now, don't worry about it. If I have a equals 1 here, this value will be public by default, because in Scala fields are immutable by default, so we don't need to make them private like in Java. This might surprise you because in Java everything is private by default with encapsulation, and we use getters and setters to access or modify variables. 

Here, because everything is immutable, we assume by default that we can expose fields - we can make them public and just use them, because no one can change p.a's value. It's read-only. Or better yet, instead of a let's do something more meaningful, like writing a `length` method. This is our public method and of course we could make it private or protected, but case classes typically don't have subclasses, so that doesn't make much sense.

That case classes don't have subclasses isn't entirely true. Due to compiler nuances, a case class isn't completely final - I could write a subclass if I wanted to. However, this is typically just a feature used in Scala's standard library, not externally. If I wanted to completely prevent subclassing, I could use the `final` keyword here, but we'll get to that later.

Of course with final classes, we need the ability to create superclasses. Classes can be abstract, interfaces can be created. But first, one more thing - match case. We have this `Point` reference that we can display. But we can also do something like this with `val p = Point(5)`: `p match ...`. And oh right, in this way. You recognize this, right? If we can do unapply this way, we can also use match case construction - like Java's switch but more powerful.

We can say: okay, if we have p and it can be decomposed into a `Point` with x and y fields, let's display it. For example Point(5, 5). But what if we wanted to only display when y equals 3? Now it doesn't display. We also get an error because match case doesn't consider all possibilities. It's not that this case is that - case is the same keyword as in case class. Here in match case, case means: let's try to decompose this `Point` to get x and y fields, and if y equals 3, then do this.

Okay, but what to do when y isn't 3? This is our delegation. But when we didn't have this case, we got 'insert missing cases' here, which also won't work because `???` in Scala means 'not implemented' and we still get an exception. The difference is that with `???` it compiles because we never enter this case, but that's kind of cheating.

But you might say: we could do the same with if/else. If p.y equals 3, then `println(s"`Point` coordinates: $p")`, otherwise something else. This works, with one difference - we're not using unapply, just checking a simple if/else. Both work similarly. This might only show that match case is slightly more readable with many cases, but its real strength comes from using unapply.

We can make another case class called Triangle that has three `Point`s. Let's create a Triangle with vertices Point(1), Point(2), Point(3) and call them a, b, c. Now we can pattern match this `Triangle` like this: case `Triangle` if we have a, b, and `Point` x then println something. Otherwise, if we don't have such a `Triangle`, then what? If we have a `Triangle` with Point(1, y) and don't care about the other two `Point`s - okay, let's say we have a third option - that will work too.

You see, this destructuring is kind of recursive - maybe recursion isn't the right word, but we can go inside. If we have a `Triangle` and it has its own unapply, then we can use another destructuring inside, another unapply - because case class `Point` has unapply. At any level we can check if it matches the case we want to use. This really makes working with logic easier. If someone asked me about the most important feature in Scala, I'd say this is the most important practical feature in Scala."

Okay, moving on. Triangle match case. Another thing you might find interesting - there's no return keyword. It technically exists - I could write return, but first it's unnecessary, second it's deprecated since Scala 3.3 or 3.5 or something recent. Anyway we don't need return because everything we do in Scala is an expression, not a statement.

When we perform calculations, main returns Unit and the length method returns Double. Let's create another method called centerPoint in the Triangle class. This method returns a Point which is the average of `Point`s a, b, and c. Let's do this similarly but slightly differently. We have `def centerPoint` here which takes a `Point` and returns a `Point`. The curly braces are unnecessary because we really have only one expression - one line split just to make it look nicer.

And now we can use it, for example in `println(s"`Triangle` `centerPoint`: ${`Triangle`.centerPoint}")`. Now we know the `Triangle`'s `centerPoint` is (3, 4).

Chciałem wam pokazać, że jest również opcja, aby zapisać dokładnie to samo jako wartość, w Scali funkcje są first class citizen, czyli są traktowane dokładnie tak samo jak, dokładnie tak samo jak wszelkie inne, wszelkie inne rodzaje danych i to jest właśnie ta wersja, tylko teraz musiałbym chyba, tak, teraz, teraz kompilator nie wie, czego ma użyć, czy mają, czy tej, czy tej wersji, wskazujmy to, co tu się dzieje, po kolei. 

Normally we have data types like int, double, boolean, String, car - same as Java and Kotlin. We can also have references to literals, like an Iron Man String with value 'Tony Stark' of type String. We can have number 4 (int). We can have classes with references to literals and other complex types with their own literals or references. But we also have functions, like a multiplication function that takes x:int and y:int. This function takes these parameters, multiplies them, and returns an int. The function's type is its parameters and return type - that's the function type, like domain and codomain. These two ways of writing function types are equivalent.

Just as we had name, type and value for data, we have name, type and value for functions - the logic that executes when called. Like with other data types, we can create a class (or case class) and use this function as a value parameter, passing it to this Tony Stark case class with `mul` as the second parameter.

The most important thing, and what I think is really great, is that this helps with type safety. Our types aren't just for variables - we can pass function types everywhere and use them to calculate new things from our variables. This gives us built-in minimal documentation. We can see: okay, we have these variables, and this function variable that takes these variables and returns something else. But we know the types, so we can understand what happens with the data even without looking at the implementation details.

The second important thing is good variable naming, which is difficult. But the second thing that helps functional programming is immutability. With immutable data, same input always gives same output. This is much easier to test, and we can better predict future calculation results. If the world state doesn't change, but if our function changes something, next call might use that changed value and have changing state. This can cause the same function with same parameters to give different results, making our life very difficult.

And there's something nice about expressions instead of statements. Instead of sequential operations that change state, we have expressions where everything is passed via parameters and returned as result, with results flowing to next expressions. Here's a simple example: an event method in statement style that takes a number, checks if it's even, and immediately prints. This is imperative programming with line-by-line property checks and actions.

In functional programming in Scala and other languages, it's more idiomatic to split code into small expressions that each do one simple thing. For example, here we check if a number is even and return something - a String here, but it could be a boolean (just number % 2 == 0). The result is more flexible - it can be used in ways the original author didn't anticipate. Someone could use this event function elsewhere in the code months later, unlike the version that immediately prints to screen. Even better - because such expressions are values with types (takes int, returns String), this event can be flexibly passed as parameter and returned - functions can be returned from other functions too.

That's probably all I have to say on this today. This diagram is part of a larger one that helps with readability. It's part of a larger diagram that I want to return to and discuss the different elements I have outlined here. For now we're roughly in this area.

Let's go back to the code. We have this Triangle center - as you see, we can call Triangle centerPoint and use this centerPoint which has Triangle→Point type. We could remove it but it would be uglier. This means centerPoint can be used and passed on its own. I could do f = Triangle centerPoint itself - I don't need anything else, just f Triangle.

IntelliJ is trying to show us f's type. Scala has type inference - the compiler deduces types. Here we know it's a Triangle→Point function. We don't need to write this - we can if we want, but don't have to. This improves readability, and the effect is the same because we've assigned this function to f and use it this way.

Okay, let's say we have Triangle here. Let's also have Quadrangle - yesterday I checked that's the English term for czworokąt. It will have a Point, b Point, c Point, d Point. It's any quadrilateral - not necessarily square, rectangle or trapezoid - and it will also have a centerPoint. For now, let's leave this centerPoint unimplemented.

What I want to show is that like Java, Scala has interfaces and abstract classes - we could have an abstract class shape. But we more commonly use traits - which were designed this way from the beginning. CenterPointable - a trait that both triangle and quadrilateral should have a center. This trait gives us the centerPoint method regardless of whether it's a triangle or quadrilateral. We use extend to implement this, and we can extend multiple traits.

Let's declare an enum - shape enum with cases Triangle and`Quadrangle`. These are different from the shape Triangle and different from case class Triangle. So we'll always use it with shape.dot notation. Now there will be a shape name trait with val - this is essentially what I wanted to say: name of shape.

By the way, Scala 2 didn't have enums - we used other constructions. We'll discuss that in a week or two when covering more complex type hierarchies. For shape name of type name, I could do centerPoint with shape name, declaring shape Triangle here and`Quadrangle` there. Order doesn't matter here - I could extend shape name with centerPoint. But it matters for the diamond problem: trait a with def some a = 1 (def int), then trait b extends a with val (we can override definitions with val - value is a special definition that never takes parameters and always returns one result) = 2, and trait c extends a with override a = 3.

Now if I remove this or at least... okay, let's look at the code. I could create class D extending C with B, with val d equals D() and println d.a. What do you think this will show? It should show 2, right? Correct - that's what the code shows. But if I change the order to B with C... otherwise it's type int... but what isn't? a, okay, so here it also must be val.

Here's 3 because: the class extends trait b (a=2), then we add trait c (a=3). This causes problems when we have a value here and definition there - compiler doesn't know what to do. There are puzzles about final values in complex hierarchies. This is the diamond problem: one top superclass/trait, two independent side traits, then bottom. Java used to prevent implementation in interfaces. But Scala and new Java allow trait implementation, bringing back the problem. Scala solves it with extend/with - each with adds a trait that overrides previous ones. We can have one abstract class like Java, and multiple traits.

However, what's important to emphasize is that these puzzles aren't the only right answer. When someone presents such a puzzle, the answer should be 'don't do this at all'. This is asking for errors. If you see production code depending on trait order, something is wrong. Refactor immediately. Leaving it will cause bugs when changes are made, and you'll waste time tracking down the trait order issue. Don't do this.

Quadrangle... what we could do today is discuss the Trigonometry object. I can delete it and create a distanceBetweenCenters method that takes two centerPoint parameters and returns a double. Okay, this is how it will look. Since we're using intact everywhere, let's make this intact too. Now we need to call this int. Okay, so what's happening here is let's say we have one Triangle, let's take this Triangle.

And let's take val quadrangle. Okay, no more of that. Now val distance will be Trigonometry.distanceBetweenCenters between Triangle and Quadrangle, and println distance equals distance... and we got unimplementation error. Ah, right, because that's the point - we don't have centerPoint here anymore.

Let's assume for a moment that this can't be done this way. We can do it differently - using loops. We have four points. We can create a sequence - seq is Scala's basic collection - simply like this. Let's do it completely iteratively first. We have var sum x, sum y - no, sum x equals 0, var equals 0 - and now while i and index var i. Right, we can run this. Distance 1 - I'd prefer everything in double for cleaner code..

Let's work on centerPoint. Length is double, centerPoint is int... okay, let's make this double - or not even rename, just refactor and change signature. We can do this - I'm exaggerating. Return type double, refactor - maybe delete and run again. Okay, we get a nice distance. This is also an example of using while loop this way. But there are more functional ways to do the same thing. We avoid declaring variables just to use at the end. Though local variables are still fine in Scala, since standard library methods use them internally to avoid external usage. This is somewhat like low-level coding.

So what we can do instead is use a for loop: for p in seq, sum x += p.x, sum y += p.y - and it works, gives us the same result. We don't need that index variable anymore. This currently works somewhat similarly to how it would in Java - we have a sequence where we get one element at a time. But in future classes, we'll see that this is actually more complex and allows for more interesting effects than what's possible in Java. And also, to give you a preview of what we'll talk about in upcoming sessions - we can do the same thing completely without using variables, more like this: we can delete this and use sequence.forEach, which is a method from Scala's standard library that for each element invokes some action.

But what's even more interesting, we can use seq.reduce { (p1, p2) => p1 + p2 } and get the same result. This is a bit overcomplicated for this operation, but uses what I mentioned earlier. We have this sequence class method that takes a function parameter. The function takes two points - generic types B, but here it's a sequence of points. I can add this: oh, sequence of points. So this reduce works on points: takes two points, returns one. It takes first point a and second point b, adds them. The logic is: create a new point by adding x and y, this new point becomes the first point for next operation, while c becomes the second point. We add x and y again, and this first point is exactly our result.

Then we take point d, add again, and since our collection is finished, we return this point that is the sum of all points - but also immediately destructure it into sum x and sum y. Then we return another point which is sum x divided by length (here sequence could be simply 4), and sum y divided by 4. This returns the basic centerPoint which is then used in distance between centers. We see that this method returns Point type and the last line of this expression is what's returned. That's it for today. Next time we'll discuss collection methods, parameter passing, and I think this will take the whole lecture.

```scala
final case class Point(x: Int, y: Int) {
  def +(p: Point): Point = Point(x + p.x, y + p.y)
  inline infix def add(p: Point): Point = this.+(p)
}

object Point {
  def apply(z: Int): Point = new Point(z, z)

  def unapply(p: Point): (Int, Int) = (p.x, p.y)
}

trait HasCenterPoint {
  def centerPoint: Point
}

case class Triangle(a: Point, b: Point, c: Point) extends HasCenterPoint {
  override def centerPoint: Point = Triangle.centerPoint(this)
}

case class Quadrangle(a: Point, b: Point, c: Point, d: Point) extends HasCenterPoint {
  override def centerPoint: Point = {
    val seq: Seq[Point] = Seq(a, b, c, d)
    val pFinal = seq.reduce {
      (p1, p2) => p1 + p2
    }
    Point(pFinal.x / seq.size, pFinal.y / seq.size)
  }
}

object Triangle {
  //def centerPoint(t: Triangle): Point = Point((t.a.x + t.b.x + t.c.x) / 3, (t.a.y + t.b.y + t.c.y) / 3)

  val centerPoint: Triangle => Point = (t: Triangle) => Point((t.a.x + t.b.x + t.c.x) / 3, (t.a.y + t.b.y + t.c.y) / 3)
}

def distanceBetweenCenterPoints(a: HasCenterPoint, b: HasCenterPoint): Double =
  Math.sqrt(Math.pow(a.centerPoint.x - b.centerPoint.x, 2) + Math.pow(a.centerPoint.y - b.centerPoint.y, 2))


@main def main(): Unit = {
  val p = Point(1, 2)
  val q = p.copy(x = 3)
  val r = p add q

  val Point(rx, ry) = r

  val `Triangle` = Triangle(Point(10,10), Point(11,8), Point(7,11))
  val`Quadrangle` = Quadrangle(Point(10,10), Point(11,8), Point(7,11), Point(12,12))

  val distance = distanceBetweenCenterPoints(`Triangle`,`Quadrangle`)
  println(distance)

  val center = `Triangle`.centerPoint
  println(center)

  /*
  `Triangle` match {
    case Triangle(Point(ax, ay), Point(bx, by), Point(cx, cy)) if ax == bx =>
      println(s"Triangle with vertices: ($ax, $ay), ($bx, $by), ($cx, $cy)")
  }
  */
/*  r match {
    case Point(1,2) => println("Matched `Point` with specific coordinates")
    case r if r == p => println("Matched `Point` with same instance")
    case Point(rx, 4) => println(s"Matched `Point`: ($rx, $ry)")
    case _ => println("No match found")
  }*/

/*  println(s"$rx, $ry")
  println(s"p = $p, q = $q, r = $r")
  println(p == q)*/
}
```

