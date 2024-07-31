package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class n07_교육과정_설계 {
    public String solution(String temp, String arr) {
        Queue<Character> queue = new LinkedList<Character>();
        String answer = "YES";
        for (char c : temp.toCharArray()) queue.offer(c);
        for (char c : arr.toCharArray()) {
            if (queue.contains(c)) {
                if(queue.peek() != c) return "NO";
                else queue.poll();
            }
        }
        return queue.isEmpty()? answer:"NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String temp=sc.nextLine();
        String arr = sc.nextLine();
        n07_교육과정_설계 t = new n07_교육과정_설계();
        System.out.println(t.solution(temp,arr));
    }
}
