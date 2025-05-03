import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            // 덩어리 개수 세기
            visited = new boolean[N][M];
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j] && map[i][j] > 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if (count >= 2) {
                System.out.println(year);
                return;
            }

            if (count == 0) {
                System.out.println(0);
                return;
            }

            melt();
            year++;
        }
    }

    // DFS로 빙산 하나 탐색
    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && map[nx][ny] > 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    // 빙산 녹이기
    private static void melt() {
        int[][] temp = new int[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] > 0) {
                    int sea = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                            sea++;
                        }
                    }
                    temp[x][y] = Math.max(0, map[x][y] - sea);
                }
            }
        }

        // map 갱신
        for (int i = 0; i < N; i++) {
            System.arraycopy(temp[i], 0, map[i], 0, M);
        }
    }
}
