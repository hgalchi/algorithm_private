import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer>box=new Stack<>();
        int product=0;
        int count=0;
        for(int j=0;j<moves.length;j++){
            for(int i=0;i<board.length;i++){
                product=board[i][moves[j]-1];
                if(product!=0){
                    board[i][moves[j]-1]=0;
                    if(!box.isEmpty()&&box.peek()==product){
                        box.pop();
                        count++;
                    }else{
                        box.add(product);
                    }
                    break;
                }
            }
        }
        return count*2;
    }
}