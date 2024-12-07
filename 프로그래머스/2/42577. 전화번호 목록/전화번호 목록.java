import java.util.*;

class Solution {
    int cnt;    //탐색한 번호의 개수
    
    //트라이 트리의 노드 클래스
    class Node{
        Map<Character,Node> child;  //자식 노드 저장
        boolean endOfWord;  //단어의 끝 여부 표시
        
        public Node(){
            this.child=new HashMap<>();
            this.endOfWord=false;
        }
        public void setEndOfWord(){
            this.endOfWord=true;
        }
    }
    
    public boolean solution(String[] phone_book) {
        
        //문자열을 길이 기준으로 정렬
        Arrays.sort(phone_book,(x,y)->x.length()-y.length());
        
        Node root=new Node();   //트라이 트리의 루트 노드
        
       for(String phone_num:phone_book){
        Node cur=root;
           for(int i=0;i<phone_num.length();i++){
               char c=phone_num.charAt(i);
               //자식노드로 포함하고 있지 않은 경우 추가  
               if(!cur.child.containsKey(c)){
                   cur.child.put(c,new Node());
               }else{
                   //자식 노드로 포함하고 있는 경우 
                    if(cur.child.get(c).endOfWord){
                        //현재 노드가 단어의 끝인 경우 접두어가 존재
                        return false;
                    }
               }
               //다음 노드로 이동
               cur=cur.child.get(c);
           }cur.setEndOfWord();
       }

       return true;
    }
}