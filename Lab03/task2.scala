object Main {
  def main(args: Array[String]): Unit ={

    println(constVal);
    println(constVal());

    println(gt(5)(4));
    println(gt(3)(4));

    println(op(mult,(2,3)));

  }
  def constVal() : Double = 3.1415;
  def gt(x: Int): Int => Boolean = {return (y:Int) => x > y};
  def mult(x: Int, y: Int) = x*y;
  def op(myFunc:( Int, Int) => Int, list:(Int, Int)):Int = {
    return myFunc.tupled(list)};
}

// Exercise 2
// Here the idea is to write a few simple functions:
//     println( constVal ) // gives 3.1415
//     println( constVal() ) // also gives 3.1415
//     println( gt(5)(4) ) // gt == greater than - here true
//     println( gt(3)(4) ) // false
//     def mult(x: Int, y: Int) = x*y
//     println( op(mult, (2, 3) ) ) // returns of applicaiton of function passed as the first argument to the second argument