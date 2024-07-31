package algorithm_private.인프런.ch03_TwoPointers_windowSliding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n01_두배열_합치기 {

    public List<Integer> solution(int[] nArr, int[] mArr) {
        int p=0, p2 = 0;
        List<Integer> answer = new ArrayList<>();
        while (p != nArr.length && p2 != mArr.length) {
            if(nArr[p] > mArr[p2]) {
                answer.add(mArr[p2++]);
            }else answer.add(nArr[p++]);
        }
        while (p != nArr.length) answer.add(nArr[p++]);
        while(p2!=mArr.length) answer.add(mArr[p2++]);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nArr=new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int [] mArr=new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i]=sc.nextInt();
        }
        n01_두배열_합치기 t = new n01_두배열_합치기();
        t.solution(nArr, mArr).stream().forEach(s-> System.out.print(s+" "));

    }
}
