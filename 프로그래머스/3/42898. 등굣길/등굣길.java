
import java.util.*;
class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp=new int[n+1][m+1];
        int INF=1000000007;

        //출발지점
        dp[1][1]=1;

        for(int[] p:puddles){
            dp[p[1]][p[0]]=-2;
        }

        for(int row=1;row<=n;row++){
            for(int col=1;col<=m;col++){
                //물웅덩이 인경우
                if(dp[row][col]==-2){
                    continue;
                }
                
                //위쪽 경로 확인
                if(row-1>0){
                    if(dp[row-1][col]!=-2){
                        dp[row][col]+=(dp[row-1][col])%INF;
                    }
                }
                if(col-1>0){
                    if(dp[row][col-1]!=-2){
                        dp[row][col]+=(dp[row][col-1])%INF;
                    }
                }
            }
        }
        return dp[n][m]%INF;
    }
}