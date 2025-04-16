import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int INF = 10_000_000;
        int[][] map = new int[N+1][N+1];

        // 초기값 세팅
        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0; // 자기 자신까지의 거리는 0
        }

        for (int[] edge : road) {
            int s = edge[0];
            int e = edge[1];
            int cost = edge[2];

            map[s][e] = Math.min(map[s][e], cost);
            map[e][s] = Math.min(map[e][s], cost);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][k] != INF && map[k][j] != INF) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (map[1][i] <= K) {
                answer++;
            }
        }
        return answer;
    }
}
