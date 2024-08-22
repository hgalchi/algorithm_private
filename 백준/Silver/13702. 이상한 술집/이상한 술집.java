
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        //int->long : 막걸리의 용량은 pow(2,31)
        //주전자의 용량, 최대막걸리 용량이 pow(2,31)인 경우 low=hight+1
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

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


