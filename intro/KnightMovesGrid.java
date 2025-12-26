import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class KnightMovesGrid {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] res = new int[n][n];
        int[] dx = {2, 2, -2,-2, 1, -1, 1, -1};
        int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        while (!q.isEmpty()){
            int size = q.size();
            while (size >0){
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], cost = cur[2];
                for(int i=0;i<8;i++){
                    int _x = x + dx[i], _y = y + dy[i];
                    if(_x <0 || _x >=n || _y<0 || _y>=n || res[_x][_y] >0 || (_x == 0 && _y == 0)) continue;
                    res[_x][_y] = cost+1;
                    q.add(new int[]{_x, _y, cost + 1});
                }
                size--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                sb.append(String.valueOf(res[i][j]));
                sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
