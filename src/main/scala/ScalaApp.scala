import scala.io.StdIn
import scala.util.control.Breaks

object ScalaApp {

  def main(args: Array[String]): Unit = {
      //每一行加不加分号都可以
    /**
      * 注：无参数的函数调用，加不加括号都行
      */
    readKeyBoard

    /**
      * 测试match
       */
    //matchTest()

    //matchBackValue

    //匿名函数
    var add = (a: Integer, b: Integer) => a + b //是不是有点c#中匿名方法和lambda的味道了:)
    println(add(1,2))
  }

  /**
    * 键盘读取实例，无返回值
    *
    * 注意：无返回值，即相当于返回值为Unit,所以上面的方法声明也可以写成
    *
    * def readKeyBoard():unit{}
    *
    * @return null
    */

  def readKeyBoard() {
    var line = StdIn.readLine();
    val loop = new Breaks
    loop.breakable {
      while (line != null) {
        println("你输入的是：" + line)
        line = StdIn.readLine()
        if (line.equals("bye")) {
          println("nice to meet you !see you later, bye\n")
          loop.break;
        }
      }
    }
  }

  /**
    * case后面隐含一个break，case语句可以配置任何类型
    */
  def  matchTest(){
    val myVar="theValue"

    myVar match {
        case "someValue" => println(myVar+"1")
        case "thisValue"=>println(myVar+"2")
        case "theValue"=>println(myVar+"3")
        case "doubleValue"=>println(myVar+"4")
    }
  }

  /**
    * case可以返回值
    */
  def matchBackValue(): Unit ={
    val myVar="theValue"

    val myResult={
      myVar match {
        case "someValue"   => myVar + " A";
        case "thisValue"   => myVar + " B";
        case "theValue"    => myVar + " C";
        case "doubleValue" => myVar + " D";
      }
    }
    println(myResult)
  }

  /**
    * 整数加法(带返回值示例)
    * @param x
    * @param y
    * @return
    */
  def add(x: Integer, y: Integer): Integer = {
    print(x + " + " + y + " = ")
    x + y
  }


  /**
    * 异常处理示例
    */
  def div(x: Long, y: Long): Double = {
    var hasError = false
    try {
      if (y.equals(0L)) throw new RuntimeException("divide by zero") else x.toDouble / y
    }
    catch {
      case e: Exception => {
        hasError = true
        println("error:" + e.getMessage())
        Double.MinValue
      }
    }
    finally {
      if (hasError) println("finished , but there has a error") else println("finished")
    }
  }

  /**
    * 递归示例
    * @param x
    * @return
    */
  def factorial(x: Integer): Long = {
    if (x.equals(0)) 1 else x * factorial(x - 1)
  }


  /**
    * 演示for循环
    * @param x
    * @return
    */
  def factorial2(x: Integer): Long = {
    if (x <= 0) return 1 //注：加return后，下面的代码就不执行了
    println("test")
    var temp = 1L
    for (i <- 1 to x) {
      temp = temp * i
    }
    temp
  }

  def oneFunc = {
    println("one func")
  }

  /**
    * 无参函数，可以直接作为另一个函数的参数（有点象c#中的委托）
    * @param a
    */
  def twoFunc(a: Unit) = {
    println("two func"+a)
  }

  //调用示例
  twoFunc(oneFunc)


  def forDemo = {
    for (x <- 1 to 2; y <- 3 to 4) println("x=" + x + ",y=" + y)

    println

    //上面的写法，等效于下面的写法
    for (x <- 1 to 2)
      for (y <- 3 to 4)
        println("x=" + x + ",y=" + y)

    println
    //带条件的for循环(打印10以内的偶数)
    for (i <- 1 to 10; if i % 2 == 0) println(i)
  }

}
