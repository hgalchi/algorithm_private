
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int[] result;
    static int level = 0;

    public static void dfs(int cur) {
        if (!visited[cur]) {
            visited[cur] = true;
            result[cur - 1] = ++level;

            //해당 정정에서 탐색가능한 노드를 내림차순으로 정렬
            Collections.sort(graph.get(cur), Collections.reverseOrder());
            for (int n : graph.get(cur)) {
                dfs(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[N];
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(R);
        for (int n : result) {
            System.out.println(n);
        }
    }

}
