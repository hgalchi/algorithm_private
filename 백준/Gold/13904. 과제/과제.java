
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int score;
        int day;

        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //과제의 점수를 기준으로 내림차순 정렬
        PriorityQueue<Node> q = new PriorityQueue<>((x, y) ->  y.score-x.score);
        StringTokenizer st;

        int max = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score= Integer.parseInt(st.nextToken());
            q.offer(new Node(day, score));
            max = Math.max(max, day);
        }
        //마감일을 기준으로 과제를 수행할 수 있는지 여부를 저장
        boolean[] arr = new boolean[max+1];

        int answer = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            //마감일부터 1일까지 역순으로 탐색하여 과제를 수행할 수 있는 날을 찾음
            for (int i = node.day; i > 0; i--) {
                if (!arr[i]) {
                    answer += node.score;
                    //과제를 수행하는 데 하루를 사용
                    arr[i] = true;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

}
