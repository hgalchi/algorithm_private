package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n09_격자판_최대합 {

    public int solution(int[][] arr) {

        int answer = 0;
        int ltd = 0, rtd = 0;

        for (int i = 0; i < arr.length; i++) {
            int row = 0, col = 0;
            for(int j = 0; j < arr[i].length; j++) {
                if(i==j) ltd += arr[i][j];
                if(i+j==arr.length-1) rtd += arr[i][j];
                row += arr[i][j];
                col += arr[j][i];
            }
            answer=Math.max(row, answer);
            answer=Math.max(col, answer);
        }
        answer=Math.max(answer, ltd);
        answer=Math.max(answer, rtd);

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        n09_격자판_최대합 t = new n09_격자판_최대합();
        System.out.println(t.solution(arr));

    }
}
