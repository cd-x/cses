import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MoneySums {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = Arrays.stream(arr).sum();
        boolean[] dp = new boolean[sum+1];
        StringBuilder sb = new StringBuilder();
        int count = solve(n, arr, dp, sb);

        System.out.println(count);
        System.out.println(sb);
    }
    private static int solve(int n, int[] arr, boolean[] dp, StringBuilder sb){
        int count = 0;
        int maxSum = dp.length-1;
        dp[0]  = true;
        for (int i=0;i<n;i++){
            for (int j=maxSum - arr[i];j>=0; j--){
                if(dp[j] && !dp[arr[i] + j]){
                    dp[arr[i] + j]= true;
                }
            }
        }
        for (int i=1;i<=maxSum;i++){
            if(dp[i]){
                count++;
                sb.append(i).append(' ');
            }
        }
        return count;
    }
}
