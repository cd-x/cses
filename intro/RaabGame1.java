import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RaabGame1 {
    private static boolean valid(int n, int a, int b){
        if(a+b > n) return false;
        return a + b <= 0 || (a != 0 && b != 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            if(valid(n, a, b)){
                int low1 = n-a, high1 = n, low2 = n-b, high2 = n;
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                while (a>0){
                    sb1.append(high1); high1--; sb1.append(' ');
                    sb2.append(low2); low2--; sb2.append(' ');
                    a--;
                }
                while (b>0){
                    sb1.append(low1); low1--; sb1.append(' ');
                    sb2.append(high2); high2--; sb2.append(' ');
                    b--;
                }

                if(low1 == low2){
                    while (low1 >0){
                        sb1.append(low1); sb1.append(' ');
                        sb2.append(low1); sb2.append(' ');
                        low1--;
                    }
                    System.out.printf("YES\n%s\n%s\n", sb1, sb2);
                }else {
                    System.out.println("NO");
                }
            }else{
                System.out.println("NO");
            }
            t--;
        }

    }
}
