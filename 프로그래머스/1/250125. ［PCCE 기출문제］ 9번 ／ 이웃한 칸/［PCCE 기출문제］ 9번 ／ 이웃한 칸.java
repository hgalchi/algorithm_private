class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dis_x=new int[]{1,-1,0,0};
        int[] dis_y=new int[]{0,0,-1,1};
        int answer=0;
        String cur=board[h][w];
        for(int i=0;i<4;i++){
            int cur_x=w+dis_x[i];
            int cur_y=h+dis_y[i];
            if(cur_y<board.length&&cur_x<board[0].length&&cur_x>-1&&cur_y>-1&&board[cur_y][cur_x].equals(cur)){
                answer++;
            }
        }
        return answer;
    }
}