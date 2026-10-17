import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReorder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String s = reader.readLine();
        int len = s.length();

        int[] count = new int[26];

        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'A']++;
        }

        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }

        if (max > (len + 1) / 2) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        int last = -1;

        for (int i = 0; i < len; i++) {
            boolean placed = false;

            for (int j = 0; j < 26; j++) {
                if (count[j] == 0 || j == last) {
                    continue;
                }

                count[j]--;

                int remaining = len - i - 1;
                int maxFreq = 0;

                for (int k = 0; k < 26; k++) {
                    maxFreq = Math.max(maxFreq, count[k]);
                }

                // The next position cannot contain the chosen character.
                int limit = (remaining + 1) / 2;

                if (count[j] > remaining / 2) {
                    count[j]++;
                    continue;
                }

                if (maxFreq <= limit) {
                    sb.append((char) ('A' + j));
                    last = j;
                    placed = true;
                    break;
                }

                count[j]++;
            }

            if (!placed) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(sb);
    }
}