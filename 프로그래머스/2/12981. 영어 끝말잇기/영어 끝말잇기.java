import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> list=new HashSet<>();
        list.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(words[i].charAt(0)!=words[i-1].charAt(words[i-1].length()-1)){
                int num=i%n;
                int turn=i/n;
                return new int[]{num+1,turn+1};
                }
            if(!list.contains(words[i])){
                list.add(words[i]);
            }else{
                int num=i%n;
                int turn=i/n;
                return new int[]{num+1,turn+1};
            }
        }
        return new int[]{0,0};
    }
}