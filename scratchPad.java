import java.io.*; 
import java.util.*; 

public class scratchPad {
     // A utility function to get maximum value in arr[] 
    public static void hashkey (int n){
        int hashkey = ((n*n)+3) % 11;

        System.out.println(n + " --> " + hashkey);
        System.out.println();

    }
   
     /*Driver Code*/
     public static void main(String[] args) 
     { 
        hashkey(12);
        hashkey(9);
        hashkey(1);
        hashkey(0);
        hashkey(42);
        hashkey(98);
        hashkey(70);
        hashkey(3);

     } 
}
