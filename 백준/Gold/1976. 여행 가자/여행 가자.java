
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[] list;
    static String result="NO";
    static int N,M;

    public static void dfs(int cur, int level) {
        if (level == M) {
            result = "YES";
            return;
        }
        for (int i=1;i<N+1;i++) {
            if (i == list[level]&&map[cur][i]==1) {
                dfs(i, level + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        list = new int[M];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            list[i] = v;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (i == j) {
                        map[i][j] = 1;
                    }
                    if (map[i][k] == 1 && map[k][j] == 1 && map[i][j] == 0) {
                        map[i][j] = 1;
                    }
                }
            }
        }

        dfs(list[0], 1);
        System.out.println(result);
    }

}
