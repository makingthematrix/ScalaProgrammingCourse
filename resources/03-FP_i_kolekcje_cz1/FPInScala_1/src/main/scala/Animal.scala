package org.fpinscala

import Color.*

trait Animal {
  val name: String
  val color: Color
}

case class Cat(name: String, color: Color) extends Animal
case class Dog(name: String, color: Color) extends Animal

case class Bird(name: String, color: Color, flySpeed: Int, wingspan: Int, beakLength: Int) extends Animal

object Animal {
  // We create three instances of cats
  val felix = Cat("Felix", Black)
  val garfield = Cat("Garfield", Ginger)
  val shadow = Cat("Shadow", Black)

  // and two instances of dogs
  val fido = Dog("Fido", Black)
  val snowy = Dog("Snowy", White)

  // We put all cats and dogs in a sequence of type Seq[Animal]
  val animals: Seq[Animal] = Seq(felix, garfield, shadow, fido, snowy)
  val blackCats = animals.collect {
    case Cat(name, Black) => name
  }

}
