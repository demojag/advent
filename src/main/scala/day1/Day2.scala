package day1

import scala.io.Source

object Day2 extends App {

  val lines: Vector[Int] = Source.fromResource("inputDay2.txt").mkString.split(",").toVector.map(l => l.toInt)

  var notFound = true
  while (notFound) {
    val input = lines.patch(1, Seq(1, 1), 2)
    if (intProgram.parse(input, 0)(0) == 19690720)
      notFound = true
  }

}


object intProgram {
  def parse(input: Vector[Int], positionMarker: Int): Vector[Int] = {
    input(positionMarker) match {
      case 1 => parse(input.updated(input(positionMarker + 3), input(input(positionMarker + 1)) + input(input(positionMarker + 2))), positionMarker + 4)
      case 2 => parse(input.updated(input(positionMarker + 3), input(input(positionMarker + 1)) * input(input(positionMarker + 2))), positionMarker + 4)
      case 99 => input
    }
  }

  def findValue(input: Vector[Int], indexOne: Int, indexTwo: Int): Int = {
    val parsed = input.patch(1, Seq(indexOne, indexTwo), 2)
    if (intProgram.parse(parsed, 0)(0) == 19690720)
      19690720
    else if(indexOne <99)
      findValue(input,indexOne+1,indexTwo)
    else if (indexOne == 99)
      findValue(input,0,indexTwo+1)
    else
      findValue(input, indexOne,indexTwo+1)
  }
}

