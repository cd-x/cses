import java.io.*;
import java.util.*;

public class MountainRange {
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;
        FastReader(InputStream in) { this.in = in; }
        int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, x = 0;
            while ((c = readByte()) <= ' ') if (c == -1) return -1;
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = readByte(); }
            return x * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader(System.in);
        int n = fr.nextInt();
        int[][] mountains = new int[n][2];
        for (int i = 0; i < n; i++) {
            mountains[i][0] = fr.nextInt();
            mountains[i][1] = i + 1;
        }

        Arrays.sort(mountains, (a, b) -> {
            if (b[0] != a[0]) return b[0] - a[0];
            return b[1] - a[1];
        });

        int[] dp = new int[n + 1];
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> same = new ArrayList<>();
        int lastH = Integer.MIN_VALUE;

        for (int[] m : mountains) {
            int h = m[0], idx = m[1];
            if (h != lastH) {
                set.addAll(same);
                same.clear();
            }

            Integer left = set.floor(idx);
            Integer right = set.ceiling(idx);
            int L = (left == null ? 0 : left);
            int R = (right == null ? 0 : right);
            dp[idx] = Math.max(dp[L], dp[R]) + 1;

            same.add(idx);
            lastH = h;
        }

        int ans = 0;
        for (int v : dp) ans = Math.max(ans, v);
        System.out.println(ans);
    }
}
