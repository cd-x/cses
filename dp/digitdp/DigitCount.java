package digitdp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Problem: https://lightoj.com/problem/digit-count
 */
class DigitCount {
    private static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(reader.readLine());
        for(int t=1;t<=test;t++){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            StringTokenizer arr = new StringTokenizer(reader.readLine());
            int[] nums = new int[m];
            for(int i=0;i<m;i++){
                nums[i] = Integer.parseInt(arr.nextToken());
            }
            System.out.printf("Case %d: %d\n", t, solve(nums, n));
        }
    }
    private static int solve(int[] nums, int n){
        dp = new int[n+1][11];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, -1, n, nums);
    }
    private static int dfs(int index, int prev, int n, int[] nums){
        if(index >= n) return 1;
        if(dp[index][prev+1] != -1) return dp[index][prev+1];

        int res = 0;
        int limit = prev < 0 ? 10 : 2;
        for(int x : nums){
            if(Math.abs(prev - x) <= limit){
                res += dfs(index +1, x, n, nums);
            }
        }
        return dp[index][prev+1] = res;
    }
}
