
import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] tree;
    static boolean[] visited;
    static int maxDist = 0;
    static int farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(0);
            return;
        }
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            tree[parent].add(new int[]{child, cost});
            tree[child].add(new int[]{parent, cost}); // 양방향
        }

        // 1. 임의의 노드(1번)에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        dfs(1, 0);

        // 2. 가장 먼 노드에서 다시 DFS
        visited = new boolean[n + 1];
        dfs(farNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        visited[node] = true;
        if (dist > maxDist) {
            maxDist = dist;
            farNode = node;
        }
        for (int[] next : tree[node]) {
            int nextNode = next[0];
            int cost = next[1];
            if (!visited[nextNode]) {
                dfs(nextNode, dist + cost);
            }
        }
    }
}
