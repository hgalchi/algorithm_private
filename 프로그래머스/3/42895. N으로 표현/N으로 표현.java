import java.util.*;
class Solution {
    static int N,number,min;
    public int solution(int N, int number) {
        Solution.N=N;
        Solution.number=number;
        min=Integer.MAX_VALUE;
        dfs(0,0);
        return min>8?-1:min;
    }
    public void dfs(int cur,int count){
        if(count>8) return;
        if(cur==number){
            min=Math.min(min,count);
            return;
        }
       
        int concat=0;
        for(int i=0;i<8-count;i++){
            concat=concat*10+N;
            dfs(cur+concat,count+1+i);
            dfs(cur-concat,count+1+i);
            dfs(cur *concat,count+1+i);
            if(concat!=0) dfs(cur/concat,count+1+i);
        }
        
    }
}