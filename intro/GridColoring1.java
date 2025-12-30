import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridColoring1 {
    private static final char[] arr = {'A', 'B', 'C', 'D'};
    private static final int[] dir = {0,1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        char[][] grid = new char[n][m];
        char[][] res = new char[n][m];

        for (int i=0;i<n;i++){
            grid[i] = bufferedReader.readLine().toCharArray();
            for(int j=0;j<n;j++) res[i][j] = '*';
        }

        if(solve(grid, res, 0,0)){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    sb.append(res[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
    private static boolean solve(char[][] grid, char[][] res, int i, int j){
        int n = grid.length, m = grid[0].length;
        if(i<0 || i>= n || j<0 || j>=m || res[i][j] != '*') return true;

        for (char ch : arr){
            boolean duplicate = ch == grid[i][j];
            for(int d = 0;d<4 && !duplicate;d++){
                int x = i+dir[d], y = j+dir[d+1];
                if(x<0 || x>=n || y<0 | y>=m) continue;
                if (res[x][y] == ch) {
                    duplicate = true;
                    break;
                }
            }
            if(!duplicate){
                res[i][j] = ch;
                boolean possible = true;
                for(int d=0;d<4;d++) {
                    if(!solve(grid, res, i+dir[d], j+dir[d+1])){
                        possible = false;
                        break;
                    }
                }
                if(!possible){
                    res[i][j] = '*';
                }
            }
        }
        return false;
    }
}
