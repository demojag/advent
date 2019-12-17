package day1

object day4 extends App {
  println("It's day 4!")
  val r = Range(353096,843212)

  //val r = Seq(111111, 223450, 123789)
  val foundPassword = r.foldLeft(0)((acc :Int, num : Int) => {
    val seq = num.toString.split("").foldLeft(List[Int]())((a : List[Int], s : String ) =>{
        a :+s.toInt
    })
    if(checkPassword(num.toString, seq)){
      acc +1
    }
    else acc
  })

  println(foundPassword)


  def checkPassword(password : String, seq : List[Int]) : Boolean = {
    password.length == 6 && checkAdjacent(seq) && checkIncreasing(seq)
  }

  def checkAdjacent(password :List[Int]) : Boolean = {
    password.sliding(2).exists { case Seq(d1, d2) => d1 == d2 }
  }

  def checkIncreasing(password :List[Int]) : Boolean = {
    password.sliding(2).forall { case Seq(d1, d2) => d1 <= d2 }
  }
}

/*
However, they do remember a few key facts about the password:

It is a six-digit number.
The value is within the range given in your puzzle input.
Two adjacent digits are the same (like 22 in 122345).
Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
Other than the range rule, the following are true:

111111 meets these criteria (double 11, never decreases).
223450 does not meet these criteria (decreasing pair of digits 50).
123789 does not meet these criteria (no double).
How many different passwords within the range given in your puzzle input meet these criteria?

Your puzzle input is 353096-843212.
 */