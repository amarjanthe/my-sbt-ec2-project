import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

object Hello extends App {

  val server = HttpServer.create(new InetSocketAddress(9000), 0)

  server.createContext("/", exchange => {
    val response = "Hello from EKS Kubernetes CICD using harness i did project Aj will anything"
    exchange.sendResponseHeaders(200, response.length)
    val os = exchange.getResponseBody
    os.write(response.getBytes)
    os.close()
  })

  server.setExecutor(null)
  server.start()

  println("Server started on port 9000")
}
