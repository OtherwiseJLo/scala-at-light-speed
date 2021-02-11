package com.rockthejvm

object ObjectOrientation extends App {

  // class and an instance
  // define fields and functions in code block
  class Animal {
    // class fields
    // also called members
    val age: Int = 0

    // class methods
    def eat(): Unit = println("I'm eating")
  }
  val anAnimal = new Animal


  // inheritance
  // has all methods and members from animals
  // class definition WITH arguments will also specify constructor
  // constructor arguments are NOT fields
  // constructor arguments are ephemeral an scope is inside class code block
  // class Dog(name: String) extends Animal
  // val aDog = new Dog("Lassie")
  // aDog.name will fail, name does not persist
  class Pet extends Animal {
    // class member
    val knowsTricks = false

    // methods
    def doTrick(): Unit = if (knowsTricks) println("Nice trick!") else println("No tricks known")
  }

  class Dog(val name: String) extends Pet
  class Cat(val name: String) extends Pet

  val aCat = new Cat("Garfield")
  println(aCat.name)

  // Subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  // eat() called from Dog class, NOT the animal class
  // the most derived method will be called at RUNTIME
  // at compile time, the method will be called from ANIMAL
  aDeclaredAnimal.eat()

  abstract class WalkingAnimal {
    val hasLegs = true
    def walk(): Unit
  }
}
