
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph;
    static int edge=0;
    static boolean[] visited;

    static void dfs(int cur, int level) {
        //간선의 개수가 하나이고 간선으로 연결된 노드가 이미 탐색되었다면
        if (graph.get(cur).size() == 1 && visited[graph.get(cur).get(0)]) {
            //System.out.println(cur + ":" + level);
            edge += level;
        } else {
            for (int n : graph.get(cur)) {
                if (!visited[n]) {
                    visited[n] = true;
                    dfs(n, level + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph= new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[1] = true;
        dfs(1, 0);

        //System.out.println(edge);
        System.out.println(edge % 2 == 0 ?"No":"Yes");
    }

}
