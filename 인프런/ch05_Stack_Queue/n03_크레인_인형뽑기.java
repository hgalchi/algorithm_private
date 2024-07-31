package algorithm_private.인프런.ch05_Stack_Queue;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class n03_크레인_인형뽑기 {

    public int solution(String[][] arr, int[] moves) {
        Stack<String> stack = new Stack<>();
        int answer = 0, col = 0, row = 0;
        for (int m: moves) {
            col = m - 1;
            //열에서 뽑을 수 있는 숫자의 행을 탐색 0이 아닌 데이터일 경우
            for (int i = 0; i < arr.length; i++) {
                if (!Objects.equals(arr[i][col], "0")) {
                    row = i;
                    //stack에 데이터가 있고 가장 마지막데이터와 현재 데이터가 같을 경우
                    if (!stack.isEmpty()&&arr[row][col].equals(stack.peek())){
                        answer++;
                        stack.pop();
                    }else{
                        stack.push(arr[row][col]);
                    }
                    arr[row][col] = "0";
                    break;
                }
            }

        }
        return answer*2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] arr = new String[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.next();
            }
        }
        int m = sc.nextInt();
        int[] moves= new int[m];
        for(int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }
        n03_크레인_인형뽑기 t = new n03_크레인_인형뽑기();
        System.out.println(t.solution(arr,moves));
    }
}
