import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        //dp[현재 위치]=가장 큰 값
        int[][] dp=new int[triangle.length][triangle.length];
        
        //depth 0초기화
        dp[0][0]=triangle[0][0];
        
        //depth 1부터 탐색
        for(int row=1;row<triangle.length;row++){
            for(int col=0;col<=row;col++){
                int left=0;
                int right=0;
                if(col-1>=0){
                    left=dp[row-1][col-1];
                }
                if(col<=row-1){
                    right=dp[row-1][col];
                }
                dp[row][col]=Math.max(left,right)+triangle[row][col];
            }
        }
        
        //Integer[] max=dp[triangle.length-1];
        //Arrays.sort(max,(x,y)->y-x);
        int max=0;
        for(int i:dp[triangle.length-1]){
            max=Math.max(max,i);
        }
        return max;     
    }
}