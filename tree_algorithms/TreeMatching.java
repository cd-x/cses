import java.io.*;
import java.util.*;

public class TreeMatching {
    static List<Integer>[] tree;
    static int[][] dp;
    static int[] parent;
    static int[] order;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[n + 1][2];
        parent = new int[n + 1];
        order = new int[n];

        // Build DFS order iteratively
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        parent[1] = -1;

        int idx = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            order[idx++] = u;
            for (int v : tree[u]) {
                if (v == parent[u]) continue;
                parent[v] = u;
                stack.push(v);
            }
        }

        // Process nodes in reverse order (postorder)
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            int sum = 0;
            int bestGain = 0;

            for (int v : tree[u]) {
                if (v == parent[u]) continue;
                int bestChild = Math.max(dp[v][0], dp[v][1]);
                sum += bestChild;
                bestGain = Math.max(bestGain, 1 + dp[v][0] - bestChild);
            }

            dp[u][0] = sum;
            dp[u][1] = sum + bestGain;
        }

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
