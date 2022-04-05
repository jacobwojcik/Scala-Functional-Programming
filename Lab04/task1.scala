object Main {
  def main(args: Array[String]): Unit = {
    val ca = curryIt(a);
    ca(0)("Hello");

    val ub = uncurryIt(b);
    ub(0, "Hello")
  }

  def a( x: Int, y: String):Unit = {
    println("a " + x + " " + y)
  }
  def b(x:Int)(y:String): Unit =  {
    println("b " + x + " " + y)
  }
  def curryIt(fun: (Int, String) => Unit): Int => String => Unit={
    (x:Int)=>(y:String)=> {
      fun(x, y);
    }
  }
  def uncurryIt(fun: Int => String => Unit): (Int, String) => Unit={
    (x: Int, y: String) => {
      fun(x)(y);
    }
  }
}