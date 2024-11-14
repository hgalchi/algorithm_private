
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static List<List<Integer>> graph;
    static int x, y;
    static int result=0;

    public static void dfs(int cur,int level) {

        if (!visited[cur]) {
            visited[cur] = true;

            for (Integer n : graph.get(cur)) {
                if (n == y) {
                    result = level;
                    return;
                }
                if (!visited[n]) {
                    dfs(n,level+1);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(x,0);
        System.out.println(result==0?-1:result+1);

    }

}
