// src/main/scala/org/structstream/mq/mq.scala
package org.structstream.mq


// Another object in the same file
object Calculator {
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
}


// Another class in the same file
class Greeter(name: String) {
  def greet(): Unit = {
    println(s"Greetings, $name!")
  }
}



// This is your main entry point object
object mq {
  def main(args: Array[String]): Unit = {
    println("Hello from Scala in a JAR!")
    val greeter = new Greeter("Team")
    greeter.greet()
    println(s"10 + 5 = ${Calculator.add(10, 5)}")
  }
}

