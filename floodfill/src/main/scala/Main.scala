object Main extends App {

  def changeColour(screen: Array[Array[Int]], currentPointX: Int, currentPointY: Int, target: Int) : Unit = {
    if(screen(currentPointX)(currentPointY) != target) {
      screen(currentPointX)(currentPointY) = target
    }
  }

  def floodFill(screen: Array[Array[Int]], currentPointX: Int, currentPointY: Int, oldColour: Int , targetColour: Int): Unit = {

    //base case
    if(currentPointX < 0 || currentPointY < 0 ||
      currentPointX >=  8  ||
      currentPointY >=  8) {

    } else {
      if(screen(currentPointX)(currentPointY) != targetColour &&
          screen(currentPointX)(currentPointY) == oldColour) {
        screen(currentPointX)(currentPointY) = targetColour
      }
      floodFill(screen, currentPointX + 1, currentPointY, oldColour, targetColour)
      floodFill(screen, currentPointX - 1, currentPointY, oldColour, targetColour)
      floodFill(screen, currentPointX , currentPointY + 1, oldColour, targetColour)
      floodFill(screen, currentPointX , currentPointY - 1 , oldColour, targetColour)
    }

  }

  def doWork(): Unit ={

    val newColour = 3
    val currentPos = (4,4)
    val bitmap = Array(
      Array[Int](1, 1, 1, 1, 1, 1, 1, 1),
      Array[Int](1, 1, 1, 1, 1, 1, 0, 0),
      Array[Int](1, 0, 0, 1, 1, 0, 1, 1),
      Array[Int](1, 2, 2, 2, 2, 0, 1, 0),
      Array[Int](1, 1, 1, 2, 2, 0, 1, 0),
      Array[Int](1, 1, 1, 2, 2, 2, 2, 0),
      Array[Int](1, 1, 1, 1, 1, 2, 1, 1),
      Array[Int](1, 1, 1, 1, 1, 2, 2, 1)
    )

    val replacementColour = bitmap(currentPos._1)(currentPos._2)

    floodFill(bitmap, 4, 4, replacementColour, newColour)

    bitmap.foreach( arr =>
    println(arr.mkString(","))
    )

  }

  doWork()
}
