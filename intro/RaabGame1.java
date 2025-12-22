import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RaabGame1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int low1 = 1, high1 = n, low2 = 1, high2 = n;
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            boolean possible = true;
            while (a>0 && possible){
                if(high1 < low2){
                    possible = false;
                    break;
                }
                sb1.append(high1); high1--; sb1.append(' ');
                sb2.append(low2); low2--; sb2.append(' ');
                a--;
            }
            while (b>0 && possible){
                if(high2 < low1){
                    possible = false;
                    break;
                }
                sb1.append(low1); low1--; sb1.append(' ');
                sb2.append(high2); high2--; sb2.append(' ');
                b--;
            }

            if(possible){
                System.out.printf("YES\n%s\n%s", sb1, sb2);
            }else {
                System.out.println("NO");
            }
            t--;
        }

    }
}
