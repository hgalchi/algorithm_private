
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] color = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][3];
        for (int i = 0; i < dp.length; i++) {

            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < color[0].length; i++) {
            dp[0][i] = color[0][i];
        }

        for (int i = 0; i < color.length-1; i++) {
            for (int j = 0; j < color[0].length; j++) {
                for (int k = 0; k < color[0].length; k++) {
                    if (j != k) {
                        dp[i + 1][k] = Math.min(dp[i][j] + color[i + 1][k], dp[i + 1][k]);
                    }
                }
            }
        }
        Long min = Long.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        System.out.println(min);

    }




}