
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rain= 0;
    static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        StringTokenizer st;
        int max = 0;
        int min = 987654321;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                min = Math.min(min, x);
                max = Math.max(max, x);
                map[i][j] = x;
            }
        }

        int answer = 0;
        for (int k = min; k <= max; k++) {
            rain = k;
            int count = 0;
            boolean[][] visited = new boolean[N][N];

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (map[row][col] >= rain && !visited[row][col]) {
                        dfs(new int[]{row, col}, visited, map);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static int[] rdir = {1, -1, 0, 0};
    static int[] cdir = {0, 0, -1, 1};

    private static void dfs(int[] cur, boolean[][] visited, int[][] map) {
        visited[cur[0]][cur[1]] = true;
        for(int i=0;i<4;i++){
            int row = cur[0] + rdir[i];
            int col = cur[1] + cdir[i];
            if(row>=0&&row<N&&col>=0&&col<N
                    &&!visited[row][col]&&map[row][col]>=rain){
                dfs(new int[]{row, col}, visited, map);
            }

        }
    }
}