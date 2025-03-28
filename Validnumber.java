import java.util.concurrent.CompletableFuture;

class Solution {
    public boolean isNumber(String s) {
        return true;
    }
}

public class Validnumber {
    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> n= CompletableFuture.runAsync(()->System.out.println("l"));

        CompletableFuture<Integer> b=CompletableFuture.supplyAsync(()->{
            System.out.println("loolly");
            return 100;
        });

        System.out.println("hello");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);

// Transform result
CompletableFuture<String> transformedFuture = future.thenApply(result -> "Result: " + (result * 2));

// Consume result
future.thenAccept(result -> System.out.println("Received: " + result));

// Run a new task ignoring the result
future.thenRun(() -> System.out.println("Task complete!"));
       
       
        
    }
}
