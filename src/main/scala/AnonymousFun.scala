object AnonymousFun {
  /**
    * 匿名函数
    * 格式: Val 变量名 = （参数：类型） => 函数体
    * 箭头左边是参数列表
    * 右边是函数体
    * 然后赋给变量
    * @param args
    */
  def main(args: Array[String]): Unit = {

    val fun2 = (content:String) =>println(content)

    fun2("hadoop")

    val inc =(x:Int) => x+1

    println(inc(7))

    val x=inc(7) -1

    println(x)

    val mul = (x:Int,y:Int) =>x*y

    println(mul(2,3))

    val useDir1=System.getProperties()

    val userDir =()=>{System.getProperty("user.dir")}

    println("userDir====="+userDir)

    println("useDir1======"+useDir1)

    val factor =3

    val multi =(i:Int)=>i*factor

    println(multi(1))

    println(multi(2))

  }

}
