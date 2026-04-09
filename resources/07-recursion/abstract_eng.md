# Recursion

### Prerequisites:
| Requirement | Description |
|-------------|-------------|
| For trampoline explanation | Knowledge of by-name parameters |
| For binary tree implementation example | Knowledge of enums vs sealed traits |
| For for/yield version of trampolines | Knowledge of for/yield (from monads lecture) |

### Lecture Plan:

| Topic | Details |
|-------|---------|
| Examples of data structures and applications where recursion is useful | List (O(1) write data structures, journal, memory allocation), Binary tree (O(log n) search data structures, file systems, expert systems), Graph (social networks, computer games, physical and geographical modeling) |
| How recursion works | What is a stack, How stack pushing works, When Stack Overflow Exception occurs |
| Examples | Factorial, Fibonacci sequence |
| How debugger helps understand recursive functions | |
| Tail recursion | Theory, Same two examples in new implementation |
| Trampolines | Theory, Same two examples in new implementation, for/yield version |
| Lazy List | Implementation overview, Fibonacci sequence example using lazy list, Comparison and optimization discussion relative to other methods |
| Binary tree implementation using enums | Hardcoded version for Int type, Recursive print function, Refactoring from Int to generic type, Recursive add function, create function written using foldLeft |

### Notes:
The lecture progresses from basic recursion concepts to advanced techniques like trampolining and lazy evaluation. Practical examples demonstrate both the power and potential pitfalls of recursive approaches. The binary tree implementation shows how to apply these concepts to build complex data structures.