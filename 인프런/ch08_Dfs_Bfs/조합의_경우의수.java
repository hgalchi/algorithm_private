package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합의_경우의수 {
    int[][] visited = new int[34][34];

    public int dfs(int n, int r) {
        if (r == n || r == 0) {
            return 1;
        }
        //방문한 노드인 경우
        if (visited[n][r] != 0) {
            return visited[n][r];
        //방문하지 않은 경우 탐색, 저장하고 반환
        } else {
            return visited[n][r]=dfs(n - 1, r) + dfs(n - 1, r - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //모든 경우의 수를 탐색해야하는 경우 dfs
        int answer = new 조합의_경우의수().dfs(n, r);
        System.out.println(answer);
    }
}

