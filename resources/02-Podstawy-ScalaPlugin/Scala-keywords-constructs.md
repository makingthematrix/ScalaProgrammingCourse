

| Keyword   | Ops                                                          |
| --------- | ------------------------------------------------------------ |
| abstract  | Oznacza klasę, metodę, lub pole jako abstrakcyjne, czyli wymagające implementacji w podklasie. |
| as        | Używane do przypisywania typów lub dopasowywania wzorców (np., case x as y). |
| case      | Definiuje case class, pole w enumie, lub wzorzec w pattern matching. |
| catch     | Obsługuje wyjątki w blokach try-catch.                       |
| class     | Definiuje klasę.                                             |
| def       | Definiuje metodę.                                            |
| do        | Używane w pętli do-while.                                    |
| else      | Określa alternatywną gałąź w wyrażeniach if-else.            |
| enum      | Definiuje enum.                                              |
| export    | Eksportuje elementy z innego obiektu lub pakietu.            |
| extends   | Wskazuje dziedziczenie z klasy lub traitu.                   |
| false     | Literał dla fałszu.                                          |
| final     | Zapobiega zastępowaniu lub dalszemu dziedziczeniu.           |
| finally   | Definiuje blok kodu, który zawsze wykonuje się po try-catch. |
| for       | Wprowadza pętlę for lub for-comprehension.                   |
| given     | Definiuje daną instancję (abstrakcję kontekstową).           |
| if        | Wprowadza wyrażenie warunkowe.                               |
| implicit  | Oznacza wartość, klasę lub metodę jako implicit (deprecated w Scala 3 na rzecz given/using). |
| import    | Importuje elementy z pakietu lub obiektu.                    |
| lazy      | Oznacza wartość jako obliczaną "leniwie".                    |
| match     | Wprowadza wyrażenie dopasowania wzorca (pattern matching).   |
| new       | Tworzy nową instancję klasy.                                 |
| null      | Reprezentuje referencję null.                                |
| object    | Definiuje obiekt singleton.                                  |
| opaque    | Definiuje "zamknięty" (lub dosł. "nieprzezroczysty") alias dla typu. |
| override  | Wskazuje, że metoda lub pole nadpisuje tę z klasy nadrzędnej. |
| package   | Definiuje pakiet.                                            |
| private   | Ogranicza dostęp do metody, pola, klasy lub obiektu.         |
| protected | Ogranicza dostęp do metody, pola, lub klasy tylko do podklas. |
| return    | Zwraca wartość z metody (opcjonalny).                        |
| sealed    | Ogranicza dziedziczenie do tego samego pliku (używane z traitami i klasami). |
| then      | Używane w wyrażeniach if (np., if x then y).                 |
| throw     | Rzuca wyjątek.                                               |
| trait     | Definiuje trait (interfejs z opcjonalną implementacją).      |
| true      | Literał dla prawdy.                                          |
| try       | Wprowadza blok kodu, który może rzucić wyjątkiem.            |
| type      | Definiuje alias typu lub typ abstrakcyjny.                   |
| val       | Definiuje niezmienną wartość.                                |
| var       | Definiuje zmienną zmienną.                                   |
| while     | Wprowadza pętlę while.                                       |
| with      | Łączy typy w aliasach i definicjach dziedziczenia.           |
| yield     | Zwraca wartość z for-comprehension.                          |
| @         | Wprowadza adnotację.                                         |
| =         | Przypisuje wartość lub definiuje typ zwracany przez metodę.  |
| =>        | Oddziela parametry funkcji od ciała lub definiuje typ funkcji. |
| <-        | Używane w for-comprehensions do wiązania zmiennych.          |
| :         | Specyfikuje przypisanie typu lub context bound.              |
| <:        | Górna granica typu (np., A <: B oznacza, że A jest podtypem B). |
| >:        | Dolna granica typu (np., A >: B oznacza, że A jest nadtypem B). |
| ?=>       | Contextual bound (np., A ?=> B oznacza, że A jest wymagany implicit). |
| =         | Przypisuje wartość lub definiuje typ zwracany przez metodę.  |
| _         | Wildcard (ignoruje wartość lub reprezentuje anonimowy parametr). |

---

