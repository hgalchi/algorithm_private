import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++){
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++){
            // 추월 하는 사람
            int cp = map.get(callings[i]); 

            // 추월 당한 사람
            String temp = players[cp - 1];

            players[cp - 1] = callings[i];
            players[cp] = temp;

            map.put(players[cp],cp);
            map.put(callings[i],cp - 1);
        }

       
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();

        for (Map.Entry<String, Integer> entry : entrySet) {
            for (int i = 0; i < players.length; i++){
                if (entry.getValue()==i){
                    answer[i] = entry.getKey();
                }
            }
        }
        return answer;
    }
}