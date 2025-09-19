import java.util.Arrays;
import java.util.Scanner;

public class CoinCombination2 {
    private static final int MOD = (int) 1e9+7;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i=0;i<n;i++){
            int tmp = sc.nextInt();
            coins[i] = tmp;
        }
        System.out.println(solve(n, x, coins));
    }

    // dp[x][i] = number of ordered distinct
    // ways to get sum as x  from i->n elements
    // transition dp[x][n] = sum{ dp[x-coins][n+1] + dp[x-coins][n+2] + ...} = suffix sum{dp[x-coins][i..n+1]}

    private static long solve(int n, int x, int[] coins){
        long[][] dp = new long[n+1][x+1];
        for(int i=0;i<n;i++) dp[i][0] = 1;

        for(int i=n-1;i>=0;i--){
            for(int sum=coins[i];sum<=x;sum++){
                // pick + skip
                dp[i][sum] = dp[i+1][sum];
                if(coins[i] <= sum){
                    dp[i][sum] = (dp[i][sum] + dp[i][sum - coins[i]])%MOD;
                }
            }
        }
        return dp[0][x]%MOD;
    }
}
