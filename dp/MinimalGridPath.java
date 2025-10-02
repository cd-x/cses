import java.io.*;
import java.util.*;

public class MinimalGridPath {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = readByte()) != -1 && (c <= ' ')) ;
            if (c == -1) return null;
            sb.append((char) c);
            while ((c = readByte()) != -1 && c > ' ') sb.append((char) c);
            return sb.toString();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(grid[0][0]);

        // frontier arrays (store i-coordinates only)
        int[] front = new int[n];
        int[] next = new int[n];
        int frontSize = 1;
        front[0] = 0;

        boolean[] mark = new boolean[n]; // used for deduplication

        int maxDiag = 2 * n - 2;
        for (int d = 1; d <= maxDiag; d++) {
            char minChar = 'Z' + 1;

            // 1. find minimum char among next moves
            for (int idx = 0; idx < frontSize; idx++) {
                int i = front[idx];
                int j = (d - 1) - i;
                if (i + 1 < n) {
                    char c = grid[i + 1][j];
                    if (c < minChar) minChar = c;
                }
                if (j + 1 < n) {
                    char c = grid[i][j + 1];
                    if (c < minChar) minChar = c;
                }
            }
            sb.append(minChar);

            // 2. build next frontier, dedup using mark[]
            int newSize = 0;
            for (int idx = 0; idx < frontSize; idx++) {
                int i = front[idx];
                int j = (d - 1) - i;
                if (i + 1 < n && grid[i + 1][j] == minChar && !mark[i + 1]) {
                    mark[i + 1] = true;
                    next[newSize++] = i + 1;
                }
                if (j + 1 < n && grid[i][j + 1] == minChar && !mark[i]) {
                    mark[i] = true;
                    next[newSize++] = i;
                }
            }

            // 3. reset mark[]
            for (int k = 0; k < newSize; k++) {
                mark[next[k]] = false;
            }

            // swap
            int[] tmp = front;
            front = next;
            next = tmp;
            frontSize = newSize;
        }

        System.out.println(sb.toString());
    }
}