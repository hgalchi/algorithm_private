import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Map<Integer, Set<Integer>> dp = new HashMap<>();
        dp.put(1, new HashSet<>(Arrays.asList(N)));

        for (int i = 2; i <= 8; i++) {
            Set<Integer> list = new HashSet<>();

            // N 이어붙인 숫자 (55, 555, ...)
            int concat = 0;
            for (int k = 0; k < i; k++) {
                concat = concat * 10 + N;
            }
            list.add(concat);

            // dp[j] 와 dp[i-j]의 조합
            for (int j = 1; j < i; j++) {
                for (int a : dp.get(j)) {
                    for (int b : dp.get(i - j)) {
                        list.add(a + b);
                        list.add(a - b);
                        list.add(a * b);
                        if (b != 0) list.add(a / b);
                    }
                }
            }

            if (list.contains(number)) return i;
            dp.put(i, list);
        }

        return -1;
    }
}
