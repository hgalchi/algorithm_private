package algorithm_private.codeKata;

public class n14_서울에서_김서방_찾기 {
    public static String solution() {
        String[] seoul = new String[]{"Jane", "Kim"};
        String answer = "";
        for(int i=0;i<seoul.length;i++){
            if(seoul[i]=="Kim"){
                answer="김서방은"+i+"에 있다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
