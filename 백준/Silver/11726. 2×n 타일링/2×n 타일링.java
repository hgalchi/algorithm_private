import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
int[] dp = new int[N + 1];
dp[0] = 1;
for (int i = 0; i <= N; i++) {
    if (i + 1 <= N) dp[i + 1] = (dp[i + 1] + dp[i]) % 10007;
    if (i + 2 <= N) dp[i + 2] = (dp[i + 2] + dp[i]) % 10007;
}
System.out.println(dp[N]);

        

    }




}