package algorithm_private.인프런.ch08_Dfs_Bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n01_합이_같은_부분집합 {

    public String solution(int sum, int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int index = 0;
        String answer = "YES";

        while (!q.isEmpty()&&index<arr.length) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int x = q.poll();
                int a = x + arr[index];
                if(a==sum) return answer;
                //목표값을 초과했다면 추가하지 않음
                if (a < sum) q.offer(x + arr[index]);
                q.offer(x);
            }
            index++;
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum=0;
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        n01_합이_같은_부분집합 t = new n01_합이_같은_부분집합();
        System.out.println(t.solution(sum, arr));

    }
}
