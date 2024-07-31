package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n06_공주_구하기 {
    public int solution(int n, int k) {
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) q.offer(i);

        while (q.size() != 1) {
            for (int i = 1; i < k; i++) {
                q.offer(q.poll());}
            q.poll();
            }
        return q.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        n06_공주_구하기 t = new n06_공주_구하기();
        System.out.println(t.solution(n, k));
    }
}
