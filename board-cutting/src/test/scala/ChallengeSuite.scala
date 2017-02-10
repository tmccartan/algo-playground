

import org.scalatest.{FunSpec, Matchers}

class ChallengeSuite extends FunSpec with Matchers{

  it("should solve for simple case") {
    Challenge.solve(Seq(2l, 1l),Seq(1l,1l))

  }
  it("should solve for a slightly more difficult case") {
    Challenge.solve(Seq(2l, 1l, 3l, 1l, 4l), Seq(4l, 1l, 2l))
  }

}
