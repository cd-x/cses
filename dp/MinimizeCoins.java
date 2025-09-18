import java.util.Arrays;
import java.util.Scanner;

public class MinimizeCoins {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            int cur=  sc.nextInt();
            coins[i] = cur;
        }
        System.out.println(solve(n, x, coins));
    }

    /**
     *
     * @param n
     * @param x
     * @param coins
     * @return minimum coins
     * @description dp[n] = minimum number of coins to get sum n
     * state = dp[n-coins[i]]
     * transition: dp[n] = min(dp[n-coins[i]+1)
     * base: dp[0] = 0;
     */
    private static int solve(int n, int x, int[] coins){
        long[] dp = new long[x+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        for(int i= 1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        return dp[x] >= (long) Integer.MAX_VALUE ? -1 : (int) dp[x];
    }
}
