package kakao;

class DemoRectangle {
    public int[] solution(int[][] v) {
        int[] x = new int[v.length];
        int[] y = new int[v.length];
        
        for (int i = 0; i < v.length; i++) {
            x[i] = v[i][0];
            y[i] = v[i][1];
        }
        
        int[] answer = { getTargetValue(x), getTargetValue(y) };
        return answer;
    }
    
    public static int getTargetValue(int[] array) {
        int result = -1;
        int duplicateValue = -1;
        boolean isDuplicate = false;
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    duplicateValue = array[i];
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                break;
            }
        }
        
        for (int target : array) {
            if (target != duplicateValue) {
                result = target;
                break;
            }
        }
        
        return result;
    }
}
