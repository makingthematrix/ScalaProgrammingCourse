package org.fpinscala.finished

import org.fpinscala.{UserData, UserId}
import scala.util.boundary
import scala.util.boundary.break

object EarlyReturns {
  import UserData.database

  /**
   * This is our "complex conversion" method.
   * We assume that it is costly to retrieve user data, so we want to avoid
   * calling it unless it's absolutely necessary.
   *
   * This version of the method assumes that the user data always exists for a given user id.
   */
  def complexConversion(userId: UserId): UserData =
    database.find(_.id == userId).get

  /**
   * Similar to `complexConversion`, the validation of user data is costly
   * and we shouldn't do it too often.
   */
  def complexValidation(user: UserData): Boolean =
    !user.email.contains(' ') && user.email.count(_ == '@') == 1
  
  private val userIds: Seq[UserId] = 1 to 11

/*  @main def main(): Unit = {
    val user = Imperative.findFirstValidUser(userIds)
    println(user)
  }*/

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
        case userId if complexValidation(complexConversion(userId)) => complexConversion(userId)
      }
  }

  /**
   * The custom `unapply` method runs conversion and validation and only returns valid user data.
   */
  object CustomUnapply {
    object ValidUser {
      def unapply(userId: UserId): Option[UserData] = {
        val userData = complexConversion(userId)
        Some(userData).find(complexValidation)
      }
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
      }
  }

  /**
   * This function takes into account that some IDs can be left out from the database
   */
  def safeComplexConversion(userId: UserId): Option[UserData] = database.find(_.id == userId)

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

    None
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

  object MoreThanOneValidation {
    object ValidUser {
      def unapply(userId: UserId): Option[UserData] =
        safeComplexConversion(userId).find(complexValidation)
    }

    object ValidUserInADifferentWay {
      def otherValidation(userData: UserData): Boolean = false
      def unapply(userId: UserId): Option[UserData] = safeComplexConversion(userId).find(otherValidation)
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
        case ValidUserInADifferentWay(user) => user
      }
  }
  
  object Deconstruct {
    trait Deconstruct[From, To] {
      def convert(from: From): Option[To]
      def validate(to: To): Boolean
      def unapply(from: From): Option[To] = convert(from).find(validate)
    }

    object ValidUser extends Deconstruct[UserId, UserData] {
      def convert(userId: UserId): Option[UserData] = safeComplexConversion(userId)
      def validate(user: UserData): Boolean = complexValidation(user)
    }

    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds.collectFirst {
        case ValidUser(user) => user
      }
  }
  
  object LazyCollection {
    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      userIds
        .iterator
        .map(safeComplexConversion)
        .find(_.exists(complexValidation))
        .flatten
  }

  import scala.util.boundary
  import scala.util.boundary.break

  object BreakingBoundary {
    def findFirstValidUser(userIds: Seq[UserId]): Option[UserData] =
      boundary {
        for (userId <- userIds)
          safeComplexConversion(userId).foreach { userData =>
            if (complexValidation(userData)) break(Some(userData))
          }
        None
      }
  }
}
