import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int i = Integer.parseInt(br.readLine());
            int cur = i;
            int blocked = 0;

            // 부모 노드를 따라가며 점유된 땅 확인
            while (cur > 1) {
                if (visited[cur]) {
                    blocked = cur; // 처음 만난 점유된 땅 저장
                }
                cur /= 2;
            }

            if (blocked == 0) {
                visited[i] = true; // 점유되지 않았다면 땅 점유
                sb.append("0\n");
            } else {
                sb.append(blocked).append("\n"); // 점유된 땅 반환
            }
        }

        System.out.println(sb);
    }
}
