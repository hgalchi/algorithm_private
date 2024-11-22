
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<List<Integer>> graph;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            int fly = 0;
            boolean[] visited = new boolean[N + 1];
            Queue<Integer> q = new LinkedList<>();
            q.offer(1);
            visited[1] = true;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int num : graph.get(cur)) {
                    //방문하지 않은 국가인 경우 q에 push
                    if (!visited[num]) {
                        q.offer(num);
                        visited[num] = true;
                        fly++;
                    }
                }
            }
            System.out.println(fly);
        }
    }

}
