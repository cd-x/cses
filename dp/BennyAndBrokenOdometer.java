import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Problem: https://www.hackerearth.com/problem/algorithm/benny-and-the-broken-odometer/
 */
public class BennyAndBrokenOdometer {
    private static int[][][] dp;
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());                // Reading input from STDIN
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(n-solve(n));
            t--;
        }
    }

    private static int solve(int n){
        String s = String.valueOf(n);
        int slen = s.length();
        dp = new int[slen+1][2][3];
        for(int i=0;i<=slen;i++){
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return dfs(0, 1, 0, s);
    }

    private static int dfs(int i, int bound, int has3, String s){
        if(i>=s.length()) return has3;
        if(dp[i][bound][has3] >= 0) return dp[i][bound][has3];

        int limit = bound == 1 ? s.charAt(i) -'0' : 9;
        int res = 0;
        for(int j=0;j<=limit;j++){
            int nextBound = j == limit && bound == 1 ? 1:0;
            res += dfs(i+1, nextBound, (j==3 || has3==1 ? 1 : 0), s);
        }
        return dp[i][bound][has3] = res;
    }
}
