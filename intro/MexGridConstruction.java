import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MexGridConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] res = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Set<Integer> set = new HashSet<>();
                for(int k = i-1;k>=0;k--) set.add(res[k][j]);
                for(int k = j-1;k>=0;k--) set.add(res[i][k]);

                int x = 0;
                while (set.contains(x)) x++;
                res[i][j] = x;
                System.out.printf("%d ", x);
            }
            System.out.println();
        }
    }
}
