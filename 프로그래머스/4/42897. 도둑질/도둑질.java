import java.util.*;
class Solution {
    public int solution(int[] money) {
        int[] dp=new int[money.length];
        //첫번째 집을 터는 경우
        dp[0]=money[0];
        dp[1]=Math.max(dp[0],money[1]);
        for(int i=2;i<money.length-1;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);     
        }
        int max=dp[money.length-2];
        Arrays.fill(dp,0);
        dp[1]=money[1];
        dp[2]=Math.max(dp[1],money[2]);
        //첫번째 집을 털지 않는 경우 
        for(int i=3;i<money.length;i++){
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);  
        }
        return Math.max(max,dp[money.length-1]);
    }
}