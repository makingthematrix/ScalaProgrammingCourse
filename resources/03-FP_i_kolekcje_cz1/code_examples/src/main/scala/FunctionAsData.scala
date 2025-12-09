package org.fpinscala

// 1
object FunctionAsData {
  class User(val name: String, val email: String)

  // Let's create a sequence of three users
  val users = Seq(
    User("Joe", "joe@gmail.com"),
    User("Felix", "felix@proton.me"),
    User("Garfield", "garfield@@catmail.org")
  )

  // A function which checks if the user's email is valid
  def isEmailValid(user: User): Boolean =
    user.email.count(c => c == '@') == 1

  // Pass the appropriate function into `filter` to create a sequence of users with valid emails.
  val validUsers = users.filter(isEmailValid)

  // The whole "User => Boolean" is the type of the function
  val isEmailValidFun: User => Boolean = {
    user =>
      user.email.count(c => c == '@') == 1
  }
      // We can use it instead of the method version in `filter`

  users.filter(isEmailValidFun)

      // or we can use an anonymous function - also called lambdas
  users.filter(user => user.email.count(c => c == '@') == 1)

  // Lambdas, just as all functions, can take a value from its scope
  private val alwaysValidName = "Garfield"
  users.filter(user => user.name == alwaysValidName || user.email.count(c => c == '@') == 1)
}
