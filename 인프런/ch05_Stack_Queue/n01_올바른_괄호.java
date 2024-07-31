package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class n01_올바른_괄호 {

    public String solution(String arr) {
        Stack<Character> stack=new Stack<Character>();
        for (char c : arr.toCharArray()) {
            //'('일 경우 stack에 push
            if (c == '(') {
                stack.push(c);
                //')'일 경우 stack에 pop
            } else {
                //pop할게 더이상 없는 경우
                if(stack.empty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.empty()) return "NO";
        return "YES";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        n01_올바른_괄호 t = new n01_올바른_괄호();
        System.out.println(t.solution(str));
    }
}
