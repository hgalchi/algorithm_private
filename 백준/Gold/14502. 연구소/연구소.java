
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static List<int[]> zeroList;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        zeroList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }

        //빈칸을 3개 선택하는 경우의 수
        boolean[] visited = new boolean[zeroList.size()];
        dfs(0,0, map);
        System.out.println(max);
    }

    public static void dfs(int cur,int level, int[][] map) {
        if (level == 3) {
            getArea(map);   //3개의 벽을 세웠으면 안전영역을 계산
            return;
        }
        for (int i = cur; i < zeroList.size(); i++) {
            int[] zero = zeroList.get(i);//벽을 세울 index
            map[zero[0]][zero[1]] = 1;// 벽을 세움
            dfs(i + 1, level + 1, map);// i+1부터 탐색-? 중복 방지
            map[zero[0]][zero[1]] = 0;// 벽 복원
        }
    }

    public static void getArea(int[][] origin) {

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = origin[i].clone();
        }
        //바이러스 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j,map);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer++;
                }
            }
        }
        max = Math.max(max, answer);

    }

    public static void bfs(int row,int col,int[][] map){
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr > -1 && nr < n && nc > -1 && nc < m) {
                    if (map[nr][nc] == 0) {
                        map[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }




}