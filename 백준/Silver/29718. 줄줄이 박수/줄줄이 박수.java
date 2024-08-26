
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] graph = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[j]+= Integer.parseInt(st.nextToken());
            }
        }

        int a = Integer.parseInt(br.readLine());

        int max=0;


        for (int i = a; i <= m; i++) {
            int sum = 0;
            for (int j = i-a; j < i; j++) {
                sum += graph[j];
            }
            max=Math.max(max, sum);
        }

        System.out.println(max);


    }

}
