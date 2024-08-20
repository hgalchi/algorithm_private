import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] point = {0,0,0};
        int[] first={1,2,3,4,5};
        int[] second={2, 1, 2, 3, 2, 4, 2, 5};
        int[] third={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%first.length]) point[0]++;
            if(answers[i]==second[i%second.length]) point[1]++;
            if(answers[i]==third[i%third.length]) point[2]++;
        }
        
        int max=0;
       
       
        //최대 점수 구하기 
        for(int i=0;i<point.length;i++){
            max=Math.max(max,point[i]);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<point.length;i++){
            if(point[i]==max) list.add(i+1);
        }
         int[] answer=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        
        
        return answer;
    }
}