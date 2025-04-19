import java.util.*;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];
            list.get(start).add(end);
            list.get(end).add(start);
        }

        int min = Integer.MAX_VALUE;

        for (int[] wire : wires) {
            int start = wire[0];
            int end = wire[1];

            list.get(start).remove(Integer.valueOf(end));
            list.get(end).remove(Integer.valueOf(start));

            visited = new boolean[n + 1];
            int count = dfs(1);

            int diff = Math.abs(n - count - count);
            min = Math.min(min, diff);

            list.get(start).add(end);
            list.get(end).add(start);
        }

        return min;
    }

    private int dfs(int cur) {
        visited[cur] = true;
        int count = 1;

        for (int next : list.get(cur)) {
            if (!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}
