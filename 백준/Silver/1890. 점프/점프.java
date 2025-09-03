
import java.io.*;
import java.util.*;

public class Main {  
    
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (dp[row][col] == 0 || (row == N - 1 && col == N - 1)) continue;

                int jump = map[row][col];
                int nr = row + jump;
                int nc = col + jump;

                if (nr < N) dp[nr][col] += dp[row][col];
                if (nc < N) dp[row][nc] += dp[row][col];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
