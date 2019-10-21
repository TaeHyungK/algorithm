package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 문제 설명
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 * <p>
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 * <p>
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 * <p>
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 * <p>
 * 제한 조건
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 */
public class PGLevel2Q1 {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayList<Integer> onBridge = new ArrayList<>();
        HashMap<String, Integer> trucks = new HashMap<String, Integer>();
        ArrayList<Integer> complete = new ArrayList<Integer>();
        int time = 0;
        int inputIndex = 0;

        while (complete.size() != truck_weights.length) {
            time++;

            HashMap<String, Integer> tempTrucks = makeTempMap(trucks);
            for (String key : trucks.keySet()) {
                tempTrucks.put(key, tempTrucks.get(key) + 1);
                if (tempTrucks.get(key) == bridge_length) {
                    tempTrucks.remove(key);
                    onBridge.remove((Integer) getIntKey(key));

                    complete.add(getIntKey(key));

                    answer = time;
                }
            }
            trucks = makeTempMap(tempTrucks);
            if (inputIndex < truck_weights.length) {
                boolean availableEnter = getAvailableEnter(onBridge, truck_weights[inputIndex], weight);
                if (availableEnter) {
                    onBridge.add(truck_weights[inputIndex]);
                    trucks.put(truck_weights[inputIndex] + "_" + inputIndex, 0);
                    inputIndex++;
                }
            }
        }

        return answer;
    }

    private static int getIntKey(String key) {
        int result = -1;
        int divider = key.indexOf("_");
        String temp = key.substring(0, divider);
        try {
            result = Integer.parseInt(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static HashMap<String, Integer> makeTempMap(HashMap<String, Integer> trucks) {
        HashMap<String, Integer> resultMap = new HashMap<>();

        for (String key : trucks.keySet()) {
            resultMap.put(key, trucks.get(key));
        }

        return resultMap;
    }

    private static boolean getAvailableEnter(ArrayList<Integer> onBridge, int nextTruck, int weight) {
        boolean result = false;
        int sum = 0;
        for (int temp : onBridge) {
            sum += temp;
        }

        if (sum < weight && nextTruck <= weight - sum) {
            result = true;
        }

        return result;
    }
}

