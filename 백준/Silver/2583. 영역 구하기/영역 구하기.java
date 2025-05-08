import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<Integer> areaList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        visited = new boolean[M][N];

        // 사각형 칠하기
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    map[y][x] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    int area = dfs(i, j);
                    areaList.add(area);
                }
            }
        }

        Collections.sort(areaList);
        System.out.println(areaList.size());
        for (int a : areaList) {
            System.out.print(a + " ");
        }
    }

    static int dfs(int y, int x) {
        visited[y][x] = true;
        int count = 1;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                if (!visited[ny][nx] && !map[ny][nx]) {
                    count += dfs(ny, nx);
                }
            }
        }

        return count;
    }
}
