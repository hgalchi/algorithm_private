import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int N = info.length;
        int INF = Integer.MAX_VALUE / 2; // overflow 방지
        
        // dp[i][a] = i번째 물건까지 고려했을 때,
        // A 흔적이 a일 때 B의 최소 흔적
        int[][] dp = new int[N + 1][n];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0; // 초기 상태: 아직 물건 없음, 흔적 0
        
        for (int i = 0; i < N; i++) {
            int a_i = info[i][0];
            int b_i = info[i][1];
            
            for (int a = 0; a < n; a++) {
                if (dp[i][a] == INF) continue; // 불가능한 상태는 건너뛰기
                
                // 1) A가 i번째 물건 훔치는 경우
                int newA = a + a_i;
                if (newA < n) {
                    dp[i + 1][newA] = Math.min(dp[i + 1][newA], dp[i][a]);
                }
                
                // 2) B가 i번째 물건 훔치는 경우
                int newB = dp[i][a] + b_i;
                if (newB < m) {
                    dp[i + 1][a] = Math.min(dp[i + 1][a], newB);
                }
            }
        }
        
        // 마지막 상태에서 A 흔적 최소값 찾기
        int answer = INF;
        for (int a = 0; a < n; a++) {
            if (dp[N][a] < m) {
                answer = Math.min(answer, a);
            }
        }
        
        return answer == INF ? -1 : answer;
    }
}
