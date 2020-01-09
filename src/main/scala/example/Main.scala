package example
import sttp.tapir._
import sttp.tapir.client.sttp._
import sttp.client._

object Main {

  case class Foo(i: Int, d: Double)

  def main(args: Array[String]): Unit = {
    println("Hello com.example.Empty Project!")

    val e = endpoint
      .in("adf")
      .in(path[String])
      .in(path[Int])
      .in(path[Double])
      .mapIn({
        case (s, i, d) => (s, Foo(i, d))
      })({ case (s, foo) => (s, foo.i, foo.d) })

    e.toSttpRequest(uri"http://host.com").apply(("adsf", Foo(1, 1.0)))
  }

}
