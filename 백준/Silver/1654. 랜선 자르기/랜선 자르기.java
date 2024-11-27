
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long[] arr = new long[K];
        long low=0,high=0,mid=0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }
        high += 1;
        //이분탐색
        while (low + 1 < high) {
            mid = (low + high) / 2;
            long sum = 0;
            for (long i : arr) {
                sum += i / mid;
            }

            if (sum < N) {
                high = mid;
            } else {
                low = mid;
            }
        }
        System.out.println(low);
    }

}
