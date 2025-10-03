import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RemovalGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(n, arr));
    }

    private static long solve(int n, int[] arr){
        long[][] dp = new long[n][n];

        for(int i=n-1;i>=0;i--){
            for(int j= i;j<n;j++){
                long pickLeft = arr[i] + Math.min(i+2<n ? dp[i+2][j] : 0, i+1<n && j>=1 ? dp[i+1][j-1] : 0);
                long pickRight = arr[j] + Math.min(i+1<n && j>=1 ? dp[i+1][j-1] : 0, j-2>=0 ? dp[i][j-2] : 0);
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][n-1];
    }
}
