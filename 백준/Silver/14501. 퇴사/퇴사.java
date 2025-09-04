
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int N;
    static int max = 0;
    static int[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new int[N+1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0);
        System.out.println(max);


    }

    public static void dfs(int day, int score) {
        //퇴사일 때 비교 후 갱신
        if (day > N) {
            max = Math.max(max, score);
            return;
        }
        //소요일이 근무일 포함인 경우
        if (day + list[day][0] <= N+1) {
            //상담한다.
            dfs(day + list[day][0], score + list[day][1]);
        }
        //상담하지 않는 경우
        dfs(day + 1, score);
    }



}