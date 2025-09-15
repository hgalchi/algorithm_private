import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int n=triangle.length;
        int[][] dp=new int[n][n];
        dp[0][0]=triangle[0][0];
        
        for(int i=0;i<triangle.length-1;i++){
            for(int j=0;j<=i;j++){
                //왼쪽
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]+triangle[i+1][j]);
                //오른쪽
                dp[i+1][j+1]=Math.max(dp[i+1][j+1],dp[i][j]+triangle[i+1][j+1]);
            }
        }
        
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[dp.length-1][i]);
        }
        return max;
    }
}