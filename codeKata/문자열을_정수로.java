package algorithm_private.codeKata;

class Solution {
    public int solution(String s) {
        Integer answer = 0;
        String[] arr=s.split("");
        if(arr[0]=="-"){
            answer=Integer.parseInt(s.substring(1));
        }else{
            answer=Integer.parseInt(s);
        }

        return answer;
    }
}
