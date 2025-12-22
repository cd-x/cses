import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Projects {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] projects = new int[n][3];
        for(int i=0;i<n;i++){
            String day = bufferedReader.readLine();
            String[] vals = day.trim().split("\\s+");
            projects[i][0] = Integer.parseInt(vals[0]);
            projects[i][1] = Integer.parseInt(vals[1]);
            projects[i][2] = Integer.parseInt(vals[2]);
        }
        System.out.println(solve(projects));
    }

    private static int solve(int[][] projects){
        Arrays.sort(projects, Comparator.comparingInt((int[] d) -> d[0]).
                thenComparingInt(d -> d[1]));

        int len = projects.length;
        for(int i=0;i<len;i++){
            System.out.printf("%d %d %d\n", projects[i][0], projects[i][1], projects[i][2]);
        }
        int[][] dp = new int[len][2];
        dp[len-1][0] = projects[len-1][2];
        for(int i= len-2;i>=0;i--){
            // take
            if(projects[i][1] < projects[i+1][0]){
                dp[i][0] = projects[i][2] + Math.max(dp[i+1][0], dp[i+1][1]);
            }
            // skip
            dp[i][1] = Math.max(dp[i+1][0], dp[i+1][1]);
        }
        return Math.max(dp[0][0], dp[0][1]);
    }
}
