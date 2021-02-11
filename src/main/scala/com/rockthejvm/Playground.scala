package com.rockthejvm

/**
  * This simple application is an invitation to you to play around with any Scala code you like!
  * (not that you'd not be able to create your own application, mind you.)
  *
  * So get creative - test the code that we write in the videos and try new things!
  *
  * Daniel @ Rock the JVM
  */
object Playground extends App {
  val meaningOfLife: Int = 42
  val aBoolean = false // adding type is optional; can be inferred

  // In Scala, EVERYTHING is an EXPRESSION that can be reduced to a VALUE
  val anExpression = 2 + 3

  // if-expression
  // Akin to ternary expression
  // an EXPRESSION because reduces to SINGLE VALUE
  val ifExpression = if (meaningOfLife > 43) 56 else 999

  // can chain if expresions
  // A chained (composed) EXPRESSION still reduces to a SINGLE VALUE
  // Paradigm is different:
  // Instead of doing something based on conditons,
  // simply assign value based on conditions
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
      else if (meaningOfLife < 0) -2
      else if (meaningOfLife > 999) 78
      else 0

  // Everything in Scala is an expression
  // code blocks are prevalent expressions
  val aCodeBlock = {
    // defintions
    val aLocalValue = 67
    // last expression of code block is the VALUE of the entire code block
    aLocalValue + 3
  }

  // define a function
  // single expression on RHS of a function
  def myFunction(x: Int, y: String): String = s"$y $x"

  // functions often have a code block, which is also single expression
  def myCodeBlockFunction(x: Int, y: String): String = {
    s"$y $x"
  }

  // recursive function
  def factorial(n: Int): Int = {
    if (n <=1) 1
    else n * factorial(n - 1)
  }

  // tail recursive function
  def factorialTailRecursive(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else factorialTailRecursive(n-1, n*acc)
  }

  // In scala, we don't iterate, we use RECURSION

  // No meaningful value == UNIT == VOID
  // Unit value is related to SIDE EFFECTS
  // Involves printing, sending to file
  // nothing to do with meaningful information
  println() // Returns Unit value

  def myUnitReturningFunction() : Unit = println("This is a Unit return")
}