| Scala                   | Java                            | Opis                                                    | Różnice                                                      |
| ----------------------- | ------------------------------- |---------------------------------------------------------| ------------------------------------------------------------ |
| `var foo`               | `int foo = 10;`                 | Zmienna.                                                | Scala zniechęca do zmienności; Java domyślnie używa zmienności. |
| `val foo`               | `final int foo = 10;`           | Niezmienna wartość.                                     | Scala zachęca do niezmienności domyślnie; Java wymaga `final`. |
| `protected val/var foo` | `protected final int foo = 10;` | Ogranicza dostęp do klasy i jej podklas.                | Scala’s `protected` może być ograniczony do pakietów (możliwe jest napisanie `protected[foo]`); Java’s jest ściśle na poziomie klasy. |
| `private val/var foo`   | `private final int foo = 10;`   | Ogranicza dostęp do zawierającej klasy/obiektu.         | Scala’s `private` może być ograniczony do pakietów (możliwe jest napisanie `private[foo]`); Java’s jest ściśle na poziomie klasy. |
| `final val/var foo`     | `public final int foo = 10;`    | Zapobiega zastępowaniu w podklasach.                    | Scala używa `final` aby zapobiec zastępowaniu w traitach; Java używa go również dla niezmiennych pól i metod. |
| `abstract val/var foo`  | `abstract final int getFoo();`  | Abstrakcyjna (tj. niezaimplementowana) wartość/zmienna. | Brak                                                         |

| Scala                   | Java                                                         | Opis                                                         | Różnice                                                      |
| ----------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `lazy val foo`          | Prywatna zmienna inicjalizowana do null + getter, który przy pierwszym użyciu naprawdę ją inicjalizuje. | Wartość jest inicjowana tylko przy pierwszym dostępie, a następnie buforowana. | Wymaga ręcznej implementacji.                                |
| `class Foo`             | `public class Foo { Foo(...) {...}}`                         | Definiuje klasę.                                             | Główny konstruktor w Scali jest częścią sygnatury klasy; Java używa oddzielnych konstruktorów. Klasy w Scali, traity itp. są domyślnie publiczne; w Javie są ograniczone do pakietu i wymagają słowa kluczowego public. |
| `abstract class Foo`    | `abstract class Foo {}`                                      | Definiuje klasę abstrakcyjną.                                | Brak                                                         |
| `case class Foo`        | `record Foo`                                                 | Niezmienna klasa z automatycznie generowanymi metodami dla równoważności, hashowania, toString i konstrukcji. | Rekordy zostały dodane w Java 14                             |
| `final class Foo`       | `final class Foo {}`                                         | Zapobiega dziedziczeniu.                                     | Brak                                                         |
| `object Foo`            | Klasa z prywatnym konstruktorem + static instance, albo enum z jedną wartością. | Definiuje obiekt singleton.                                  | Obiekt w Scali jest wbudowany; Java wymaga enum lub ręcznej implementacji. |
| `case object Foo`       | `public enum Foo { INSTANCE }`                               | Singleton z cechami case class.                              | case object w Scali jest wbudowany; Java wymaga enum lub ręcznej implementacji. |
| `trait Foo`             | `interface Foo`                                              | Definiuje konstrukcję podobną do interfejsu, która może zawierać metody i pola. | W przeszłości były różnice. W nowych wersjach Scala/Java, traity i interfejsy są praktycznie takie same. |
| `sealed trait Foo`      | `sealed interface Foo permits Bar, Baz` (Java 15+)           | Ogranicza dziedziczenie do ustalonego zbioru podklas.        | sealed traits w Scali są bardziej elastyczne i integrują się z dopasowywaniem wzorców. Z kolei sealed interface w Javie umożliwia dziedziczenie typom spoza tego samego pliku. |
| `enum Foo`              | `enum Foo`                                                   | Definiuje wyliczenie.                                        | Enumy w Scali są bardziej elastyczne (mogą zawierać pola i metody). Ale w tym przypadku to Scala dodała je później (Scala 3.0). |
| `class Foo extends Bar` | `class Foo extends Bar {}`                                   | Dziedziczy z klasy nadrzędnej.                               | Brak                                                         |

