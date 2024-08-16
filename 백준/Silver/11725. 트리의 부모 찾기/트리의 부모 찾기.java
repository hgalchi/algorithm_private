
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int n;
    static int[] parents;
    static ArrayList<ArrayList<Integer>> arr;
    static void dfs(int cur) {
        visited[cur] = true;
        for(int i:arr.get(cur)) {
            //방문하지 않았고,탐색해야하는 노드
            if (!visited[i]) {
                parents[i] = cur;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        //인접 배열-> 인접 리스트
        arr = new ArrayList<>();
        visited=new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}