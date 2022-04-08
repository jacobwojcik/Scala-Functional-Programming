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

// The challenge is to write higher-order functions that transform curried into uncurried and vice versa.
// You can't use Function.uncurried or curried.  
// Say we have two functions:

//   def a( x: Int, y: String) {
//       println("a " + x + " " + y)
//   }
//   def b(x:Int)(y:String) {
//       println("b " + x + " " + y)
//   }
// say they have both trivial implementation e.g. print the f name and arguments to the output.
// The task is to write: 

// val ca = curryIt(a)
// ca(0)("Hello")

// val ub = uncurryIt(b)
// ub(0, "Hello")

// Reminder, the function w/o return value (the procedure) is the same as a function returning Unit type.