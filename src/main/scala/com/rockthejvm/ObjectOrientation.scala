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

  // Not all fields or methods need implementations
  // By default, all fields are public
  // NO PUBLIC MODIFIER
  // Can restrict with private or protected
  // Private: Only this class has access to this
  // Protected: Only this class and descendents have access to this
  abstract class WalkingAnimal {
    private val hasLegs = true // optionally defined/implemented
    protected def walk(): Unit // does not NEED an implementation
    // if a class extends WalkingAnimal, that class will need to OVERRIDE walk
  }

  // interface is the ULTIMATE abstract type
  // EVERYTHING can be unimplemented
  // traits denote characateristics of objects in concrete objects
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    // a quick means to define new operators
    def ?!(thought: String): Unit // this is a valid name!!!
  }

  // single and multi trait inheritance
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal")
    override def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aDog = new Animal

  val aCroc = new Crocodile
  aCroc.eat(aDog) // valid, nothing exciting
  aCroc eat aDog // called INFIX NOTATION, only for methods with ONE argument: object method argument
  aCroc ?! "How tasty!"
  aCroc.?!("How spicy!")

  // in Scala, operators are actually methods!
  val basicMath = 1 + 2
  val moreBasicMath = 1.+(2)

  // anonymous classes
  /* Under the hood:
  * Me: Hey compiler, create a new class for me
  * Compiler: class Carnivor_Anonymous_(random num, mem addr?) extend Carnivor{
  *   override def eat(animal: Animal): Unit = println("I am a dino, I can eat it all!")
  * }
  * Me: Nice! Instantiate that class for me
  * Compiler: val dinosaur = new Carnivore_Anonymous_(random mem address)
  *
  */
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dino, I can eat it all!")
  }

  // singleton objects
  // the ONLY instance of this type
  object MySingleton {
    val mySpecialValue = 42
    def mySpecialMethod(): Int = 54
    def apply(x: Int): Int = x + 1 // special method in all classes/objects
  }

  MySingleton.mySpecialMethod()
  MySingleton.apply(43) // typical apply implementation
  MySingleton(43) // equivalent to above

  // this singleton is a companion object because object shares name with
  // class/trait/abstract class
  // companions can access each others' private fields and methods
  // companion objects are used to access things that do not depend on class
  // USE COMPANION OBJECTS TO DEFINE STATIC FIELDS AND CLASSES
  object Animal {
    val canLiveIndefinitely = false
  }

  // call a "static" field
  val animalsCanLiveForever = Animal.canLiveIndefinitely

  // CASE CLASSES
  /* Common, very lightweight data structures with boilerplate:
  All case classes have a pre-defined:
    - sensible .equals() and .hashcode() methods
    - sensible and quick serialization (these classes are sent over wire)
    - companion object is created WITH the APPLY method
  */
  case class Person(name: String, age: Int)

  // case classes can be constructed WITHOUT the new keyword
  val bob = Person("Bob", 54)
  // equivalent: val bob = Person.apply("Bob", 54)


  // Exceptions
  /*

  */
 try {
   val x: String = null
   x.length
 } catch {
   case e: Exception => "some faulty error message"
 } finally {
   // will execute if FAILS or SUCCEEDS
 }

 // Generics
 /*
 */

}
