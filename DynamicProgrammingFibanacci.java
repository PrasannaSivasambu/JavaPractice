import java.util.*;

 class FibonacciMemoization {
    static Map<Integer, Integer> memo = new HashMap<>();

    public static int fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n); // Return cached result

        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result); // Store result
        System.out.println(memo);
        return result;
    }

   
}




public class DynamicProgrammingFibanacci {
    public static void main(String[] args) {
        System.out.println(FibonacciMemoization.fib(10));
    }
    
}
