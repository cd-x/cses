import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(solve(n));
    }

    private static long solve(long n){
        if(n==0) return 0;
        return n/5 + solve(n/5);
    }
}
