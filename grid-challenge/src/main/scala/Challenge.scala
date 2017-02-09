import scala.io.Source

object Challenge extends App {

  def parseInput(string: String) = {
    string.toCharArray.toList.toSeq
  }

  def sortByLetter(string: Seq[Char]): Seq[Char] = {
    val bleh = string.toArray
    //insertion sort
    for(currentIndex <- 1 to string.length -1){
      val currentChar = string(currentIndex)
      var previousIndex =  currentIndex - 1
      while (previousIndex >= 0 && (bleh(previousIndex) > currentChar)){
        bleh(previousIndex + 1) = bleh(previousIndex)
        previousIndex = previousIndex - 1
      }
      bleh(previousIndex + 1) = currentChar
    }
    bleh
  }

  def solve(input: Seq[Seq[Char]]) : String = {

    val sortedGrid = input.map(string => {
      sortByLetter(string)
    })
    // traverse the grid
    var res =  "YES"
    for(i <- sortedGrid.indices) {
      for (j <- 0 to sortedGrid.length - 2) {
        if(sortedGrid(j)(i) > sortedGrid(j+1)(i) ) {
          res = "NO"
        }

      }
    }
    res
  }


  assert(args.length == 1, "Invalid Arguments")

  //Given a grid of characters can the be ordered so they are lexically order in both rows and columns
  val input = Source.fromFile(args(0)).getLines()
  val res = input.toList.map(parseInput).toSeq

  println(solve(res))

}
