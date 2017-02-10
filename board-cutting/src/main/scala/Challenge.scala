import scala.io.Source

object Challenge extends App {

  def solve(costOfHorizontal: Seq[Long], costOfVerticalCuts: Seq[Long])={

    val orderedHorizontal = costOfHorizontal.sorted(Ordering[Long].reverse)
    val orderedVertical = costOfVerticalCuts.sorted(Ordering[Long].reverse)
    //greedy
    // always take the cut that costs the less
    // a cut across an already cut board costs cutCost * numberOfCuts

    var horizontalCuts = 1l
    var verticalCuts = 1l
    var cost = 0l

    var numOfCuts =  orderedHorizontal.size + orderedVertical.size

    while(numOfCuts != 0){

      val maxH = orderedHorizontal.drop(horizontalCuts.toInt -1).headOption.getOrElse(-1l)
      val maxV = orderedVertical.drop(verticalCuts.toInt -1).headOption.getOrElse(-1l)
      if(maxH > maxV){
        horizontalCuts = horizontalCuts + 1
        cost = cost + (verticalCuts * maxH)
      } else {
        verticalCuts = verticalCuts + 1
        cost = cost + (horizontalCuts * maxV)
      }
      numOfCuts = numOfCuts - 1
   }
    cost
  }
  assert(args.length == 1, "Invalid Arguments")

  //Given two rows (horizontal and vertical) cut costs find the cheapest possible combination of cuts if each
  // cut effects the cost of the next

  val input = Source.fromFile(args(0)).getLines()
  val costOfHorizontalCuts = input.next().split(" ").map(_.toLong)
  val costOfVerticalCuts = input.next().split(" ").map(_.toLong)

  println("Cheapest cut is " + solve(costOfHorizontalCuts, costOfVerticalCuts))

}
