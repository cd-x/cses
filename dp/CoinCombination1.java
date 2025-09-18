import java.util.Scanner;

public class CoinCombination1 {
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

    private static int solve(int n, int x, int[] coins){
        int[] dp = new int[x+1];
        dp[0] = 1;
        for(int i=1;i<=x;i++){
            for(int j=0;j<n;j++){
                if(coins[j] <= i){
                    dp[i] = (int) (((long) dp[i] + dp[i-coins[j]])%MOD);
                }
            }
        }
        return dp[x];
    }
}
