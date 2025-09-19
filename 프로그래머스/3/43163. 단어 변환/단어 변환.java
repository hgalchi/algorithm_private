import java.util.*;
class Solution {
    static int answer=Integer.MAX_VALUE;
    static String target;
    static String[] words;
    public int solution(String begin, String target, String[] words) {
        Solution.target=target;
        Solution.words=words;
        Map<String,Boolean> visited=new HashMap<>();
        for(String word:words){
            visited.put(word,false);
        }
        
        dfs(begin,0,visited);
        return answer==Integer.MAX_VALUE?0:answer;
    }
    
    public void dfs(String cur,int count,Map<String,Boolean> visited){
        if(cur.equals(target)){
            answer=Math.min(answer,count);
            return;
        }
        List<String> list=changeWord(cur,visited);
        
        for(String next:list){
            visited.put(next,true);
            dfs(next,count+1,visited);
            visited.put(next,false);
        }
    }
    
    
    public List<String> changeWord(String begin,Map<String,Boolean> map){
        List<String> list=new ArrayList<>();
        for(String word:words){
            if(!map.get(word)){
                char[] start=begin.toCharArray();
                char[] end=word.toCharArray();
                int num=0;
                for(int i=0;i<begin.length();i++){
                    if(start[i]!=end[i]) num++;
                }
                if(num<2) list.add(word);
            }
            
        }
        return list;
    }
}