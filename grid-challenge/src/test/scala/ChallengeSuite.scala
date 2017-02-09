

import org.scalatest.{FunSpec, Matchers}

class ChallengeSuite extends FunSpec with Matchers{

  it("should pass basic test") {
    Challenge.solve(Seq(
      Seq('e','b','a','c','d'),
      Seq('f','g','h','i','j'),
      Seq('o','l','m','k','n'),
      Seq('t','r','p','q','s'),
      Seq('x','y','w','u','v')
    )) shouldBe "YES"
  }
  it("should fail correctly") {
    Challenge.solve(Seq(
      Seq('e','b','a','c','d'),
      Seq('f','g','h','i','j'),
      Seq('o','v','m','k','n'),
      Seq('t','r','p','q','s'),
      Seq('x','y','w','u','o')
    )) shouldBe "NO"
  }

  it("Should parse the input correctly") {
    Challenge.parseInput("abcde") shouldBe Seq('a','b','c','d','e')
  }
}