| Scala                                        | Java                                                         | Opis                                                         | Różnice                                                      |
| -------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| `def foo(n: Int, str: String): Foo`          | `public Foo foo(int n, String str) { ... }`                  | Definiuje metodę z parametrami i typem zwracanym.            | Metody w Scali mogą być definiowane poza klasami; składnia parametrów różni się ("nazwa: Typ" vs "Typ nazwa"). |
| `abstract def foo(n: Int, str: String): Foo` | `public abstract Foo foo(int n, String str);` (in abstract class or interface) | Definiuje metodę abstrakcyjną, która musi być zaimplementowana przez podklasy. | Brak                                                         |
| `override def foo(n: Int, str: String): Foo` | `@Override public Foo foo(int n, String str) { ... }`        | Nadpisuje metodę z klasy nadrzędnej lub traitu.              | Scala wymaga słowa kluczowego override; Java używa opcjonalnej adnotacji @Override. |
| `final def foo(n: Int, str: String): Foo`    | `public final Foo foo(int n, String str) { ... }`            | Definiuje metodę, która nie może być nadpisywana w podklasach. | Obydwa języki egzekwują to podobnie, ale final w Scali stosuje się do większej liczby konstrukcji (vals/vars). W Javie można jedynie 'ukryć' zmienną klasy nadrzędnej. |
| `inline def foo(n: Int, str: String): Foo`   | No direct equivalent (JVM may inline automatically)          | Sugeruje kompilatorowi, aby wstawić wywołanie metody w miejscu jej wywołania. | Scala ma jawną obsługę inline z gwarancjami czasu kompilacji; Java polega na optymalizacjach JIT. |
| `type Foo`                                   | No direct equivalent (use full type name everywhere)         | Tworzy alias dla istniejącego typu.                          | Java nie ma aliasów.                                         |
| `opaque type Foo`                            | No direct equivalent (use interfaces/abstract classes)       | Tworzy "zamknięty" (dosł. "nieprzezroczysty") type alias.    | opaque types w Scali zapewniają abstrakcję bez narzutu czasu wykonania; Java wymaga bardziej rozwlekłych konstrukcji. |

| Scala                                         | Java                                                         | Opis                                                        | Różnice                                                      |
| --------------------------------------------- | ------------------------------------------------------------ | ----------------------------------------------------------- | ------------------------------------------------------------ |
| if-else                                       | if-else                                                      | Warunkowe wykonanie z klauzulą else.                        | W Scali jest to wyrażenie zwracające wartość (expression); w Javie jest to instrukcja (statement). |
| if-then-else-end (Scala 3)                    | if-else                                                      | Alternatywna składnia dla if-else                           | Jak wyżej                                                    |
| for (foo <- foos) {... } / for foo <- foos do | for (foo in foos) {...}                                      | Iteracja po zakresie lub kolekcji.                          | Pętla for w Scali jest bardziej ekspresyjna i może być używana jako wyrażenie z yield. |
| for-yield                                     | for loop / Java Streams                                      | Tworzy nową kolekcję poprzez transformację elementów.       | Scala jest bardziej zwięzła i funkcjonalna; Java wymaga manualnej implementacji lub użycia Streamów. |
| try-catch-finally                             | try-catch-finally                                            | Obsługa wyjątków.                                           | Scala używa dopasowania wzorców w catch                      |
| match-case                                    | switch-case with pattern matching (Java 17+)                 | Dopasowanie wzorców.                                        | Scala's jest znacznie bardziej potężna z destrukturyzacją, dopasowywaniem typów itp. |
| while-do                                      | while loop                                                   | Pętla, dopóki warunek jest prawdziwy.                       | Bardzo podobne                                               |
| new Foo(...)                                  | new Foo(...)                                                 | Tworzenie instancji z konstruktorem.                        | W Scali, new można często pominąć.                           |
| Foo.apply(...)                                | Static factory method Foo.apply(...) or constructor new Foo(...) | Metoda apply obiektu towarzyszącego do tworzenia instancji. | Konwencja metody apply w Scali umożliwia zwięzłą składnię Foo(...). |



| Scala                                | Java                                                       | Opis                                                         | Różnice                                                      |
| ------------------------------------ |------------------------------------------------------------| ------------------------------------------------------------ | ------------------------------------------------------------ |
| `given Foo`                          | Brak (podobny efekt można uzyskać za pomocą dep injection) | Definiuje instancję Foo, która może być niejawnie przekazywana do funkcji. | Scala obsługuje niejawne przekazywanie instancji; Java wymaga jawnego przekazywania. |
| `using foo: Foo`                     | Brak                                                       | Określa, że funkcja wymaga niejawnej instancji Foo.          | Scala obsługuje niejawne przekazywanie instancji; Java wymaga jawnego przekazywania. |
| `def foo(n: Int)(using str: String)` | Brak (podobny efekt można uzyskać za pomocą dep injection) | Definiuje metodę z jawnym parametrem i niejawnym parametrem typu String. | Scala pozwala oddzielić jawne i niejawne parametry; Java wymaga jawnego przekazywania lub frameworków DI. |
| `def map(f: Foo => Bar): Baz`        | Baz map(Function<Foo, Bar> f)                              | Pozwala na przekazanie funkcji jako parametru                | Składnia Scali dla funkcji wyższego rzędu jest bardziej zwięzła; Java wymaga interfejsów funkcyjnych. |
| `class Foo[A <: B](a: A)`            | `class Foo<A extends B> { Foo(A a) }`                      | Definiuje klasę generyczną Foo z parametrem typu A ograniczonym przez B. | Oba języki obsługują ograniczenia typów generycznych i parametry konstruktora podobnie, ale składnia Scali jest bardziej zwięzła. |