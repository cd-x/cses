import java.util.Arrays;
import java.util.Scanner;

public class GridPaths1 {
    private static final int MOD = (int) 1e9+7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read n
        int n = sc.nextInt();
        sc.nextLine(); // consume the leftover newline

        // grid representation
        char[][] grid = new char[n][n];

        // read n lines of grid
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        // check if input was read correctly (debug print)
//         for (char[] row : grid) {
//             System.out.println(Arrays.toString(row));
//         }

        sc.close();
        System.out.println(solve(grid));
    }

    private static int solve(char[][] grid){
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[n-1][n-1] = grid[n-1][n-1] == '*' ? 0 : 1;
        for(int i=n-2;i>=0;i--){
            if(grid[i][n-1] == '*') break;
            dp[i][n-1] = dp[i+1][n-1];
        }
        for(int i=n-2;i>=0;i--){
            if(grid[n-1][i] == '*') break;
            dp[n-1][i] = dp[n-1][i+1];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(grid[i][j] == '.'){
                    dp[i][j] = (int) (((long) dp[i + 1][j] + dp[i][j+1])%MOD);
                }
            }
        }
        return dp[0][0];
    }
}
