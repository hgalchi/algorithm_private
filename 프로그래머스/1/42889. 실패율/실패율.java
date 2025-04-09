import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stage_player = new HashMap<>();
        for (int stage : stages) {
            stage_player.put(stage, stage_player.getOrDefault(stage, 0) + 1);
        }

        Map<Integer, Double> fail_score = new HashMap<>();
        int total = stages.length;
        for (int i = 1; i <= N; i++) {
            int challengers = stage_player.getOrDefault(i, 0);
            if (challengers == 0) {
                fail_score.put(i, 0.0);
            } else {
                fail_score.put(i, (double) challengers / total);
                total -= challengers;
            }
        }

        List<Integer> list = new ArrayList<>(fail_score.keySet());
        list.sort(
            Comparator.comparing((Integer m) -> fail_score.get(m))
                      .reversed()
                      .thenComparingInt(i -> i)
        );

        // List → int[] 변환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
