
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static List<List<Integer>> graph;
    static int N;
    static String[][] map;
    static int[] xdist = {0, 0, 1, -1};
    static int[] ydist = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countArea()).append(" ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("R")) {
                    map[i][j] = "G";
                }
            }
        }

        sb.append(countArea());
        System.out.println(sb);

    }

    public static int countArea(){
        visited = new boolean[N][N];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i,j);
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void bfs(int startx,int starty){
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{startx, starty});
        visited[startx][startx] = true;
        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int row = cur[0];
            int col = cur[1];
            String color = map[row][col];
            for (int i = 0; i < 4; i++) {
                int next_row = row + ydist[i];
                int next_col = col + xdist[i];
                if (next_row < map.length && next_col < map[0].length && next_row > -1 && next_col > -1
                        && map[next_row][next_col].equals(color)&&!visited[next_row][next_col] ){
                    visited[next_row][next_col] = true;
                    q.add(new Integer[]{next_row, next_col});
                }
            }
        }
    }
}
