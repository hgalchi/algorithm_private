package algorithm_private.인프런.ch04_해쉬_정렬set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n03_매출액의_종류 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        Map<String, Integer> map = new HashMap<>();

        int rt=k-1, lt = 0;
        String answer = " ";


        for (int i = lt ;i < rt ; i++) {
            if(rt<n)break;
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        answer +=String.valueOf(map.size())+" ";
        map = new HashMap<>();
        System.out.println(answer);
    }
}
