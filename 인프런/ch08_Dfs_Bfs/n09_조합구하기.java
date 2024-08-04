package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n09_조합구하기 {
    static int[] answer;
    static int m,n;
    void dfs(int p,int L) {
        //
        if (L == 0) {
            for(int x:answer) System.out.print(x + " ");
        }else{
            for (int i = p; i < n; i++) {
                answer[L] = p;
                dfs(i, L + 1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        new n09_조합구하기().dfs(1, 0);

    }
}
