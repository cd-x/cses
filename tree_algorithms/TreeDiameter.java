import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDiameter {
    private static List<Integer>[] tree;
    private static int res = 0;
    public static void main(String[] args) throws IOException {
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
        dfs(1, 0);
        System.out.println(res-1);
    }

    private static int dfs(int root, int par){
        int max1 = 0, max2 = 0;
        for(int child : tree[root]) {
            if(child == par) continue;
            int d = dfs(child, root);
            if(d > max2) {
                max1 = max2;
                max2 = d;
            } else if(d > max1) {
                max1 = d;
            }
        }
        res = Math.max(res, max1 + max2 + 1);  // Edge count
        return max2 + 1;
    }
}
