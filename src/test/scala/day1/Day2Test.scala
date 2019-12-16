package day1

import org.scalatest.matchers.should.Matchers

class Day2Test extends org.scalatest.FunSuite with Matchers {

  //1,0,0,0,
  // 99 becomes 2,0,0,0,99 (1 + 1 = 2).
  val simpleProgram = {
    val reference = Vector(1,0,0,3,1,1,2,3,1,3,4,3,99)
    //1,1,1,4,99,5,6,0,99
    //2,4,4,5,99,0   - 2,4,4,5,99,9801
    //1,0,0,3,1,1,2,3,1,3,4,3,99 -
    //1,0,0,1,1,1,2,3,1,3,4,3,99
    val expectedListOutput = Vector(2,0,0,0,99)
    val expectedTotal = 30

    intProgram.parse(reference,0) should be(Vector(1,0,0,1,1,1,2,3,1,3,4,3,99))



  }
}
