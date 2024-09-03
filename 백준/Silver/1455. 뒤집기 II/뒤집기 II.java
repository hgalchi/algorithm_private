import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                if (Objects.equals(str[j], "0")) {
                    graph[i][j] = true;
                } else graph[i][j] = false;
            }
        }

        int answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                //동전의 뒷면
                if (!graph[i][j]) {
                    for (int x = 0; x<=i; x++) {
                        for (int y = 0; y<=j; y++) {
                            graph[x][y] = !graph[x][y];
                        }

                    }
                    answer++;
                }

            }
        }
        System.out.println(answer);
    }
}
