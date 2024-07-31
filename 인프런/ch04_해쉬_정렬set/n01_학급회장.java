package algorithm_private.인프런.ch04_해쉬_정렬set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n01_학급회장 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String arr = sc.next();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char answer = ' ';
        int max=Integer.MIN_VALUE;

        for(char c : arr.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) > max) {
                max = map.get(c);
                answer = c;
            }
        }
        System.out.println(answer);

    }
}
