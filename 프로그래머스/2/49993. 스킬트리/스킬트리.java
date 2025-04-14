import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer=0;
        for( String skill_tree : skill_trees){
            StringBuilder sb=new StringBuilder();
            for(String s:skill_tree.split("")){
                if(skill.contains(s)){
                    sb.append(s);
                }
            }
            if(skill.startsWith(sb.toString())){
                answer++;
            }
            
        }return answer;
    }
}