import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String,String>map= new HashMap<>();
        List<String[]> list=new ArrayList<>();
        
        for(String message: record){
            String[] info=message.split(" ");
            String status=info[0];
            String id=info[1];
            if(!status.equals("Leave")){
                String nickName=info[2];
                map.put(id,nickName);  
            }
            if(!status.equals("Change")){
                list.add(new String[]{status,id});
            }
        }
        
        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            String id=list.get(i)[1];
            String alarm=map.get(id)+"님이";
            if(list.get(i)[0].equals("Enter")){
                alarm+=" 들어왔습니다.";
            }else{
                alarm+=" 나갔습니다.";
            }
            answer[i]=alarm;
        }
        return answer;
    }
}