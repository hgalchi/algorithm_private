import java.util.*;

class Solution {
    public long solution(long n) {
        String value=String.valueOf(n);
        String[] arr=value.split("");
        Arrays.sort(arr, Collections.reverseOrder());

        String v="";
        for(String s:arr){
            v+=s;
        }
        long answer=Long.parseLong(v);
        return answer;
    }
}