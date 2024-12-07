import java.util.*;

class Solution {
    int cnt;
    
    class Node{
        Map<Character,Node> child;
        boolean endOfWord;
        public Node(){
            this.child=new HashMap<>();
            this.endOfWord=false;
        }
        public void setEndOfWord(){
            this.endOfWord=true;
        }
    }
    
    public void dfs(Node cur){
        if(cur.endOfWord){
            cnt++;
            return;
        }
        for(Map.Entry<Character,Node> entry:cur.child.entrySet()){
            //자식 노드 탐색
            dfs(entry.getValue());
        }
    }
    
    public boolean solution(String[] phone_book) {
        Node root=new Node();
        //트라이얼 트리 노드 추가
       for(String phone_num:phone_book){
        Node cur=root;
           for(int i=0;i<phone_num.length();i++){
               char c=phone_num.charAt(i);
               //현재 노드의 자식노드로 포함하고 있지 않은 경우  
               if(!cur.child.containsKey(c)){
                   cur.child.put(c,new Node());
               }
               //다음 노드로 이동
               cur=cur.child.get(c);
           }cur.setEndOfWord();
       }

        cnt=0;
        //탐색
        dfs(root);
        return cnt == phone_book.length; // 결과 반환
    }
}