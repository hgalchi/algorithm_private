package algorithm_private.인프런.ch02_Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n06_뒤집은_소수 {

    public boolean isPrime(int n) {
        if(n==1)return false;
        //n=2일때 for문은 중단되므로 바로 true를 return한다.
        for (int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public List<Integer> solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int n : arr) {
            int t = 0,res=0;
            while (n>0) {
                t = n % 10;
                res = res * 10 + t;
                n = n / 10;
            }
            if(isPrime(res)) list.add(res);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        n06_뒤집은_소수 t = new n06_뒤집은_소수();
        System.out.println(t.solution(arr));
    }
}
