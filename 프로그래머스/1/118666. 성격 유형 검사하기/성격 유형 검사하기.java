import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] list=new char[][]{{'R','T'},
                                       {'C','F'}
                                       ,{'J','M'}
                                       ,{'A','N'}
                                      };
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<list.length;i++){
            map.put(list[i][0],0);
            map.put(list[i][1],0);
        }
        for(int i=0;i<survey.length;i++){
            char[] charArray=survey[i].toCharArray();
            int score=choices[i];
            if(score==4){
                continue;
            }
            if(score-4>0){
                map.put(charArray[1],map.get(charArray[1])+score-4);
            }else{
                map.put(charArray[0],map.get(charArray[0])+4-score);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char[] u:list)
        {
            if(map.get(u[0])<map.get(u[1])){
                sb.append(u[1]);
            }else{
                sb.append(u[0]);
            }
        }
        return sb.toString();
        
    }
}