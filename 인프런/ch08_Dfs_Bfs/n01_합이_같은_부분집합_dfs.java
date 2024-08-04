package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n01_합이_같은_부분집합_dfs {
    static String answer="NO";
    static int[] arr;
    static int value;
    boolean flag=false;

    public void dfs(int sum, int L) {
        //다른 재귀함수들도 모두 return
        if (flag) return;
        //L이 arr.length-1인 이유
        if(L==arr.length-1){
            if (sum == value) {
                answer = "YES";
                flag=true;
                return;
            }
        }
         else {
            //집합의 합을 더해가면서 탐색
                dfs(sum + arr[L], L + 1);
                dfs(sum, L + 1);
                //모든 부분집합을 탐색했을 때 값이 나오지 않는다면
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        value=0;
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            value += arr[i];
        }
        value /=2;

        n01_합이_같은_부분집합_dfs t = new n01_합이_같은_부분집합_dfs();
        t.dfs(0,0);
        System.out.println(answer);

    }
}
