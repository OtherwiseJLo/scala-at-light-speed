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
  class Dog(name: String) extends Animal
  // val aDog = new Dog("Lassie")
  // aDog.name will fail, name does not persist

  // need to add VAL to promote name to class field/member
  class Cat(val name: String) extends Animal
  val aCat = new Cat("Garfield")
  println(aCat.name)

  // subtype polymorphism


}
