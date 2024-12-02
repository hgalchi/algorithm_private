
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 1;
        int answer = 0;
        stack.add(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            //추가되는 쇠막대기
            if (str.charAt(i) == '(') {
                cnt++;
                stack.add(str.charAt(i));
            }else{
                cnt--;
                stack.pop();
                //레이저인 부분
                if (str.charAt(i-1)=='(') {
                    answer += cnt;
                //레이저가 아닌 부분
                } else {
                    answer++;
                }
            }



        }
        System.out.println(answer);
    }

}
