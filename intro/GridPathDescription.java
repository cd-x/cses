
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPathDescription {
    private static final int N = 7;
    private static final int STEPS = 48;

    private static final boolean[][] vis = new boolean[N][N];
    private static String s;

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static final char[] dir = {'U', 'D', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        s = br.readLine().trim();
        vis[0][0] = true;

        System.out.println(dfs(0, 0, 0));
    }

    private static int dfs(int step, int x, int y) {
        // Destination: bottom-left
        if (x == 6 && y == 0) {
            return step == STEPS ? 1 : 0;
        }

        if (step == STEPS) return 0;

        // FIX 1: Detect a vertical split.
        boolean upBlocked = x == 0 || vis[x - 1][y];
        boolean downBlocked = x == 6 || vis[x + 1][y];
        boolean leftBlocked = y == 0 || vis[x][y - 1];
        boolean rightBlocked = y == 6 || vis[x][y + 1];

        if (upBlocked && downBlocked &&
                !leftBlocked && !rightBlocked) {
            return 0;
        }

        // FIX 2: Detect a horizontal split.
        if (leftBlocked && rightBlocked &&
                !upBlocked && !downBlocked) {
            return 0;
        }

        char required = s.charAt(step);
        int count = 0;

        // FIX 3: Don't try directions forbidden by the input.
        for (int d = 0; d < 4; d++) {
            if (required != '?' && required != dir[d]) {
                continue;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N ||
                    ny < 0 || ny >= N ||
                    vis[nx][ny]) {
                continue;
            }

            vis[nx][ny] = true;
            count += dfs(step + 1, nx, ny);
            vis[nx][ny] = false;
        }

        return count;
    }
}
