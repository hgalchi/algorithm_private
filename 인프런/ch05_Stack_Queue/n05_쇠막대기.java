package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class n05_쇠막대기 {
    public int solution(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] temp = str.toCharArray();
        int answer = 0;
        for (int i = 0; i < temp.length; i++) {
            if(temp[i]=='(')
                stack.push(temp[i]);
            else{
                //레이저
                stack.pop();
                if (temp[i - 1] == '(') {
                    answer += stack.size();
                //막대기
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        n05_쇠막대기 t = new n05_쇠막대기();
        System.out.println(t.solution(str));
    }
}
