import java.util.Scanner;

class DiceCombination {
    private static final int mod = (int) 1e9+7;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int res = solve(n);
        //System.out.println(res);
        System.out.println(solvedp(n));
    }

    private static int solvedp(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=6;j++){
                if(j<=i){
                    dp[i] = (int) (((long) dp[i] + dp[i-j])%mod);
                }
            }
        }
        return dp[n]%mod;
    }

//    private static int solve(int n){
//        if(n<=1) return 1;
//        int res = 0;
//        for(int i=1;i<=6;i++){
//            if(i<=n){
//                res += solve(n-i);
//            }
//        }
//        return res;
//    }
}