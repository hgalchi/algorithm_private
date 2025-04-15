class Solution {
    public String solution(String new_id) {
        String answer="";
//        1번째 
        new_id=new_id.toLowerCase();
//         2번째
        new_id=new_id.replaceAll("[^a-z0-9-_.]","");
//         3번째
        new_id=new_id.replaceAll("\\.+","\\.");
//         4번째 
        if(!new_id.isEmpty()&&new_id.charAt(0)=='.'){
            new_id=new_id.substring(1);
        }
        if(!new_id.isEmpty()&&new_id.charAt(new_id.length()-1)=='.'){
            new_id=new_id.substring(0,new_id.length()-1);
        }
//         5번째
        if(new_id.length()==0){
            new_id="a";
        }
//         6번째 
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
            if(!new_id.isEmpty()&&new_id.charAt(new_id.length()-1)=='.'){
                new_id=new_id.substring(0,new_id.length()-1);
            }
        }
//         7번째
        while(new_id.length()<3){
            String last=Character.toString(new_id.charAt(new_id.length()-1));
            new_id+=last;
        }
        return new_id;
    }
}