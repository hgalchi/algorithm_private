package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n05_동전교환 {
    static int[] arr;
    static int m;
    static int answer=Integer.MAX_VALUE;
    static Queue<Integer> q = new LinkedList<>();

    public void dfs(int coin,int L) {
        if(coin<0) return ;
        if (coin == 0) {
            answer = Math.min(answer, L);
        }else{
            for (int j : arr) {
                dfs(coin - j, L+1);
            }
        }

    }

    public void bfs() {

        int L=1;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int x=q.poll();
                for (int p : arr) {
                    int d=x-p;
                    if (d == 0) {
                        answer = Math.min(L, answer);
                    }else if(d>0){
                        q.offer(d);

                    }
                }
            }L++;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        //Arrays.sort(arr, Collections.reverseOrder());
       m = Integer.parseInt(br.readLine());
        q.offer(m);
        //new n05_동전교환().bfs();
        new n05_동전교환().dfs(m,0);
        System.out.println(answer);
    }
}
