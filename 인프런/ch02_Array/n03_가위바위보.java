package algorithm_private.인프런.ch02_Array;

import java.util.Scanner;

public class n03_가위바위보 {
        public String solution(int[] a, int[] b) {
            String answer ="";
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 1 && b[i] == 2) answer += ("B");
                else if (a[i] == 2 && b[i] == 3) answer += ("B");
                else if (a[i] == 3 && b[i] == 1) answer += ("B");
                else if(a[i]==b[i]) answer += "D";
                else answer += ("A");
            }
            return answer;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            n03_가위바위보 t = new n03_가위바위보();


            for (char c : t.solution(a, b).toCharArray()) {
                System.out.println(c);
            }
        }
}
