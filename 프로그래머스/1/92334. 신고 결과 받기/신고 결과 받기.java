import java.util.*;
class Solution {
   public int[] solution(String[] id_list, String[] report, int k) {
    Map<String, Set<String>> reportMap = new HashMap<>();
    
    // 1. 신고 기록 저장 (신고당한 사람 기준으로 신고자들 저장)
    for (String rep : report) {
        String[] parts = rep.split(" ");
        String reporter = parts[0];
        String reported = parts[1];

        reportMap.computeIfAbsent(reported, v -> new HashSet<>()).add(reporter);
    }

    // 2. 정지 기준(k 이상 신고받은 경우)에 해당하는 유저에게 알림 보낼 사람 카운트
    Map<String, Integer> resultCount = new HashMap<>();
    for (String reported : reportMap.keySet()) {
        Set<String> reporters = reportMap.get(reported);
        if (reporters.size() >= k) {
            for (String reporter : reporters) {
                resultCount.put(reporter, resultCount.getOrDefault(reporter, 0) + 1);
            }
        }
    }

    // 3. 최종 결과 배열 구성
    int[] answer = new int[id_list.length];
    for (int i = 0; i < id_list.length; i++) {
        answer[i] = resultCount.getOrDefault(id_list[i], 0);
    }

    return answer;
}

}