# Futures, async/await, Event Streams

### Prerequisites:
* Knowledge of for/yield notation

### Lecture Plan:

| Topic | Details |
|-------|---------|
| Brief introduction to JVM threads | |
| Future/Promise concept | How to implement Future manually (slides or live coding), How to extend implementation to cancellable Future |
| Alternatives to Future | async/await concept, Digression on suspend in Kotlin, Discussion of direct style in Scala 3, Overview of Ox library |
| Introduction to Observer pattern | Event stream lifecycle: subscription, publication, unsubscription, Digression on lifecycle diagram (provide other usage examples), Classic observer pattern with single producer vs event stream with multiple producers, Usage examples of event streams: databases, HTTP requests, desktop applications, mobile applications... (what else?) |
| Event stream implementation | Brief overview of Signals3 library, Usage example: Wire |

### Notes:
What are the alternatives and analogs for Future and event streams in Java?

```scala
def doStuffAsynchronously(arg: Arg, callMeLater: (retVal: RetVal) => Unit): Unit = // callMeLater is a callback
// To understand this, you need to understand higher-order functions - that you can take something that seems like a block of code to a beginner and move it to the realm of values (which beginners typically think of as numbers, strings, hash maps or lists), pass it as a value, and then someone will eventually call it with some argument of type RetVal

def doStuffAsynchronously(arg: Arg): js.Promise[RetVal] = // Scala.js API because our Future is even more complex
// To understand this, you need to understand HOFs plus understand that someone can build a chain of such functions as values packed in boxes with other HOFs for composing boxes - this is a non-trivial leap. I remember trying to understand what a Promise in JS was after a year of writing Node.js with callbacks, and it wasn't obvious until I took Q, put console.logs in it, and saw what happens at runtime

def doStuffAsynchronously(arg: Arg)(using ExecutionContext): Future[RetVal] = // suddenly some context?
// To understand this, you need everything above plus the fact that Future runs on different threads and that when you do map you need EC, but when you do Future.successful you don't, and why, plus a lot of interesting pitfalls where you use something mutable in a context where futures are flying around and suddenly things get very real

def doStuffAsynchronously(arg: Arg): IO[RetVal] = // seemingly simplest BUT
// To understand what's happening here, you need to understand EVERYTHING that came before PLUS understand suspension - which expressions are referentially transparent and which are not

// Bonus: why Ox and loom:
def doStuff(arg: Arg): RetVal = ???
```

Key points about the code examples:
1. They demonstrate an evolutionary path from callbacks to direct style programming
2. Each step introduces new concepts and complexity
3. The comments explain the cognitive leaps required to understand each approach
4. The progression shows increasing abstraction and control over asynchronous operations
5. The final example suggests a return to simpler-looking synchronous code through advanced techniques