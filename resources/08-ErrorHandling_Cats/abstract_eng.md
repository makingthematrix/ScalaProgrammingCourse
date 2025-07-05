# Monads

### Prerequisites:
* For the Option/Either topic, knowledge of total vs partial functions is required
* For the IO monad topic, knowledge of by-name parameters is required

### Lecture Plan:
| Topic | Details |
|-------|---------|
| Monad Concept | Constructor (unit), Value, Bind method (flatMap) |
| Option | Error handling applications, Practical example |
| Either | Error handling applications, Practical example |
| Try | Error handling applications, Practical example |
| for/yield Syntax Explanation | Comparison with for/yield usage for collections, Refactoring previous examples (especially Option) using for/yield |
| Monad Laws | Left identity, Right identity, Associativity, How these laws allow the compiler to rewrite for/yield to flatMap |
| IO Monad | Introduction to Cats System 3, Practical example of reading and writing to a file (Imperative version, Refactoring to FP version) |

### Notes:
* "IO is like () => Future[A] wrapped in a box with unsafeRunSync etc." - Leszek Biały