import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(begin);
        visited.add(begin);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                for (String word : words) {
                    if (!visited.contains(word) && canTransform(cur, word)) {
                        if (word.equals(target)) return level;
                        visited.add(word);
                        queue.add(word);
                    }
                }
            }
        }

        return 0;
    }

    private boolean canTransform(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
