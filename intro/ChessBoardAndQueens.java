import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessBoardAndQueens {
    public static void main(String[] args) throws IOException {
        char[][] grid = new char[8][8];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0;i<8;i++){
            grid[i] = bufferedReader.readLine().toCharArray();
        }
        System.out.println(solve(grid, 0, 0, 0, 0, 0));
    }

    private static boolean collision(int x, int y, int row, int col, int primaryDiagonal, int secDiagonal){
        return (row & (1 << x)) != 0 || (col & (1 << y)) != 0 ||
                (primaryDiagonal & (1 << (x + y))) != 0 || (secDiagonal & (1 << (x - y + 8))) != 0;
    }
    private static int solve(char[][] grid, int i, int row, int col, int primaryDiagonal, int secDiagonal){
        if (i >= 8) return 1;

        int res = 0;
        for(int j=0;j<8;j++){
            if(grid[i][j] == '*' || collision(i, j, row, col, primaryDiagonal, secDiagonal)) continue;
                // hash
            row |= (1<<i); col |= (1<<j);
            primaryDiagonal |= (1<<(i+j));
            secDiagonal |= (1<< (i-j+8));

            res += solve(grid, i + 1, row, col, primaryDiagonal, secDiagonal);
            // unhash
            row ^= (1<<i); col ^= (1<<j);
            primaryDiagonal ^= (1<<(i+j));
            secDiagonal ^= (1<< (i-j+8));
        }
        return res;
    }
}

/**
 * ........
 * ..*.....
 * ........
 * ........
 * .....**.
 * ...*....
 * ........
 */
