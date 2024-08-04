package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n03_최대점수_구하기 {
    static int m;
    static int[] points;
    static int[] times;
    static int max=0;

    public void dfs(int L, int p,int t) {
        if(t>m) return;
        if (L == points.length) {
            max = Math.max(p, max);
        }else{
            dfs(L + 1, p, t);
            dfs(L+1,p+points[L],t+times[L]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        points = new int[n];
        times = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }

        n03_최대점수_구하기 t = new n03_최대점수_구하기();
        t.dfs(0, 0,0);
        System.out.println(max);
    }
}
