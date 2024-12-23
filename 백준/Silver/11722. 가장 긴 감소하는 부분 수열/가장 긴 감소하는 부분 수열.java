
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] list = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1; // 최소 길이는 1
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신만 포함하는 경우 초기화
            for (int j = 0; j < i; j++) {
                if (list[j] > list[i]) { // 감소 조건
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]); // 최대값 갱신
        }

        System.out.println(max);
    }
}
