
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        while (M-- > 0) {
            String str = br.readLine();
            q.offer(str);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (!q.isEmpty()&&i<N) {
            String key = q.poll();
            if (map.get(key) == 1) {
                sb.append(key).append("\n");
                i++;
            } else {
                int value = map.get(key) - 1;
                map.put(key, value);
            }
        }
        System.out.println(sb);

    }

}
