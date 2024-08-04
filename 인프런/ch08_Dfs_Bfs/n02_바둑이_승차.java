package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n02_바둑이_승차 {
    static int c;
    static int[] arr;
    static int max = 0;

    public void dfs(int k,int sum) {
        //제한 무게보다 클 경우
        if(sum>c) return;
        //경우의 수의 합
        if (k == arr.length) {
            if(sum>max) max = sum;
            return;
        }else{
            dfs(k + 1, sum + arr[k]);
            dfs(k + 1, sum);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        n02_바둑이_승차 t = new n02_바둑이_승차();
        t.dfs(0, 0);
        System.out.println(max);

    }
}
