package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class n04_후위식_연산 {
    public int solution(String arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int answer = 0, lt = 0, rt = 0;
        for (char c: arr.toCharArray()) {
            //숫자일경우
            if (Character.isDigit(c)) {
                stack.push(c-48);
            //연산자인 경우
            }else{
                rt=stack.pop();
                lt = stack.pop();
                switch (c) {
                    case '+':
                        answer = lt + rt;
                        break;
                    case '-':
                        answer = lt - rt;
                        break;
                    case '*':
                        answer = lt * rt;
                        break;
                    case '/':
                        answer = lt / rt;
                        break;
                }
                stack.push(answer);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        n04_후위식_연산 t = new n04_후위식_연산();
        System.out.println(t.solution(arr));
    }
}
