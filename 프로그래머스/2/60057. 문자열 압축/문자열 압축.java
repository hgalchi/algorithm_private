import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE; // 최소 길이를 저장할 변수
        
        // 문자열을 나누는 길이 (1 ~ 문자열의 길이)
        for (int size = 1; size <= s.length(); size++) {
            int answer = 0; // 압축된 문자열의 길이
            String prev = s.substring(0, size); // 첫 번째 문자열
            int count = 1; // 동일한 문자열이 연속으로 나타나는 횟수
            
            // 문자열을 탐색
            for (int i = size; i <= s.length(); i += size) {
                String cur;
                if (i + size <= s.length()) {
                    cur = s.substring(i, i + size);
                } else {
                    cur = s.substring(i); // 남은 문자열 처리
                }
                
                if (cur.equals(prev)) {
                    count++; // 반복된 문자열 개수 증가
                } else {
                    if (count > 1) {
                        answer += Integer.toString(count).length(); // 반복된 개수를 숫자로 표현한 길이
                    }
                    answer += prev.length(); // 현재 문자열 길이 추가
                    prev = cur; // 현재 문자열을 이전 문자열로 갱신
                    count = 1; // 반복 개수 초기화
                }
            }
            
            // 남은 문자열 처리
            if (count > 1) {
                answer += Integer.toString(count).length(); // 반복된 개수를 숫자로 표현한 길이
            }
            answer += prev.length(); // 마지막 남은 문자열 길이 추가
            min = Math.min(min, answer); // 최소값 갱신
        }
        
        return min;
    }
}
