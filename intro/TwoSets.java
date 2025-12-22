import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        long sum = ((long) n * (n + 1))/2;
        long halfSum = sum/2;
        StringBuilder set1 = new StringBuilder();
        StringBuilder set2 = new StringBuilder();
        int size = 0;
        for(int i=n;i>0;i--){
            if(halfSum >= i){
                halfSum -= i; size++;
                set1.append(String.valueOf(i));
                set1.append(" ");
            }else{
                set2.append(String.valueOf(i));
                set2.append(" ");
            }
        }
        if(sum%2 != 0 || halfSum > 0){
            System.out.println("NO");
        }else{
            System.out.printf("YES\n%d\n%s\n%d\n%s", size, set1, n-size, set2);
        }
    }
}
