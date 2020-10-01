import java.util.*;

public class Homework1 {

    public static int test = 123456789;

    public static int f(int n){

        if(n <= 0){
            return 0;
        } 
        
        return 1 + f(n-1);

    }

    public static int g(int n){

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += 1;
        }
        
        return sum;

    }

    public static int h(int n){
        return n;
    }

    public static int j(int n){

        if(n <= 1){
            return 1;
        }

        return 1 + j(n/2);

    }

    public static void k(int n){
        
        for(int i = 1; i < n; i *= 2){
            j(i);
        }

    }

    //assumption that n is nonnegative 
    public static int Q6(int n){
        Set<Integer> digits = new HashSet<Integer>();
        Set<Integer> correct = new HashSet<Integer>();

        for(int i = 0; i < 10; i++){
            correct.add(i);
        }

        for (int k = 1; k < 10; k++){
            int temp = (k*n);
            while (temp > 0){
                digits.add(temp%10);
                temp = (temp/10);
            }
            
            if (digits.equals(correct)){
                return k;
            }
        }

        return -1;
    }

    public static void main (String[] args){

    //   System.out.println(g(test));
    //   System.out.println(f(test));
    //   System.out.println(h(test));
    //    System.out.println(k(test));

        System.out.println(Q6(test));

    }

}
