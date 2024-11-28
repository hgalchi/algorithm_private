
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        arr = new int[N + 2];
        int max=0,min=0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //경계범위 보장
        arr[N] =  -10000001;
        arr[N+1] = 10000001;
        //정렬
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
           int search=Integer.parseInt(st.nextToken());
           int answer = upperBound(search) - lowerBound(search);
            sb.append(answer).append(" ");
            //System.out.println("M:"+search+"UpperBoound:"+upperBound(search)+"lowerBound"+lowerBound(search));
        }
        System.out.println(sb);
    }

    //m 값을 초과하는 값의 시작 위치를 탐색
    static int upperBound(int m){
        int high = arr.length;
        int low = 0;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            //arr[mid]가 큰 경우 최소값을 탐색한다.
            if (arr[mid] > m) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    //m 값이 되는 시작 위치 탐색
    static int lowerBound(int m){
        int high = arr.length;
        int low = 0;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            //arr[mid]가 크거나 같은 경우 최소값을 탐색한다.
            if (arr[mid] >= m) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

}
