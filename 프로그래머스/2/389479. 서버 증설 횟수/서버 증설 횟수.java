import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int solution(int[] players, int m, int k) {
        List<Integer> time=new ArrayList<>();
        int answer=0;
        for(int i=0;i<players.length;i++){
            time=time.stream()
                    .map(t->t-1)
                    .filter(t->t>0)
                    .collect(Collectors.toList());

            int serverCount=players[i]/m;

            if(serverCount>time.size()){//서버 증설
                int size=serverCount-time.size();
                for(int q=0;q<size;q++){
                    time.add(k);
                    answer++;
                }
            }


        }
        return answer;
    }
}