
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] bag = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[N+1][K+1];
        for (int i = 0; i < N; i++) {
            int w = bag[i][0];
            int v = bag[i][1];
            for (int cur = 0; cur <= K; cur++) {
                //선택하지 않는 경우
                dp[i + 1][cur] = Math.max(dp[i + 1][cur], dp[i][cur]);
                //선택하는 경우
                if (cur + w <= K) {
                    dp[i + 1][cur + w] = Math.max(dp[i + 1][cur + w], dp[i][cur] + v);
                }
            }
        }

        long max = 0;
        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(max, dp[dp.length - 1][i]);
        }
        System.out.println(max);
    }




}