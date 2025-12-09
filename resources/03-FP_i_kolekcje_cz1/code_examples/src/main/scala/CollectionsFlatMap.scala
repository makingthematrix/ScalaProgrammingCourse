package org.fpinscala

// 3

object CollectionsFlatMap {
  // Let's take that map for Joe and use it for every user
  case class User(name: String, email: String)
  case class Conversation(title: String, participants: List[User])

  // Turn 3 users to 6 convos
  val joe = User("Joe", "joe@gmail.com")
  val felix = User("Felix", "felix@proton.me")
  val garfield = User("Garfield", "garfield@catmail.org")
  val users = Seq(joe, felix, garfield)

  val convos =
    users.flatMap(user =>
      users
        .filterNot(_.name == user.name)
        .map(user2 =>
        Conversation(s"${user.name} and ${user2.name}", List(user, user2)))
    )
}
