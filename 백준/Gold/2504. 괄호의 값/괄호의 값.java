
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String str;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        stack = new Stack<>();
        int sum = 0;
        int temp = 1;

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            if (cur == '(') {
                stack.push(cur);
                temp *= 2;
            } else if (cur == '[') {
                stack.push(cur);
                temp *= 3;
            } else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                }
                if (str.charAt(i - 1) == '(') {
                    sum += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                }
                if (str.charAt(i - 1) == '[') {
                    sum += temp;
                }
                stack.pop();
                temp /= 3;
            } else {
                sum = 0;
                break;
            }
        }

        System.out.println(stack.isEmpty() ? sum : 0);
    }
}
