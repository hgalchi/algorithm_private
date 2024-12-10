import java.util.*;
class Solution {
    int n=0;
    int answer=0;
    String word;
    String[] arr={"A","E","I","O","U"};
    
    public void dfs(String cur,int level){
        //단말노드까지 탐색완료
        if(level>5){
            return;
        }
        //값을 찾은 경우
        if(cur.equals(word)){
            answer=n;
            return;
        }else{
            n++;
            for(String str:arr){
                dfs(cur+str,level+1);
            }
        }
        
    }
    public int solution(String word) {
        this.word=word;
        dfs("",0);
        return answer;
    }
}