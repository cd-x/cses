import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPathDescription {
    private static final char[] dir = {'U', 'D', 'L', 'R'};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        boolean[][] vis = new boolean[7][7];
        System.out.println(solve(s, 0, 0,0));
    }
    private static int newX(int x, char d){
        if(d == 'U' || d == 'D') return x;
        else if(d=='L') return x-1;
        else return x+1;
    }
    private static int newY(int y, char d){
        if(d == 'L' || d == 'R') return y;
        else if(d=='U') return y-1;
        else return y+1;
    }
    private static int solve(String s, int i, int x, int y){
        if(x<0 || x>=7 || y<0 || y>=7 || i>=s.length()) return 0;
        if(x==0 && y==6) return i==48 ? 1 : 0;

        int res = 0;
        if(s.charAt(i) == '?'){
            for(char d : dir) res += solve(s, i+1, newX(x, d), newY(y, d));
        }else {
            res += solve(s, i+1, newX(x, s.charAt(i)), newY(y, s.charAt(i)));
        }
        return res;
    }
}
