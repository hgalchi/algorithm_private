import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String str="";
        for(Integer i=0;i<t*m;i++){
            str+=Integer.toString(i,n);
        }
        String result="";
        for(int i=0,count=0;count<t&&i<str.length()-m;i+=m,count++){
            result+=str.substring(i,i+m+1).split("")[p-1];
        }
        return result.toUpperCase();
    }
}