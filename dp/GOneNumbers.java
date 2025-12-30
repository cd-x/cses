import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: https://www.spoj.com/problems/GONE/
 */

public class GOneNumbers {
    private static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int l = Integer.parseInt(stringTokenizer.nextToken());
            int r = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(solve(r) - solve(l-1));

            t--;
        }
    }

    private static int solve(int n){
        String s = String.valueOf(n);
        int slen = s.length();
        dp = new int[slen+1][2][80];
        for(int i=0;i<=slen;i++){
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return dfs(0, 1, 0, s);
    }

    private static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i<=n/2;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    private static int dfs(int i, int bound, int sum, String s){
        if(i>=s.length()) return isPrime(sum) ? 1 : 0;
        if(dp[i][bound][sum] >=0) return dp[i][bound][sum];

        int limit = bound == 1 ? s.charAt(i) - '0' : 9;
        int res = 0;
        for(int j=0;j<=limit;j++){
            int nextBound = j == limit && bound == 1 ? 1 : 0;
            res += dfs(i+1, nextBound, sum + j, s);
        }
        return dp[i][bound][sum] = res;
    }
}
