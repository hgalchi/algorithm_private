package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class n02_괄호문자_제거 {

    public String solution(String arr) {
        Stack<Character> stack = new Stack<Character>();
        String answer = "";
        for (int i = 0; i < arr.length(); i++) {
            // ')'일때 '('가 pop될 때까지 계속 pop
            if (arr.charAt(i) == ')') {
                while(stack.peek()!='(') stack.pop();
                stack.pop();
            }//그게 아니라면 push
            else stack.push(arr.charAt(i));
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.next();
        n02_괄호문자_제거 t = new n02_괄호문자_제거();
        System.out.println(t.solution(arr));

    }
}
