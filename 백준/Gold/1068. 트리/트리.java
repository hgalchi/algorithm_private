
import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    static Map<Integer, List<Integer>> map;
    static int root, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        List<Integer> parentList = new ArrayList<>();
        root = -1;

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) root = i; 
            List<Integer> list = map.getOrDefault(parent, new ArrayList<>());
            list.add(i);
            map.put(parent, list);
            parentList.add(parent);
        }

        k = Integer.parseInt(br.readLine());

        if (k == root) { 
            System.out.println(0);
            return;
        }

       
        if (parentList.get(k) != -1) {
            map.get(parentList.get(k)).remove(Integer.valueOf(k));
        }

        dfs(root);
        System.out.println(answer);
    }

    static public void dfs(int cur) {
        if (cur == k) return;  

        if (!map.containsKey(cur) || map.get(cur).isEmpty()) { 
            answer++;  
            return;
        }

        for (int child : map.get(cur)) {
            dfs(child);
        }
    }
}
