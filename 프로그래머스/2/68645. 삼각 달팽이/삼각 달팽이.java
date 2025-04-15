import java.util.*;
class Solution {
    public int[] solution(int n) {
        int direction=0;
        int row=-1,col=0;
        int number=1;
        int[][] map=new int[n][n];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
              if(direction==0){
                  row++;
              }else if(direction==1){
                  col++;
              }else{
                  row--;
                  col--;
              }
                  map[row][col]=number++;
                
            }
            direction=(direction+1)%3;
        }
        int[] answer=new int[n*(n+1)/2];
        int index=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]!=0){
                    answer[index++]=map[i][j];
                }
            }
        }return answer;
    }
}