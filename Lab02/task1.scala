object Main {
  def main(args: Array[String]): Unit ={
    val operation = args(0);
    val x = args(1).toBoolean;
    val y = args(2).toBoolean;

    println(operation);
    println("A B RESULT");

    if(operation.equals("AND")){
      logicalPrinter(logicalAnd);
    }
    else if(operation.equals("OR")){
      logicalPrinter(logicalOr);
    }
    else if(operation.equals("XOR")){
      logicalPrinter(logicalXor);
    }

  }
  def logicalAnd(x: Boolean, y: Boolean): Boolean = {
    return x && y;
  }
  def logicalOr(x: Boolean, y: Boolean): Boolean = {
    return x || y;
  }
  def logicalXor(x: Boolean, y: Boolean): Boolean = {
    return x ^ y;
  }
  def logicalPrinter( logicalOperator: (Boolean, Boolean) => Boolean): Unit ={
    println("false false " + logicalOperator(false, false));
    println("false true " + logicalOperator(false, true));
    println("true false " + logicalOperator(true, false));
    println("true true " + logicalOperator( true, true));
  }
}


// Ex 1:
// Write the program that:
//  1 takes the aruments from command line and threat them as boolans
//  2 calculate the result of basic logical operations on them, and, or, xor
//  3 print the table of operations for logical operation provided in the argument:
// > scala booltester AND false true 
// AND
// A  B  RESULT
// false  false false 
// false  true  false 
// true   false false 
// true   true  true

// > scala booltester OR true false
// OR 
// A  B  RESULT
// false  false  false 
// ...