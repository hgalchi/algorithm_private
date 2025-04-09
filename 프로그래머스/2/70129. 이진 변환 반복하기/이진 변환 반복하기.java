import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCount = 0;
        int transformCount = 0;

        while (!s.equals("1")) {
            // 0 제거
            int originalLength = s.length();
            s = s.replaceAll("0", "");
            int newLength = s.length();
            zeroCount += (originalLength - newLength);

            // 이진수 변환
            s = Integer.toBinaryString(newLength);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}
