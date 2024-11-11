
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    int areaSize  = 0;
                    Deque<int[]> dq = new LinkedList<>();
                    dq.add(new int[]{i, j});
                    map[i][j] = 0;

                    //dfs로 접근할 수 있는 모든 행을 탐색한다.
                    while (!dq.isEmpty()) {
                        int[] current=dq.poll();
                        areaSize++;
                        // 상하좌우 탐색 bfs
                        for (int k = 0; k < 4; k++) {
                            int row = current[0] + dr[k];
                            int col = current[1] + dc[k];
                            if (row < N && row >= 0 && col < N && col >= 0 && map[row][col] == 1) {
                                dq.add(new int[]{row, col});
                                map[row][col] = 0;
                            }
                        }
                    }
                    list.add(areaSize);
                }
            }
        }

        StringBuilder st = new StringBuilder();
        st.append(list.size()).append("\n");
        list.sort(Integer::compareTo);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                st.append(list.get(i)).append("\n");
            }
        }

        System.out.println(st);

    }

}
