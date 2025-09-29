import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for(int i=0;i<n;i++){
            int tmp = scanner.nextInt();
            a[i] = tmp;
        }
        for(int i=0;i<m;i++){
            int tmp = scanner.nextInt();
            b[i] = tmp;
        }
        List<Integer> common = new ArrayList<>();
        int max = lcs(a, b, common);
        System.out.println(max);
        for(int x : common){
            System.out.printf("%d ", x);
        }
    }

    private static int lcs(int[] a, int[] b, List<Integer> common){
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1] == b[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i=n, j = m;
        while (i>0 && j>0){
            if(dp[i][j] == dp[i-1][j]) i--;
            else if(dp[i][j] == dp[i][j-1]) j--;
            else{
                common.add(a[i-1]);
                i--; j--;
            }
        }
        Collections.reverse(common);
        return dp[n][m];
    }
}
