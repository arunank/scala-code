/**
  * Created by arunankannan on 19/08/2018.
  */

object BillAndTedOdometer extends App {

  var inputs = List[List[(Int,Int)]]()

  try {
    val MaxSets = 10
    var countSets = 1
    var line = scala.io.StdIn.readLine()
    while(line.toInt != -1 && countSets <= MaxSets)  {
      var innerList = List[(Int,Int)]()
      if (1 <= line.toInt && line.toInt <= 10) {
        1 to line.toInt foreach { n =>
          val newLine = scala.io.StdIn.readLine()
          val Array(s, t) = newLine.split(" ").map(_.toInt)
          if (1<=s && s <= 90 && 1 <=t && t <= 12)
            innerList = innerList :+ (s,t)
        }
      }
      inputs = inputs :+ innerList
      countSets = countSets+1
      line = scala.io.StdIn.readLine()
    }
  } catch {
    case e: NumberFormatException => println("Invalid integer input.",e)
    case n => println("Exception in flow." , n)
  }


  inputs map { list => println(s"${
    var previousTime = 0;
    list.map {
    case (s,t) => {
      val d = s * (t - previousTime)
      previousTime = t
      d
    }
    }.sum
  } miles") }

}
