package org.structstream.mq

object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello from Scala in a JAR on GitHub Actions!")
    println(s"Arguments received: ${args.mkString(", ")}")
  }
}