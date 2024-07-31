package algorithm_private.인프런.ch04_해쉬_정렬set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n02_아나그램 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr1 = sc.next();
        String arr2 = sc.next();

        Map<Character, Integer> map1 = new HashMap<>();

        for(char c :arr1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        String answer = "YES";
        for(char c :arr2.toCharArray()){
            if(map1.containsKey(c)||map1.get(c)==0){
                answer = "NO";
            }
            map1.put(c, map1.get(c) - 1);
        }


        System.out.println(answer);

    }

}
