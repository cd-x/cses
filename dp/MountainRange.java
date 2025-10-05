import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class MountainRange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        System.out.println(solve(n, arr));
    }
    private static int solve(int n, int[] arr){
        for(int i=0;i<n/2;i++){
            int tmp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = tmp;
        }
        return lis(arr);
    }
    private static int lis(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int x : arr){
            int index = Collections.binarySearch(list, x);
            if(index < 0) index = -(index + 1);
            if(index >= list.size()) list.add(x);
            else list.set(index, x);
        }
        return list.size();
    }
}
