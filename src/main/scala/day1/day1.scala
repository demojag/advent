package day1

import scala.annotation.tailrec
import scala.io.Source

object day1 extends App {


  val lines: List[String] = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("input.txt")).getLines().toList
  val masses: List[Int] = lines.map(l => l.toInt)
  println(calculator.total(masses))

}


object calculator {
  def fuelNeeded(mass: Int): Int = {
    val  total = (mass / 3) - 2
    if (total <= 0) 0
    else total
  }

  def calculatorRec(mass: Int): Int = {
    @tailrec
    def iterate(acc: Int, current: Int): Int = {
      if (current <= 0)
        acc + current
      else
        iterate(acc + fuelNeeded(current), fuelNeeded(current) )
    }

    iterate(0, mass)
  }

  def total(lines: List[Int]): Int = {
    lines.foldLeft(0)((acc: Int, mass: Int) => acc + calculatorRec(mass))
  }
}







