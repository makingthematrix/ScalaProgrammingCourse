# Akka, Pekko and Play Framework

### Prerequisites:
* Knowledge of Futures and Streams

### Lecture Plan:

| Topic | Details |
|-------|---------|
| Actor Concept | |
| Implementing an Actor using Future and Event Streams | Create an event generator producing new events at time intervals t, Special case: empty event generator (EventStream[Unit]), Add event stream and subscribe to it - subscription adds events to queue, New empty event triggers function that consumes events from queue and performs actions |
| Brief Overview of Akka and Pekko | |
| Example Usage of Akka/Pekko | Distributed computations, akka-http interface with curl connection to send CSV file with data, Backend parses data, distributes to multiple actors, waits for results and sends back new CSV file, Reference to Protein Folding on PS3 |
| Production Use Cases of Akka and Pekko | Including Play Framework (to be discussed in next class or now) |
| Introduction to Play Framework | History, production use cases, Example application component breakdown: Request handling, Database connection (Slick, Anorm + mention more advanced alternatives), Static HTML page generation, Mention other web frameworks (http4s, tapir, etc.) |

### Notes:
* Review this presentation: [Flavors of Scala](https://github.com/polyvariant/flavors-of-scala)

Key points about the lecture:
1. The actor model implementation demonstrates how to build concurrent systems using basic building blocks
2. Practical examples show real-world applications of Akka/Pekko
3. The Play Framework section provides a comprehensive view of web application development in Scala
4. The lecture connects theoretical concepts with practical implementations
5. References to additional resources help students explore topics further