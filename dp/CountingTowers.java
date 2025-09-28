import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingTowers {
    private static final int mod = (int) 1e9 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(solve(n)).append("\n");
        }
        System.out.print(sb);
    }


    /**
     * @state: dp[i][0] : number of ways to construct tiles with 1..i cells if we start a horizontal cell at i + 1
     * dp[i][1] : number of ways to construct tiles with 1..i if we start vertical cell at i + 1
     * @basecase : dp[i][0] = 1, dp[i][1] = 1
     * @transition: dp[i][0] = 2* dp[i-1][0] + dp[i-1][1]
     * dp[i][1] = 4*dp[i-1][1] + dp[i-1][0]
     * @result: dp[n][0] + dp[n][1];
     */
    private static int solve(int n){
        int p1 = 0, p2 = 0;
        int c1 = 1, c2 = 1;
        for(int i=1;i<n;i++){
            p1 = c1; p2 = c2;
            c1 = (int) ((2L*p1 + p2)%mod);
            c2 = (int) ((4L*p2 + p1)%mod);
        }
        return (int) ((1L*c1 + c2)%mod);
    }
}
