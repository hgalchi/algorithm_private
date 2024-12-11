
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp = new int[100];
    
    public static int dfs(int cur) {

        //0과 1인 경우 1,1
        if (cur <= 1) {
            return cur;
        }
        //dp에 저장되어 있는 수가 있다면 재귀함수로 계산하지 않고 참조
        if (dp[cur] != 0) {
            return dp[cur];
        }
        //계산되어야하는 수라면 배열에 저장하고 반환
        dp[cur] = dfs(cur - 1) + dfs(cur - 2);
        return dp[cur];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = dfs(N);
        System.out.println(answer);
    }


}
