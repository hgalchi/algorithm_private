package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class n02_공통원소_구하기 {
    public List<Integer> solution(int[] arrN, int[] arrM) {
        List<Integer> answer=new ArrayList<>();
        int n = 0, m = 0;
        Arrays.sort(arrN);
        Arrays.sort(arrM);

        while (n != arrN.length&& m != arrM.length) {
            if (arrN[n] == arrM[m]) {
                answer.add(arrN[n]);
                n++;
                m++;
            } else if (arrN[n] > arrM[m]) {
                m++;
            } else n++;
        }

        return answer;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arrM = new int[m];
        for (int i = 0; i < m; i++) {
            arrM[i] = sc.nextInt();
        }

        n02_공통원소_구하기 t = new n02_공통원소_구하기();
        t.solution(arrN, arrM).stream().forEach(s-> System.out.print(s+" "));

    }
}
