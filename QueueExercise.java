import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExercise{
    public static void main(String[] args){
        //create queue using built in Java interface with linked list
        Queue<Integer> q = new LinkedList<>();
        
        //offer or push items into queue
        q.add(1); //index 0
        q.add(2); //index 1
        q.add(3); //index 2
        q.add(4); //index 3
        int k = 2;
        System.out.println(q);
    
        //call methods
        System.out.print(reverseQueueRecursion(q));
        System.out.println();
        printKReverse(q, k);
        System.out.println();
        System.out.print(numOperations(q));
    }
    
    /* 
     * reverseQueueRecursion- reverses parameter q using recursion
     * image:
     * q = [1, 2, 3, 4]
     * q = [2, 3, 4]  e = 1 <- after first q.poll() and before method call- recursion
     * q = [3, 4]  e = 2 <- recursion begins
     * q = [4]  e = 3
     * q = [] e = 4
     * q = [] <- base case return q- begins collapse of method calls
     * q = [4]
     * q = [4, 3]
     * q = [4, 3, 2] <- all recursive methods collapsed at this point
     * q = [4, 3, 2, 1] <- offer "first"(1) q.poll()
     * return q  q = [4, 3, 2, 1]
     * */
    public static Queue reverseQueueRecursion(Queue<Integer> q) {
        //Collapse method calls when q is empty.
        if (q.isEmpty()) {
            //Base case return q- reverse of 0 elem queue is itself
            return q;
        }
        //dequeue elem
        int e = q.poll();
        //method call- begin recursion
        reverseQueueRecursion(q);
        //enqueue elem
        q.offer(e);
        return q;
    }
    
    /* 
     * printKReverse- reverses first k elements in q
     * image:
     * q = [4, 3, 2, 1] <- before first for loop
     * q = [2, 1]  s = [4, 3] <- after first for loop
     * q = [2, 1, 3, 4] <- after while loop
     * q = [3, 4, 2, 1] <- after second/last for loop
     * */
    public static void printKReverse(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int qSize = q.size();
        //dequeue first k elements of queue and push onto stack
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }
        //pop elements off stack and enqueue- reversing order of k elem(s)
        while (!s.isEmpty()) {
            q.offer(s.pop());
        }
        //wrap other elem(s) to other end of queue
        for (int i = 0; i < qSize - k; i++) {
            q.offer(q.poll());
        }
        System.out.print(q);
    }
    /* 
     * numOperations- returns true if operations can be completed, false
     * if operations cannot be completed.  Operation- if elem in array is 0
     * dequeue/poll, if elem in array is 1 enqueue/offer.
     * Integer value of offer(ed) elem is hard coded to 5.
     * */
    public static boolean numOperations(Queue<Integer> q) {
        int[] arrayBinary = {1, 0, 0, 0, 0, 0, 1};
        for (int i = 0; i < arrayBinary.length; i++) {
            int x = arrayBinary[i];
            if (q.size() == 0 && x == 0) {
                return false;
            }
            else if (x == 0) {
                q.poll();
            }
            else if (x == 1) {
                q.offer(5);
            }
        }
        //System.out.print(q.size());
        //System.out.print(q);
        return true;
    }
    
}
