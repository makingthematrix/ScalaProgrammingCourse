package org.fpinscala.finished

// 3

object CollectionsFlatMap {
  // Let's take that map for Joe and use it for every user
  case class User(name: String, email: String)
  case class Conversation(title: String, participants: Seq[User])

  val joe: User = User("Joe", "joe@gmail.com")
  val felix: User = User("Felix", "felix@proton.me")
  val garfield: User = User("Garfield", "garfield@catmail.org")
  val users: Seq[User] = Seq(joe, garfield, felix)

  val convos: Seq[Conversation] =
    users.flatMap { user =>
      users
        .filterNot(_.name == user.name)
        .map(user2 => Conversation(s"${user.name} and ${user2.name}", Seq(user, user2)))
    }
/*
  @main def main(): Unit = {
    println(s"Number of convos: ${convos.size}")
    convos.foreach(c => println(c.title))
  }*/
}
