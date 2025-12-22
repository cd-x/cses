import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CoinPiles {
    private static boolean isDivisible(long a, long b){
        /**
         * it is simple linear equation solve for x and y
         * As we can conclude that amount of 2 remove from a
         * should also be removed from b
         *  i.e. 2*x + 1*y = a, 1*x + 2*y = b
         *  solving for x and y we get
         *  x = (2a-b)/3, y = (2b-a)/3
         *  and a valid solution is only possible if x is a positive integer
         *  means numerator is positive and divisible by 3
         */
        long x = (2*a -b)/2, y = (2*b -a)/3;
        return (2*a >= b && (2*a - b)%3 == 0 && 2*b >= a && (2*b -a)%3 == 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while(t>0){
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());
            if(isDivisible(a,b)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
            t--;
        }
    }
}
