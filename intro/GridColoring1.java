import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridColoring1 {
    private static final char[] arr = {'A', 'B', 'C', 'D'};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = bufferedReader.readLine().toCharArray();
        }
        boolean res = true;
        for(int i=0;i<m && res;i++){
            for(int j=0;j<n && res;j++){
                boolean filled = false;
                for(char ch : arr){
                    if(grid[i][j] == ch) continue;
                    if(i>0 && grid[i-1][j] == ch) continue;
                    if(j>0 && grid[i][j-1] == ch) continue;
                    grid[i][j] = ch;
                    filled = true;
                    break;
                }
                if(!filled) res = false;
            }
        }
        if(!res) System.out.println("IMPOSSIBLE");
        else{
            StringBuilder sb = new StringBuilder();
            for(char[] row : grid){
                for(char ch : row) sb.append(ch);
                sb.append("\n");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }
}
