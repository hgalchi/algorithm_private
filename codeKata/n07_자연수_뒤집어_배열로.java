package algorithm_private.codeKata;

public class n07_자연수_뒤집어_배열로 {
    public int[] solution(long n) {
        String str=""+n;
        int[] answer = new int[str.length()];
        int L=0;
        while(n>0){
            int value=(int)(n%10);
            answer[L]=value;
            n/=10.0;
            L++;
        }
        return answer;
    }
}
