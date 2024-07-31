package algorithm_private.인프런.ch01_문자열;

import java.util.ArrayList;
import java.util.Scanner;

public class n04_단어_뒤집기 {

    public ArrayList<String> solution(String[] arr) {
        ArrayList<String> answer = new ArrayList<>();

        for (String c : arr) {
            char[] s=c.toCharArray();
            int lt=0; int rt=s.length-1;
            while(lt<rt){
                char tmp=s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
            String word = String.valueOf(s);
            answer.add(word);
        }
        return answer;

    }

    public static void main(String[] args) {
        n04_단어_뒤집기 main = new n04_단어_뒤집기();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        main.solution(arr).stream()
                .forEach(System.out::println);

    }
}


