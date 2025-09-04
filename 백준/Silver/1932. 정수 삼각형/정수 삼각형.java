
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            int j = 1;
            for (String n : br.readLine().split(" ")) {
                map[i][j++] = Integer.parseInt(n);
            }
        }

        long[][] dp = new long[N + 1][N + 1];
        dp[1][1] = map[1][1];
        for (int row = 1; row < N ; row++) {
            for (int col = 1; col < row + 1; col++) {
                dp[row + 1][col] = Math.max(dp[row][col] + map[row + 1][col], dp[row + 1][col]);
                dp[row + 1][col + 1] = Math.max(dp[row][col] + map[row + 1][col + 1], dp[row + 1][col + 1]);;
            }
        }

        long max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, dp[N][i]);
        }
        System.out.println(max);

    }




}