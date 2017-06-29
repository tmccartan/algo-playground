import java.io.File

object Main extends App {

  val pretty = false
  def run(): Unit = {

    val sc = new java.util.Scanner(new File("input00.txt"))
    val testCases = sc.nextLong()

    (0L until testCases) foreach { i =>

      val numDays = sc.nextInt()

      val prices = (0L until numDays) map { j =>
        sc.nextLong()
      }
      println(getMaxProfit(prices))
    }
  }
  def getMaxProfit(prices: Seq[Long]): Long = {
    var profit = 0L
    var maxSoFar = 0
    (prices.length -1 until -1 by -1) foreach { i =>

      if (prices(i) >= maxSoFar) {
        log(s"price i ${prices(i)} is better than $maxSoFar")
        maxSoFar = prices(i).toInt
      }
      log(s"profit is ${profit} maxSoFar $maxSoFar - price ${prices(i)}")


      profit += maxSoFar - prices(i)
    }
    profit
  }

  def log(message:String): Unit = {
    if(!pretty) {
      println(message)
    }
  }
  run()

}