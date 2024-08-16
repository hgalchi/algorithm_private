class Solution {
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