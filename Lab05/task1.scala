object Main {
  def main(args: Array[String]): Unit = {
    val lA = List(1,2,3,4);
    val lB = List(10,9,8,7);
    val lC = List(-1,-2,1); // has only 3 elements
    val lD = List(100,90,80,70,60,50); // has more elements

    val output = flatten(List(lA,lB,lC,lD));
    println(output.mkString(","));
  }

  def flatten(list:List[List[Int]]):List[Any] =  {
    merge(list);
  }

  @scala.annotation.tailrec
  def merge(list: List[List[Int]], resultList: List[Int] = List()):List[Int]={
    if(isListOfListsEmpty(list)) return resultList;
    merge(list.drop(1), mergeRec(resultList,list.head) );
  }

  def isListOfListsEmpty(list:List[List[Int]]): Boolean = {
    if(list.isEmpty) return true;
    else if(list.head.isEmpty) return true;
    else return false;
  }
  @scala.annotation.tailrec
  def mergeRec(list1: List[Int], list2:List[Int], newList:List[Int]=List()):List[Int]={
    if(list1.isEmpty && list2.isEmpty) return newList;
    if(list1.isEmpty){
      mergeRec(List(),list2.drop(1), newList :+ list2.head);
    } else mergeRec(list1.drop(1), list2, newList :+ list1.head);
  }

}

// The challenge is to write tile recursive function that merges list of lists by picking elements in such order:
// elements of the list 1, elements of the list 2, elements of the list 3 ... 
// The merging should stop if any list end is reached:

// Example:
//   val lA = List(1,2,3,4)
//   val lB = List(10,9,8,7)
//   val lC = List(-1,-2,1) // has only 3 elements
//   val lD = List(100,90,80,70,60,50) // has more elements
//   val output = flatten( List(lA,lB,lC,lD) )
//   println(output.mkString(", "))

// result: 1, 2, 3, 4, 10, 9, 8, 7, -1, -2, 1, 100, 90, 80, 70, 60, 50