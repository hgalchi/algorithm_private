
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int rel = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();

        for (int i = 0; i < num + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (rel-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int min = 987654321;
        int result = 0;
        int answer = 0;


        for (int i = 1; i <= num; i++) {
            visited = new boolean[num + 1];
            result = bfs(i, visited, 0, graph);

            if (min > result) {
                min = result;
                answer = i;
            }
        }
        System.out.println(answer);
    }
    public static int bfs(int start,boolean[] visited,int level,List<List<Integer>> graph){
        Queue<Integer[]> q = new LinkedList<Integer[]>();
        q.add(new Integer[]{start,level});
        visited[start]=true;
        int score = 0;
        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];
            score += dist;
            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    visited[next]=true;
                    q.add(new Integer[]{next,dist+1});

                }
            }

        }
        return score;
    }
}
