class Factorial{

    int calculate1(int n){

        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1; i<n; i++){
            dp[i] = (i+1) * dp[i-1];
            System.out.println(i);
        }
        return dp[n-1];
    }
    int calculate2(int n){

        int dp[]=new int[n];
        dp[n-1]=n;
        for(int i=n-2; i>=0; i--){
            dp[i] = (i+1) * dp[i+1];
            System.out.println(i);
        }
        return dp[0];
    }

    int[] dp = new int[1000];  // Cache
    
    int factorialDP(int n) {
        System.out.println(dp[100]);
        if (n == 0 || n == 1) return 1;
        if (dp[n] != 0) return dp[n];  // Use precomputed value
        return dp[n] = n * factorialDP(n - 1);
    }


}

public class factrialDP {

    public static void main(String[] args) {
        
        Factorial f=new Factorial();
        System.out.println(f.factorialDP(7));
    }
    
}
