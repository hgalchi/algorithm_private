
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int high = 0,low=0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high, arr[i]);
        }

        while (low < high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for(int tree:arr){
                //절단기 높이보다 나무 높이가 더 크다면
                if (tree > mid) {
                    sum += tree - mid;
                }
            }
            // 잘린 합이 원하는 합보다 작거나 같은 경우
            if (sum < M) {
                //절단기의 길이를 줄인다.
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low-1);
    }

}
