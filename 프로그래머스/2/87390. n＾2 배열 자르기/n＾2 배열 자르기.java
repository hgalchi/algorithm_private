import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int size=(int)(right-left);
        int[] answer=new int[size+1];
        int index=0;
        for(long i=left;i<=right;i++){
            int row=(int)(i/n)+1;
            int col=(int)(i%n)+1;
            answer[index++]=Math.max(col,row);
        }
        return answer;
    }
}