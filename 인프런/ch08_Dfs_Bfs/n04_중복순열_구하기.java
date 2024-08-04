package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n04_중복순열_구하기 {
    static int n;
    static int m;
    static int[] answer;

    public void dfs(int L){
        if (L == answer.length) {
            for(int x:answer) System.out.print(x+" ");
            System.out.println();
        }else{
            for (int i = 1; i <= n; i++) {
                answer[L] =i;
                dfs(L + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];

        new n04_중복순열_구하기().dfs(0);

    }
}
