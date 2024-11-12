
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int MAX=987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        //각 정점까지의 거리를 무한대로 초기화
        int[][] graph = new int[V+1][V+1];
        for (int[] row : graph) {
            Arrays.fill(row,MAX);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[row][col] = value;
        }

        //플로이드 워샬
        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    if(i==k||j==k)continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        //정점이 시작,도착 정점이 되어 값이 있는지 확인
        int Cycle = MAX;
        for (int i = 1; i < V + 1; i++) {
            Cycle = Math.min(Cycle, graph[i][i]);
        }
        System.out.println(Cycle == MAX ? -1 : Cycle);

    }

}
