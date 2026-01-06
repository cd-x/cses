package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HumongousTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] l = new int[n+1];
            int[] r = new int[n+1];
            List<Integer>[] tree = new ArrayList[n+1];
            for(int i=1;i<=n;i++){
                tree[i] = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                l[i] = Integer.parseInt(st.nextToken());
                r[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<n-1;i++){
                StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                tree[u].add(v);
                tree[v].add(u);
            }
            System.out.println(solve(tree, l, r));
            t--;
        }
    }

    private static long solve(List<Integer>[] tree, int[] l, int[] r){
        int len = tree.length;
        long[][] dp = new long[len][2];
        dfs(tree, l, r, dp, 1, 0);
        return Math.max(dp[1][0], dp[1][1]);
    }
    private static void dfs(List<Integer>[] tree, int[] l, int[] r, long[][] dp, int root, int par){
        for (Integer nbr : tree[root]){
            if(nbr == par) continue;
            dfs(tree, l, r, dp, nbr, root);
            dp[root][0] += Math.max(dp[nbr][0] + Math.abs(l[root] - l[nbr]), dp[nbr][1] + Math.abs(l[root] - r[nbr]));
            dp[root][1] += Math.max(dp[nbr][0] + Math.abs(r[root] - l[nbr]), dp[nbr][1] + Math.abs(r[root] - r[nbr]));
        }
    }
}
