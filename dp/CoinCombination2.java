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

    // dp[i][x] = number of ordered distinct
    // ways to get sum as x  from i->n elements
    // transition dp[x][n] = sum{ dp[x-coins][n+1] + dp[x-coins][n+2] + ...} = suffix sum{dp[x-coins][i..n+1]}

    private static long solve(int n, int x, int[] coins){
        long[] prev = new long[x+1];
        long[] cur = new long[x+1];
        prev[0] = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=x;j++){
                // pick + skip
                cur[j] = prev[j];
                if(coins[i] <= j){
                    cur[j] = (cur[j] + cur[j - coins[i]])%MOD;
                }
            }
//            System.out.printf("\nfor i: %d \nprev: ", i);
//            for(long y: prev) System.out.printf("%d ", y);
//            System.out.print("\ncur: ");
//            for(long y : cur) System.out.printf("%d ", y);
            if (x + 1 >= 0) System.arraycopy(cur, 0, prev, 0, x + 1);
        }
        return cur[x];
    }
}