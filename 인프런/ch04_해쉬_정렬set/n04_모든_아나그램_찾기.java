package algorithm_private.인프런.ch04_해쉬_정렬set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n04_모든_아나그램_찾기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] s=sc.nextLine().split("");
        String[] t=sc.nextLine().split("");
        Map<String,Integer> map=new HashMap<>();

        for (String str : t) {
            map.put(str, 1);
        }
        int p = 0;
        int answer = 0;
        while(p<s.length){
            for(int i=p;i<t.length;i++){
                if (map.containsKey(s[i])) {
                    if(map.get(s[i])!=0){
                        map.put(s[i],0);
                    }else break;
                }else break;
                answer++;
            }
            p++;
            for (String str : t) {
                map.put(str, 1);
            }
        }
    }
}
