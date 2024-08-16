class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int point=0;
        int zero=0;
        for(int x:lottos){
            for(int y:win_nums){
                if(x==0){
                    zero++;
                    break;
                }
                if(x==y) point++;
            }
        }
        
        int max=answer[0]=7-point-zero;
        int min=7-point;
        answer[0]=max>6?6:max;
        answer[1]=min>6?6:min;

        return answer;
    }
}