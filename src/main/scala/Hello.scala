import cats.effect._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.ember.server._
import org.http4s.implicits._
import com.comcast.ip4s._

object Hello extends IOApp {

  val routes = HttpRoutes.of[IO] {
    case GET -> Root =>
      Ok("Amar can make anythign and he is AWS DevOps Engineer,now learning Harness!")

    case GET -> Root / "health" =>
      Ok("App is running!")
  }

  def run(args: List[String]): IO[ExitCode] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"9000")
      .withHttpApp(routes.orNotFound)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
}
