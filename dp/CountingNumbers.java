import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingNumbers {
    private static long[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        long l = Long.parseLong(stringTokenizer.nextToken());
        long r = Long.parseLong(stringTokenizer.nextToken());
        System.out.println(solve(r) - solve(l-1));
    }
    private static long solve(long n){
        if(n<0) return 0;
        String s = String.valueOf(n);
        int slen = s.length();
        dp = new long[slen+1][2][11]; // index, tight, last digit
        for(int i=0;i<=slen;i++){
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return dfs(0, 1, -1, s);
    }
    private static long dfs(int index, int bound, int prev, String s){
        if(index>=s.length()) return 1;
        if(dp[index][bound][prev + 1] != -1) return dp[index][bound][prev+1];

        int limit = bound == 1 ? s.charAt(index) - '0' : 9;
        long res = 0;
        for(int i=0;i<=limit;i++){
            if(prev>=0 && i==prev) continue;
            int nextBound = bound == 1 && i == limit ? 1 : 0;
            res += dfs(index+1, nextBound, i == 0 && prev <0 ? prev : i, s);
        }
        return dp[index][bound][prev+1] = res;
    }
}
