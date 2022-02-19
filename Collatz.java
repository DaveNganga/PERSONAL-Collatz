// So This is a simple program attempting to emulate Collatz Conjecture for the first 1000 numbers. 
// The intent is to check for numbers that have interesting loops. 
import java.util.ArrayList;
import java.util.Stack;
import java.io.FileWriter;
import java.io.File;  
import java.io.IOException;
import java.awt.*;
public class Collatz{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    try{
        File collatz = new File("collatz.txt");
        FileWriter myWriter = new FileWriter("Collatz.txt");
        myWriter.write("A List of Collatz arrays where n < 10\n \n");

            for(int x = 2; x<10; x++) {
             Stack<Integer> stack = new Stack<Integer> (); 
             myWriter.write(returnStack(x, stack).toString() + "\n");
             //System.out.println(returnStack(x, stack));
            }

        myWriter.write("\nDone By Dave Ng'ang'a \n");
        myWriter.close();
        Desktop.getDesktop().open(collatz);    
    }
    catch (IOException e) {
      System.out.println("An error occurred. Probably has to do with permissions");
      e.printStackTrace();
    }
 } 


 static boolean checkNumber(int n) {
    if (n%2 == 0) {
        return true;
    }
    return false;
} 
static Stack <Integer> returnStack(int x, Stack stack) {
        //Stack<Integer> emptyStack = new Stack<Integer> (); 
    if (!stack.contains(x)){
        stack.push(x);
    }
    if(checkNumber(x)) {
        int p = x/2;
        if(p==1){
            stack.push(p);
            return stack;
        }
        else if (stack.contains(p)){
            stack.push(p);
            return stack;
        }
        else{
            stack.push(p);
            returnStack(p,stack);
        }
    }
    else if(!checkNumber(x)){
        int p = (3*x)+1;
        if(p==1){
            stack.push(p);
            return stack;
        }
        else if(stack.contains(p)){
            stack.push(p);
            return stack;
        }
        else{
            stack.push(p);
            returnStack(p,stack);
        }  
    }
    return stack;
}

}
