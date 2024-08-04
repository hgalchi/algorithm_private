package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10_미로_탐색 {
    static int[][] graph = new int[8][8];
    //상하좌우
    int[] disX = {1, -1, 0, 0};
    int[] disY = {0, 0, -1, 1};
    static int answer = 0;

    public void dfs(int curX, int curY) {
        //도착지에 도달하면 answer++
        if(curX==7 && curY==7) {
            answer++;
        }else{
            //상하좌우 탐색이 가능한 위치로 전진
            for (int i = 0; i < 4; i++) {
                int x = curX + disX[i];
                int y = curY + disY[i] ;
                if (x > 0 && x <= 7 && y > 0 && y <= 7 && graph[x][y] == 0) {
                    //재방문을 방지하기 위해서 - 왔던 길을 다시 감
                    graph[x][y] = 1;
                    dfs(x, y);
                    //모두 탐색하고 다른 길로 탐색하기 위해
                    graph[x][y] = 0;
                }
            }
        }
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
        graph[1][1]=1;
        new n10_미로_탐색().dfs(1, 1);
        System.out.println(answer);
    }
}
