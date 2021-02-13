package com.rockthejvm


object FunctionalProgramming extends App {
  // Scala is an Object Oriented Language
  // Presence of apply method allows class to be invoked as a method
  class Person(name: String) {
    // apply method is special in Scala
    def apply(age: Int) = println(s"I have aged $age years")
  }

  // new Person instance
  val bob = new Person("Bob")
  // two lines below are equivalent
  bob.apply(43)
  bob(43)


  /*
  Scala runs on JVM
  JVM fundamentally built for Java, and knows objects very well
  However, functions are NOT RECOGNIZED AS FIRST CLASS CITIZENS
  In functional programming, we want to:
  - Compose functions
  - Pass functions as arguments
  - return functions as results

  We want to treat FUNCTIONS like OBJECTS/VALUES

  As a soution, Scala developers created somthing called FunctionX:
  Function1,
  Function2,
  Function3,
  ...,
  Function22 // 22 is the max number of arguments a Scala function can take
  */

 // ALL THREE are equivalent
 val simpleIncrementor = new Function1[Int, Int] {
   override def apply(arg: Int): Int = arg + 1
 }
 val sugaryIncrementor: Int => Int = (x: Int) => x + 1
 val shorthandIncrementor = (x: Int) => x + 1

 simpleIncrementor.apply(23) // returns 24
 simpleIncrementor(23) // returns 24
 sugaryIncrementor(23) // returns 24
 shorthandIncrementor(23) // returns 24

 // ALL SCALA FUNCTIONS ARE INSTANCES OF THE FUCTION_X TYPES

 // Concat two strings
 val myStringConcat = new Function2[String, String, String] {
   override def apply(arg1: String, arg2: String): String = s"$arg1$arg2"
 }

 val sugaryStringConcat: (String, String) => String = (s1: String, s2: String) => s1 + s2
 val shortStringConcat = (s1: String, s2: String) => s1 + s2
}
