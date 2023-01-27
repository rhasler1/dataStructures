
import java.util.Stack;

public class StackExercise {
    
    public static void main(String[] args){
        //create Stack using built in Java class
        int[] data = {1,3,5,4,1};
        Stack<Integer> s = new Stack<>();
        //push elements into stack
        for (int i = 0; i < data.length; i++) {
            s.push(data[i]);
        }
        //prints instantiated stack
        System.out.println("new stack = " + s);
        
        //method printReverse
        System.out.print("elem(s) in reverse order = ");
        printReverse(s);
        System.out.println();
        
        // method insertElem
        insertElem(s, 2, 3);
        System.out.println();
        
        //method smallestInt
        int num = 1;
        System.out.printf("smallest index of %d is = " + smallestInt(s, num), num);
        System.out.println();
        
        //method isPalindrome
        String str = "racecar";
        System.out.printf("the word \"%s\" is a palindrome: ", str);
        System.out.print(isPalindrome(str));
    }
    
    /* printReverse- prints elements in stack in reverse order */
    public static void printReverse(Stack<Integer> s) {
        Stack<Integer> tempS = new Stack<>();
        while (!s.isEmpty()) {
            //print elem on top of stack
            System.out.print(s.peek());
            //pop elem off s, then push to newS
            tempS.push(s.pop());
        }
        //return original stack
        while (!tempS.isEmpty()) {
            s.push(tempS.pop());
        }
    }
    
    /*
     * insertElem- inserts parameter numToInsert at specified index 
     * */
    public static void insertElem(Stack<Integer> s, int numToInsert, int index) {
        Stack<Integer> tempS = new Stack<>();
        int toRemove = s.size() - index;
        for (int i = 0; i < toRemove; i++) {
            tempS.push(s.pop());
        }
        s.push(numToInsert);
        while (!tempS.isEmpty()) {
            s.push(tempS.pop());
        }
        System.out.printf("stack after insertion of elem %d at index %d = " + s, numToInsert, index);
    }
    
    /* smallestInt- returns smallest index of provided number in stack */
    public static int smallestInt(Stack<Integer> s, int num) {
        Stack<Integer> tempS = new Stack<>();
        int index = -1;
        //parse entire stack <- number to search for could be at index 0
        while (!s.isEmpty()) {
            int x = s.pop();
            //push elem to tempS
            tempS.push(x);
            //if x equals num save index
            if (x == num) {
                index = s.size();
            }
        }
        //restore s
        while(!tempS.isEmpty()) {
            s.push(tempS.pop());
        }
        return index;
    }
    
    /* isPalindrome- checks string for palindrome using stack */
    public static boolean isPalindrome(String s) {
        Stack<Character> tempS = new Stack<>();
        String s2 = "";
        for (int i = 0; i < s.length(); i++) {
            //parse string into char(s)
            char c = s.charAt(i);
            //push elem,char, on tempS
            tempS.push(c);
        }
        while (!tempS.isEmpty()) {
            //pop elem off tempS and concatenate to string,s2, <- reverse of s
            s2 += tempS.pop();
        }
        //return result of comparison between s and s2
        return s.equals(s2);
    }
}
