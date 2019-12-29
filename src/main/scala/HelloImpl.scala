/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-08
  * Time: 19:54
  */

object HelloImpl  extends Hello ("hello"){
  override def sayHello(name: String): Unit = {
    println(message+","+ name)
  }

  def main(args: Array[String]): Unit = {
    sayHello("leo")
  }
}





