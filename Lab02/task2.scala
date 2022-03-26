object Main {
 def main(args: Array[String]): Unit ={
   val a1 = " qwertyuiopasdfghjklzxcvbnm";
   val a2 = " qazwsxedcrfvtgbyhnujmikolp";
   println(args(0) + " " + args(1));
   println(args(1));

   if(args(0).equals("encode")){
     println("Encode");
     for(index <- args(1)){
       print(a2(a1.indexOf(index)));
     }
   }else{
     println("Decode");
     for(index <- args(1)){
       print(a1(a2.indexOf(index)));
     }
   }

 }
}

// Ex 2:
// Write encoder/decoder. 
// Assume the program gets the text string. It then does substitutaion of the charactes according to a fixed array.
// The program should be able to convert the encoded string back using an inverted transformation.
// Example encoding/decoding array:
// a1 = " qwertyuiopasdfghjklzxcvbnm"
// a2 = " qazwsxedcrfvtgbyhnujmikolp"
// The encoding algorithm should work as follows:
//  * read the string from the command line
//  * loop over all characters in it and for each find the index in string a1
//  * take the character from string a2 that is under the same index and print it
// The decoding algorithm whould be exactly the same except it would use first the string a2.

// Example functionality:
// > scala coder encode "my name is bond"
// .....
// > scala coder decode "gi bbbb er ishh"
// .....