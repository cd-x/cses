import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem: https://codeforces.com/problemset/problem/1036/C
 */
public class Code1036{
    private static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while(t>0){
            StringTokenizer token = new StringTokenizer(reader.readLine());
            long l = Long.parseLong(token.nextToken());
            long r = Long.parseLong(token.nextToken());
            System.out.println(solve(r) - solve(l-1));
            t--;
        }
    }
    private static int solve(long n){
        String s = String.valueOf(n);
        int slen = s.length();
        dp = new int[slen+1][2][4];
        for(int i=0;i<=slen;i++){
            Arrays.fill(dp[i][0],-1);
            Arrays.fill(dp[i][1], -1);
        }
        return dfs(0, 1, 0, s);
    }
    private static int dfs(int i, int bound, int count, String s){
        if(i>=s.length() || count >3) return count <= 3 ? 1 : 0;
        if(dp[i][bound][count] >=0) return dp[i][bound][count];

        int limit = bound == 1? s.charAt(i) - '0' : 9;
        int res = 0;
        for(int j=0;j<=limit;j++){
            int isBound = j==limit && bound == 1 ? 1 : 0;
            res += dfs(i+1, isBound, count + (j>0 ? 1 : 0), s);
        }
        return dp[i][bound][count] = res;
    }
}