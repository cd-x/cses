import java.util.*;

public class MinimalGridPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] grid = new String[n];
        for(int i=0;i<n;i++){
            grid[i] = scanner.next();
        }
        System.out.println(solveOptimized(n, grid));
    }


    private static String solveOptimized(int n, String[] grid){
        int[][] direction = {{0,1}, {1,0}};
        boolean[][] vis = new boolean[n][n];
        StringBuilder sb = new StringBuilder(); sb.append(grid[0].charAt(0));
        Queue<Integer> cur = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();
        cur.add(0);
        vis[0][0] = true;

        for(int level=1;level<2*n-1;level++){
            char min = 'Z' + 1;
            while (!cur.isEmpty()){
                int tmp = cur.poll();
                int i = tmp/n, j = tmp%n;
                for (int[] d : direction){
                    int ni = i + d[0], nj = j + d[1];
                    if(ni<n && nj < n){
                        if(grid[ni].charAt(nj) <= min){
                            if(grid[ni].charAt(nj) < min) next.clear();
                            if(!vis[ni][nj]){
                                next.add(ni*n + nj);
                                vis[ni][nj] = true;
                            }
                            min = grid[ni].charAt(nj);
                        }
                    }
                }
            }
            if(!next.isEmpty()) sb.append(min);
            Queue<Integer> hold = cur;
            cur = next;
            next = hold;
        }
        return sb.toString();
    }
}
