/**
  * Created by IntelliJ IDEA.
  * User: zhougm
  * Date: 2019-04-08
  * Time: 17:04
  */
object TestClass {

  def main(args: Array[String]): Unit = {
    //val helloWorld = new HelloWorld
    //helloWorld.sayHello()
    //println(helloWorld.getName)


    val leo = new Student
    println(leo.name)
    leo.name_=("leo2")
    leo.updateName("leo1")
    println(leo.name)

    leo.age_=(2)
    println(leo.age)


    val studentOne = new StudentOne

  }

}
