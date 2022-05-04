import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import slick.driver.PostgresDriver.api._

object Main {
  def main(args: Array[String]): Unit = {
    // println("Hello, World!")
    // TODO: application.confから接続情報を取得したい
    // val db = Database.forConfig("mydb")
    val db = Database.forURL(
      "jdbc:postgresql://127.0.0.1/test01",
      driver="org.postgresql.Driver",
      user="app_user",
      password="password"
    )
    val mybook = TableQuery[Mybooks]
      Await.result(db.run(DBIO.seq(
        // create the schema
        mybook.schema.create,

        // insert two User instances
        mybook += Mybook(4, "John Doe"),
        mybook += Mybook(5, "Fred Smith"),

        // print the users (select * from USERS)
        mybook.result.map(println)
      )), Duration.Inf)
  }
}

case class Mybook(id: Int, name: String)

class Mybooks(tag: Tag) extends Table[Mybook](tag, "mybook2") {
  def id = column[Int]("id", O.PrimaryKey)
  def name = column[String]("name")
  def * = (id, name).mapTo[Mybook]
}
