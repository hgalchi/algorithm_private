
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int[] stack = new int[50];
            int cur = 0;
            String[] arr = br.readLine().split("");
            for (String s : arr) {
                if (s.equals("(")) {
                    stack[cur] = 1;
                    cur++;
                } else {
                    cur--;
                    if (cur < 0) {
                        break;
                    }
                    stack[cur] = 0;
                }
            }
            if (cur >= 0) {
                sb.append(stack[0] == 1 ? "NO" : "YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

}
