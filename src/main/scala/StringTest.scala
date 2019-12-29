object StringTest {

  def main(args: Array[String]): Unit = {

    /**
      * 字符串的定义
      * var greeting = "Hello World!";
      *
      * 或
      *
      * var greeting:String = "Hello World!";
      */

    val greeting = "Hello World!"


    println(greeting)


    /**
      * 创建可变字符串
      */

    val buf = new StringBuilder;
    buf += 'a'
    buf ++= "bcdef"
    println( "buf is : " + buf.toString );


    /**
      * 字符串长度
      *
      */

    val palindrome = "wwww.baidu.com";
    val len = palindrome.length()
    println("String Length is : " + len)


    /**
      * 字符串连接
      * str1:Nothing
      */

    val str1 = "菜鸟教程官网："
    val str2 = "www.runoob.com"
    val str3 = "菜鸟教程的 Slogan 为："
    val str4 = "学的不仅是技术，更是梦想！"
    println(str1 + str2)
    println(str3.concat(str4))

    /**
      * 字符串格式化
      */

    val floatVar = 12.456
    val intVar = 2000
    val stringVar = "菜鸟教程!"
    val fs = printf("浮点型变量为 " +
      "%f, 整型变量为 %d, 字符串为 " +
      " %s", floatVar, intVar, stringVar)
    println(fs)


  }



}
