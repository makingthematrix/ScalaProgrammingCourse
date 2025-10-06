package org.fpinscala.finished

// 2

object Collections {
  case class User(name: String, email: String)

  val joe = User("Joe", "joe@gmail.com")
  val felix = User("Felix", "felix@proton.me")
  val garfield = User("Garfield", "garfield@catmail.org")
  
  // Scala collections: Seq, Set, Map
  val usersSeq = Seq(joe, garfield, felix)
  val sortedUsers = usersSeq.sortWith( (u1, u2) => u1.name < u2.name )

  // This won't work because users don't have an implicit ordering
  //val sortedUsers2 = usersSeq.sorted

  // But this will
  val sortedUsers3 = usersSeq.sortBy(_.name)

  // maps
  val usersMap = Map(
    "Felix" -> felix,
    "Garfield" -> garfield,
    "Joe" -> joe
  )
  
  // a map can be thought of as a set of tuples 
  val usersMap2 = usersSeq.map(u => u.name -> u).toMap

  // tuples
  val userTuples: Seq[(String, User)] = usersMap.toSeq

  // filter - we already discussed it

  // find
  val protonEmail: Option[User] = usersSeq.find { user => user.email.endsWith("@proton.me") }
  val felixTheUser: Option[User] = usersSeq.find { joe => joe.name == "Felix" } // also: _.name == "Felix"

  // foreach
  usersSeq.foreach(user => println(s"This is ${user.name}"))

  // map
  // Let's create a conversation class
  case class Conversation(title: String, participants: Seq[User])
  // And let's create conversations of Joe and every other user
  val joesConvos: Seq[Conversation] =
    usersSeq
      .filterNot(_.name == "Joe")
      .map(user => Conversation(s"Joe and ${user.name}", Seq(joe, user)))
}
