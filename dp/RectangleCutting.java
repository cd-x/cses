import java.util.Scanner;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(mincut(a,b));
    }

    /**
     * @state: dp[i][j] : minimum cuts needed to convert into squares of ixj size rectangle
     * @base: dp[i][j] = 0 , for i=j
     * @transition: dp[i][j] = min{horizontal cuts , vertical cuts}
     * vertical : min(dp[i][k] + dp[i][j-k]), k:[1..j]
     * horizontal: min(dp[k][j] + dp[i-k][j]), k:[1..i];
     * To evaluate any transition we have to evaluate sub problems first
     */
    private static int mincut(int a, int b){
        int[][] dp = new int[a+1][b+1];
        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // starting from 1,1 would evaluate smaller rectangles first which are subproblems

        for(int i=1;i<=a;i++){
            for(int j=1;j<=b;j++){
                if(i==j){
                    dp[i][j] = 0; // already a square
                }else{
                    // vertical
                    for(int k=1;k<j;k++){
                        dp[i][j] = Math.min(dp[i][k] + dp[i][j-k] + 1, dp[i][j]);
                    }
                    // horizontal
                    for(int k=1;k<i;k++){
                        dp[i][j] = Math.min(dp[k][j] + dp[i-k][j] + 1, dp[i][j]);
                    }
                }
            }
        }
        return dp[a][b];
    }
}
