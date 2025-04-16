import java.util.*;
class Solution {
    int max=0;
    Map<String,Integer> map=new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        List<String> list=new ArrayList<>();
        for(int count :course){
            max=0;
            map=new HashMap<>();
            for(String order :orders){
                combine("",order.split(""),count,0);
            }
            for(String key:map.keySet()){
                if(map.get(key)==max&&map.get(key)>=2){
                    list.add(key);
                }
            }
        }
        
        Collections.sort(list);
        String[] answer=new String[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }return answer;
    }
    private void combine(String now,String[] order,int count,int idx){
        if(now.length()==count){
            List<String> list=new ArrayList<>(Arrays.asList(now.split("")));
            Collections.sort(list);
            StringBuilder sb=new StringBuilder();
            for(String s:list){
                sb.append(s);
            }
            now=sb.toString();
            map.put(now,map.getOrDefault(now,0)+1);
            max=Math.max(max,map.get(now));
        }else{
            for(int i=idx;i<order.length;i++){
                combine(now+order[i],order,count,i+1);
            }
        }
    }
}