
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        for(int j=0;j<n;j++){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                graph[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
