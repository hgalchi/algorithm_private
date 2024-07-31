package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n08_응급실 {
    public int solution(int n, int m, String arr) {
        Queue<Integer> q = new LinkedList<Integer>();
        int p = Integer.parseInt(arr.split(" ")[m]);
        int x = 0,temp=0;
        for (String c : arr.split(" ")) q.offer(Integer.parseInt(c));

        while (p!=temp) {
            temp = q.poll();
            for (int t : q) {
                if(temp<t){
                    q.offer(t);
                    break;
                }
            } x++;
        } return x;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String arr = sc.nextLine();

        n08_응급실 t = new n08_응급실();
        System.out.println(t.solution(n,m,arr));
    }
}
