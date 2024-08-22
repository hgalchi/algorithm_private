

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        //n과 m이 0일 경우

        long low = 1, high = max;
        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt=0;
            for (int i = 0; i < n; i++) {
                cnt+=arr[i]/mid;
            }

            if (cnt >= m) low=mid+1;
            else high = mid - 1;
        }
        System.out.println(high);
    }
}


