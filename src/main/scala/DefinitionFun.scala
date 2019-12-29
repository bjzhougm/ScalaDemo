object DefinitionFun {

  /**
    * 定义函数的五种方式
    * @param args
    */

  def main(args: Array[String]): Unit = {
    println(addInt.apply(2,3))
    println(function5)
  }


  /**
    * 规范化写法,scala 函数的返回值是最后一行代码。
    */

  def addInt_1(a:Int,b:Int) : Int = {
    val total : Int = a + b
    return total
  }

  /**
    * 1.Unit，是Scala语言中数据类型的一种，表示无值,用作不返回任何结果的方法；
    */
  def returnUnit(): Unit = {
    println("ZST loves basketball !")
  }

  /**
    * 2.不写明返回值的类型，程序会自行判断，最后一行代码的执行结果为返回值;
    */

  def addInt_3(a:Int,b:Int):Int = {
    a+b
  }

  def function5():Int={
    2+5
  }

  /**
    * 3.省略返回值类型和等于号，返回的是();
    */
  def addInt(a:Int,b:Int){
    a+b
  }

  /**
    * 4.函数只有一行的写法;
    */
  def addBigInt (a:BigInt,b:BigInt) = a + b

  /**
    * 5.最简单写法：def ,{ },返回值都可以省略，此方法在spark编程中经常使用。
    * 表示定义函数addInt,输入参数有两个分别为x、y,且均为Int类型,返回值为两者的和,类型为Int.
    */
  val addInt = (x: Int,y: Int) => x + y



}
