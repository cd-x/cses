import java.util.Arrays;
import java.util.Scanner;

public class RemovingDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int num = i;
            while (num > 0){
                if(num%10 >0){
                    dp[i] = Math.min(dp[i], dp[i - (num%10)] + 1);
                }
                num /=10;
            }
        }
        return dp[n];
    }
}
