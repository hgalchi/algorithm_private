package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

import java.util.Scanner;

public class n06_최대길이_연속부분수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int p = k, max = 0, lt = 0;
        for(int rt=0;rt<n;rt++){
            if(arr[rt] ==0) {
                //0을 1로 바꾸고 이동
                if (p != 0) {
                    p--;
                //k번 모두 바꾸었을 때 lt를 이동
                } else {
                    //최대 길이 비교
                    max=Math.max(max, rt - lt);
                    //lt에서 나오는 그다음 0이후까지 전진
                    lt++;
                    while (arr[lt] != 0) {
                        lt++;
                    }
                    //계속 0을 1로 바꾸면서 비교
                    p = 0;
                }
            }
        }
        System.out.println(max);
    }
}
