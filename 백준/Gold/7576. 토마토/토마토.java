
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N;
    static int M;
    static int[][] map;
    static int minDays=0;

    static Queue<Tomato> q = new LinkedList<>();

    public static class Tomato{
        int row;
        int col;
        int days;

        public  Tomato(int row, int col, int days) {
            this.row = row;
            this.col = col;
            this.days = days;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        //열
        M = Integer.parseInt(st.nextToken());
        //행
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 익은 토마토를 q에 삽입
                if (map[i][j] == 1) {
                    q.offer(new Tomato(i, j, 0));
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println("-1");
                    return ;
                }
            }
        }
        System.out.println(minDays);
    }

    public static void bfs() {
        //q의 익은 토마토를
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            minDays = cur.days;
            for (int i = 0; i < 4; i++) {
                int row = cur.row + dr[i];
                int col = cur.col + dc[i];
                if (row < N && row >= 0 && col < M && col >= 0 && map[row][col] == 0) {
                    map[row][col] = 1;
                    q.offer(new Tomato(row, col, cur.days + 1));
                }
            }
        }
    }


}
