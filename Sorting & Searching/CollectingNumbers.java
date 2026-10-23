import java.io.*;
import java.util.StringTokenizer;

public class CollectingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int size = Integer.parseInt(bufferedReader.readLine());
        int[] nums = new int[size+1];
        int[] index = new int[size+1];
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine(), " ");
        for(int i=1;i<=size;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            index[nums[i]] = i;
        }
        int res = solve(size, index);
        System.out.printf("%d", res);
    }
    private static int solve(int size, int[] index){
        int res= 0;

        int i=0;
        while(i<size){
            int pos = 0;
            while(i+1<=size && index[i+1] > pos){
                pos = index[i+1];
                i = i+1;
            }
            res += 1;
        }
        return res;
    }
}
