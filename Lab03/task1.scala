object Main {
  def main(args: Array[String]): Unit ={

    val strList = List("Assume", "there", "is",  "a", "list", "of", "string", "given");
    //A
    val wordsNoLongerThanFour = for( x <-strList if(x.length() > 4)) yield x;
    println(wordsNoLongerThanFour);
    //B
    val wordsContainingA = for( x <-strList if(x.toLowerCase().contains('a'))) yield x;
    println(wordsContainingA);

    val listOfPairs = for( x <-strList ) yield (x, x.length());
    println(listOfPairs);

    //D
    val r = scala.util.Random
    val secondListOfWords = List("Here", "the", "idea");
    val twoWord = strList(r.nextInt(strList.length)) + " " + secondListOfWords(r.nextInt(secondListOfWords.length));

    println(twoWord);

  }
}

// Exercise 1
// Assume there is a list of string given (e.g. copy this line). The goal is to write the code that:
// A) produces the list of words that are longer than 4 characters.
// B) list of words containing letter 'a'
// C) produce list of pairs containing string and it's length
// D) Given two lists of words generate two word keyword by combining two random* words

// * To generate a random integer in range use this:
// val r = scala.util.Random
// r.nextInt(N) <- gives an integer in the range of [0,N)