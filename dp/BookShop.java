import java.util.Arrays;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];

        for (int i=0;i<n;i++) prices[i] = sc.nextInt();
        for (int i=0;i<n;i++) pages[i] = sc.nextInt();
        System.out.println(solve(prices, pages, x));
    }

    /**
     * @state: dp[i][x] : maximum number of pages bought with x amount
     * and i->N books available
     * @basecase: dp[N+1][xi] = 0 : with no books available to pick
     * total pages bought will be zero
     * @transition: dp[i][x] = Max(take, skip)
     * @result: dp[0][Total]
     */
    private static int solve(int[] prices, int[] pages, int x){
        int n = pages.length;
        int[] prev = new int[x+1];
        int[] cur = new int[x+1];
        for(int i=n-1;i>=0;i--){
            for(int j=x;j>=0;j--){
                cur[j] = prev[j];
                if(prices[i] <= j){
                    cur[j] = Math.max(cur[j], pages[i] + prev[j-prices[i]]);
                }
            }
            System.arraycopy(cur, 0, prev, 0, x + 1);
        }
        return cur[x];
    }
}
