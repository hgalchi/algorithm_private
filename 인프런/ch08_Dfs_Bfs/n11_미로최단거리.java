package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n11_미로최단거리 {
    static int[][] graph = new int[8][8];
    int[] disX = {0, 0, -1, 1};
    int[] disY = {1, -1, 0, 0};
    static int answer = 0;

    public int bfs(int curX, int curY) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{curX, curY});

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for(int i = 0; i < size; i++) {
                Integer[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + disX[j];
                    int y = cur[1] + disY[j];
                    if(x==7&&y==7) return answer;
                    if (x > 0 && x < 8 && y > 0 && y < 8 && graph[x][y] == 0) {
                        graph[x][y] = 1;
                        queue.add(new Integer[]{x, y});
                    }
                }

            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출발점이 1,1임으로 0,0은 사용하지 않는다.
        for (int i = 1; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<8;j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        graph[1][1] = 1;
        new n11_미로최단거리().bfs(1, 1);
        System.out.println(answer);

    }
}
