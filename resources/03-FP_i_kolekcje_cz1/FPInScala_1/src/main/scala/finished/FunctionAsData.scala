package org.fpinscala.finished

// 1

object FunctionAsData {
  class User(val name: String, val email: String) {
    override def toString: String = s"$name:$email"
  }

  // Let's create a sequence of three users
  val users: Seq[User] = Seq(
    User("Joe", "joe@gmail.com"),
    User("Felix", "felix@proton.me"),
    User("Garfield", "garfield@catmail.org")
  )

  // A function which checks if the user's email is valid
  def isEmailValid(user: User): Boolean = user.email.contains('@')

  // Pass the appropriate function into `filter` to create a sequence of users with valid emails.
  private val usersWithValidEmails = users.filter(isEmailValid)

  // The whole "User => Boolean" is the type of the function
  private val isEmailValidFun: User => Boolean =
    user => user.email.contains('@')

  // We can use it instead of the method version in `filter`
  val usersWithValidEmailsFun: Seq[User] = users.filter(isEmailValidFun)

  // or we can use an anonymous function - also called lambdas
  val usersWithValidEmailsAnon: Seq[User] = users.filter(user => user.email.contains('@'))

  // Lambdas, just as all functions, can take a value from its scope
  private val alwaysValidName = "Maciek"
  val usersWithValidEmailsOrMaciek: Seq[User] =
    users.filter(
      user => user.name == alwaysValidName || isEmailValid(user)
    )

/*  @main def main(): Unit = {
    println(usersWithValidEmails)
  }*/
}
