import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();     // 차량번호 → 입차 시각
        Map<String, Integer> totalMap = new HashMap<>();  // 차량번호 → 누적 주차 시간

        for (String record : records) {
            String[] info = record.split(" ");
            int time = convertToMinute(info[0]);
            String carNum = info[1];
            String status = info[2];

            if (status.equals("IN")) {
                inMap.put(carNum, time);
            } else {
                int inTime = inMap.remove(carNum);
                int duration = time - inTime;
                totalMap.put(carNum, totalMap.getOrDefault(carNum, 0) + duration);
            }
        }

        // 출차 안된 차량 처리 (23:59 출차로 간주)
        for (String carNum : inMap.keySet()) {
            int inTime = inMap.get(carNum);
            int duration = convertToMinute("23:59") - inTime;
            totalMap.put(carNum, totalMap.getOrDefault(carNum, 0) + duration);
        }

        // 차량번호 오름차순 정렬
        List<String> carNums = new ArrayList<>(totalMap.keySet());
        Collections.sort(carNums);

        int[] result = new int[carNums.size()];
        int i = 0;
        for (String carNum : carNums) {
            int totalTime = totalMap.get(carNum);
            result[i++] = calculateFee(totalTime, fees);
        }

        return result;
    }

    private int convertToMinute(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private int calculateFee(int time, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (time <= baseTime) return baseFee;

        int extra = time - baseTime;
        return baseFee + (int) Math.ceil((double) extra / unitTime) * unitFee;
    }
}
