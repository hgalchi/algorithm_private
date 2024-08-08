package algorithm_private.codeKata;

import java.util.*;

class n10_정수_내림차순으로_정렬 {
    public long solution(long n) {
        String value=String.valueOf(n);
        String[] arr=value.split("");
        Arrays.sort(arr);
        StringBuilder sortedValue=new StringBuilder();
        for(String s:arr){
            sortedValue.append(s);
        }
        sortedValue.reverse();
        long answer=Long.parseLong(sortedValue.toString());
        return answer;
    }
}