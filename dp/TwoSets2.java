import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSets2 {
    private static final int m = (int) 1e9+7;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(bufferedReader.readLine());
        System.out.println(solve(x));
    }

    private static int solve(int n){
        int target = (n*(n+1))/2;
        if(target %2 != 0) return 0;
        target = target /2;

        int[][] dp = new int[target+1][n+1];
        for(int i=0;i<=n;i++) dp[0][i] = 1;

        for(int i=1;i<=target;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(i>=j){
                    dp[i][j] = (int) ((long) dp[i][j] + dp[i-j][j-1])%m;
                }
            }
        }
        return (int)(((long) dp[target][n] * inv(2)) % m);
    }

    private static int inv(int a) {
        return a <= 1 ? a : (m - (int) ((long)(m/a) * inv(m % a)) % m);
    }
}
