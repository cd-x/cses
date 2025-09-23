import java.util.Arrays;
import java.util.Scanner;

public class ArrayDescription {
    private static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }
        System.out.println(solve(arr, m, n));
    }


    /**
     *
     * @state: dp[i][j] : number of ways to get arrays from subarray [0..i] with number j
     * @base: depends on 1st element if non-zero set 1 otherwise all 1s
     * @transition: if arr[i] is 0 then there m ways we can select number to be placed
     * else if it is non-zero we have to take same, no way to change it.
     * @result: sum{dp[n-1]} : total ways
     */
    private static int solve(int[] arr, int m, int n){
        int res = 0;
        int[]  prev = new int[m+1];
        int[] cur = new int[m+1];

        if(arr[0] == 0){ Arrays.fill(cur, 1); cur[0] = 0; }
        else cur[arr[0]] = 1;

        for(int i = 1;i<n;i++){
            if (m + 1 >= 0) System.arraycopy(cur, 0, prev, 0, m + 1);
            if(arr[i] == 0){ Arrays.fill(cur, 1); cur[0] = 0;}
            else{ Arrays.fill(cur, 0); cur[arr[i]] = 1; }

            for(int j=1;j<=m;j++){
                cur[j] = (int) (( (long) cur[j] * ((long) prev[j - 1] + prev[j] + (j+1<=m ?prev[j+1] : 0) ) )%MOD);
            }
        }
        for(int i=1;i<=m;i++){
            res = (int) (((long) res +  cur[i])%MOD);
        }
        return res;
    }
}
