
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long low = 0, high = 0, time = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, arr[i]);
        }
        Arrays.sort(arr);

        high=(high+1) * M;
        //이분 탐색 진행
        while (low + 1 < high) {
            time = (low + high) / 2;
            long cnt = 0;
            //시간내에 검사할 수 있는 인원을 구한다.
            for (int i : arr) {
                cnt += time/i;
                if (cnt >= M || i > time) {
                    break;
                }
            }
            //검사 가능한 인원이 요청 인원보다 큰 경우 시간을 줄인다.
            if (cnt >= M) {
                high = time;
            } else {
                low = time;
            }
            //System.out.println("count:"+count+"\t high:"+high+"\t low:"+low);
        }
        System.out.println(high);


    }


}
