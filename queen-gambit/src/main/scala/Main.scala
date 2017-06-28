import java.io.File

object Main extends App {

  val pretty = true
  def run(): Unit ={

    val sc = new java.util.Scanner(new File("input00.txt"))
    val n = sc.nextInt()
    val k = sc.nextInt()
    val rQueen = sc.nextInt()
    val cQueen = sc.nextInt()

    val obstacles = ( 0 until  k ).map { _=>
      val r = sc.nextInt()
      val c = sc.nextInt()
      (r, c)
    }
    val board = ( 1 to n).flatMap { i =>
      (1 to n).map { j =>
        (i , j)
      }
    }

    val queenLoc = (rQueen, cQueen)
    val moveLeft = (0, -1)
    val moveRight = (0, 1)
    val moveUp = (0, 1)
    val moveDown = ( 0, -1)

    val moveDownDiagLeft = ( -1, -1)
    val moveUpDiagLeft = ( 1,  1)
    val moveDownDiagRight = ( 1,  -1)
    val moveUpDiagRight = ( -1,  1)

    val possibleMoves = Seq(moveLeft, moveRight, moveUp, moveDown, moveDownDiagLeft, moveUpDiagLeft, moveDownDiagRight, moveUpDiagRight)


    val r = possibleMoves.map ( move => {
      makeMove(queenLoc, move, obstacles, board)
    }).sum
    println(r)

  }
  def makeMove(queenLoc: (Int,Int) , move: (Int,Int), obstacles: Seq[(Int,Int)], board: Seq[(Int,Int)]) : Int = {
    var hitOb = false
    var moveCounter = 0
    var newQueenLocation = queenLoc
    while (!hitOb) {
      val newLocR = newQueenLocation._1 + move._1
      val newLocC = newQueenLocation._2 + move._2
      log(s"new location ${(newLocR, newLocC)}")

      if(obstacles.contains((newLocR, newLocC))){
        hitOb = true
        log(s"hit obstacle ${(newLocR, newLocC)}")
      } else {
        if(board.contains((newLocR, newLocC))) {
          moveCounter = moveCounter + 1
          newQueenLocation = (newLocR, newLocC)
          log(s"new move ${(newLocR, newLocC)} move Count $moveCounter")
        } else {
          log(s"moved off board ${(newLocR, newLocC)}")
          hitOb = true
        }
      }
    }
    moveCounter
  }
  def log(message:String): Unit = {
    if(!pretty) {
      println(message)
    }
  }
  run()

}