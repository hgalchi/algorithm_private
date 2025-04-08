import java.util.*;
class Solution {
    public String solution(String new_id) {
         List<Character> list=new ArrayList<>();
            for(char c:new_id.toCharArray()){
                list.add(c);
            }


            // 1번째
            for(int i=0;i<list.size();i++){
                if(Character.isUpperCase(list.get(i))){
                    list.set(i, Character.toLowerCase(list.get(i)));
                }
            }

            //2번째
            for(int i=list.size()-1;i>=0;i--){
                Character cur=list.get(i);
                if(!(Character.isAlphabetic(cur)||Character.isDigit(cur)
                        ||cur=='-'||cur=='_'||cur=='.')){
                    list.remove(i);
                }
            }


            //3번째
            int index=list.size()-1;
            while(index>=0){
                if(list.get(index)=='.'){
                    int j=0;
                    for(j=index-1;j>=0;j--){
                        if(list.get(j)=='.'){
                            list.remove(j);
                        }else{
                            break;
                        }
                    }
                    index = j;
                }else{
                    index--;
                }
            }

//         4번째
            if(!list.isEmpty()&&list.get(0)=='.') list.remove(0);
            if(!list.isEmpty()&&list.get(list.size()-1)=='.') list.remove(list.size()-1);
           

            // 5번째
            if(list.isEmpty()) list.add('a');

            // 6번째
            if(list.size()>=16){
                list=list.subList(0,15);
                if(list.get(list.size()-1)=='.'){
                    list.remove(list.size()-1);
                }
            }

            // 7번째
            while(list.size()<3){
                list.add(list.get(list.size()-1));
            }

            StringBuilder sb=new StringBuilder();
            for(char c:list){
                sb.append(Character.toString(c));
            }
            return sb.toString();
    }
}