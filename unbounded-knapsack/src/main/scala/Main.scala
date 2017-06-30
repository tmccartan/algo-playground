import java.io.File

object Main extends App {

  val pretty = false
  def run(): Unit = {

    val sc = new java.util.Scanner(new File("input00.txt"))
    val testCases = sc.nextInt()
    (0 until testCases) foreach { _ =>
      val lengthOfList = sc.nextInt()
      val expectedNumber = sc.nextInt()
      val items = (0 until lengthOfList) map{ _ =>
        sc.nextInt()
      }
      println(isSubSetSum(items.toArray, items.length , expectedNumber))

    }

  }
  def isSubSetSum(items: Array[Int], n: Int, expectedSum: Int): Int = {
    val table = Array.ofDim[Int](expectedSum+1, n )

    (0 until  n) foreach { i =>
      table(0)(i) = 0
    }
    (1 to expectedSum) foreach {i =>
      (0 until n ) foreach { j =>
        if (j == 0) {
          if (i >= items(j))
            table(i)(j) = table(i - items(j))(j) + items(j)
          else
            table(i)(j) = 0
        } else {
          if (i >= items(j)) {
            table(i)(j) = Math.max(table(i)(j - 1), table(i - items(j))(j) + items(j))
          } else {
            table(i)(j) = table(i)(j - 1)
          }
        }
      }
    }
    table(expectedSum)(n - 1)
  }

  def log(message:String): Unit = {
    if(!pretty) {
      println(message)
    }
  }
  run()

}