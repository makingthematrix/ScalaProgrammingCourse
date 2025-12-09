package org.fpinscala

// 8

object  EarlyReturns {
  import UserData.database

  // complex conversion
  def complexConversion(userId: UserId): UserData =
    database.find(_.id == userId).get

  // complex validation
  def complexValidation(user: UserData): Boolean = user.email.count(_ == '@') == 1 &&
    !user.email.contains(' ') &&
    user.email.split('@').forall(
      _.forall(c => c.isLetter || c.isDigit || c == '.' || c == '-' || c == '_')
    )
  // userIds from 1 to 11
  
  private val userIds: Seq[UserId] = 1 to 11


  /**
   * Imperative approach that uses unidiomatic `return`.
   */
  object Imperative {
     def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] = {
       for (userId <- userIds) {
         val userData = complexConversion(userId)
         if (complexValidation(userData)) return Some(userData)
       }
       None
     }
  }

  /**
   * Naive functional approach: calls `complexConversion` twice on the selected ID.
   */
  object Naive {
     def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
       userIds
         .find(userId => complexValidation(complexConversion(userId)))
         .map(complexConversion)
  }

  /**
   * A more concise implementation, which uses `collectFirst`.
   */
  object CollectFirst {
     def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
       userIds.collectFirst {
         case userId if complexValidation(complexConversion(userId)) =>
           complexConversion(userId)
       }
  }

  /**
   * The custom `unapply` method runs conversion and validation and only returns valid user data.
   */
  object CustomUnapply {
    object ValidUser {
      def unapply(userId: UserId): Option[UserData] = {
        val userData = complexConversion(userId)
        if (complexValidation(userData)) Some(userData) else None
      }
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
      }
  }

  // safeComplexConversion
  def safeComplexConversion(userId: UserId): Option[UserData] =
    database.find(_.id == userId)

  /**
   * Partiality of `safeComplexConversion` trickles into the search function.
   */
  object SafeImperative {
     def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] = {
       for (userId <- userIds) {
         safeComplexConversion(userId) match {
           case Some(user) if complexValidation(user) => return Some(user)
           case _ =>
         }
       }
       None
     }
  }

  /**
   * This custom `unapply` method performs the safe conversion and then validation.
   */
  object SafeCollectFirst {
    object ValidUser {
      def unapply(userId: UserId): Option[UserData] =
        safeComplexConversion(userId).find(complexValidation)
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
      }
  }

  // what if our user can be valid in more than one way?
  object MoreThanOneValidation {
    object ValidUser {
      def unapply(userId: UserId): Option[UserData] = ???
    }

    object ValidUserInADifferentWay {
      def otherValidation(userData: UserData): Boolean = ???
      def unapply(userId: UserId): Option[UserData] =
        safeComplexConversion(userId).find(otherValidation)
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
        case ValidUserInADifferentWay(user) => user
      }
  }

  // Can we abstract away the common parts?
  object Deconstruct {
    trait Deconstruct[From, To] {
      def convert(from: From): Option[To]
      def validate(to: To): Boolean
      def unapply(from: From): Option[To] = convert(from).find(validate)
    }

    object ValidUserFoo extends Deconstruct[UserId, UserData] {
      override def convert(userId: UserId): Option[UserData] = database.find(_.id == userId)
      override def validate(user: UserData): Boolean =
        user.email.count(_ == '@') == 1 &&
          !user.email.contains(' ') &&
          user.email.split('@').forall(
            _.forall(c => c.isLetter || c.isDigit || c == '.' || c == '-' || c == '_')
          )
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUserFoo(user) => user
      }
  }

  // Let's do the same thing but with a lazy collection
  object LazyCollection {
    //def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] = ???
  }

  // last but not least: breaking/boundary
  object BreakingBoundary {
    import scala.util.boundary
    import scala.util.boundary.break
    //def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] = ???
  }
}
