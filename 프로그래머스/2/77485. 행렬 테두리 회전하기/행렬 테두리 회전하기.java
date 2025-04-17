import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map=new int[rows+1][columns+1];
        int number=1;
        for(int i=1;i<map.length;i++){
            for(int j=1;j<map[0].length;j++){
                map[i][j]=number++;
            }
        }
        
        int[] answer=new int[queries.length];
        int index=0;
        for(int[] query:queries){
            int startRow=query[0];
            int startCol=query[1];
            int endRow=query[2];
            int endCol=query[3];
            
            int[][] moveMap = new int[rows + 1][columns + 1];
            for (int i = 0; i <= rows; i++) {
                moveMap[i] = map[i].clone();  
            }
            int min=987654321;
            for(int row=startRow;row<=endRow;row++){
                for(int col=startCol;col<=endCol;col++){
                    int moveRow=row,moveCol=col;
                    if(row==startRow||row==endRow||col==startCol||col==endCol){
                        if(row==startRow&&col!=startCol){
                            moveCol-=1;
                        }
                        if(col==endCol&&row!=startRow){
                            moveRow-=1;
                        }
                        if(row==endRow&&col!=endCol){
                            moveCol+=1;
                        }
                        if(col==startCol&&row!=endRow){
                            moveRow+=1;
                        }
                        moveMap[row][col]=map[moveRow][moveCol];
                        min=Math.min(min,moveMap[row][col]);
                    }
                    
                }
            }
            map=moveMap;
            answer[index++]=min;
        }
        return answer;
    }
}