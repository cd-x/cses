import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int distance = dist(s1, s2);
        System.out.println(distance);
    }


    /**
     * @state: dp[i][j]: minimum distance required to convert s1[0..i] to s2[0..j]
     * @base: dp[i][0] = i, dp[0][j] = j, to build s from empty is len(s)
     * @transition: dp[i][j] = min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1 if no match
     * dp[i][j] = dp[i-1][j-1]  if match
     * @result: dp[n][m]
     */
    private static int dist(String s1, String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) dp[i][0] = i;
        for(int i=0;i<=l2;i++) dp[0][i] = i;
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
            }
        }
        return dp[l1][l2];
    }
}
