package programmers.level1;

import java.util.Arrays;

class PGLevel1Q4 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }

        return answer;
        /*
        int i = 0;
        while (i < commands.length) {
        	int start = commands[i][0] - 1; // index이므로 -1 처리
        	int end = commands[i][1] - 1; // index이므로 -1 처리
        	int selectedNum = commands[i][2] - 1; // index이므로 -1 처리
        	
        	System.out.println("start = " + start 
        			+ ", end = " + end 
        			+ ", end-start = " + (end - start) 
        			+ ", selectedNum=" + selectedNum);
        	
        	int arraySize = end - start + 1;
        	int[] temp;
        	if (arraySize > 0) {
        		temp = new int[arraySize];
        	} else {
        		temp = new int[1];
        	}
        	
        	int count = 0;
        	for (int j = 0; j < array.length; j++) {
        		if (count >= arraySize) {
        			break;
        		}
        		if (j >= start && j <= end) {
        			temp[count] = array[j];
        			count ++;
        		}
        	}
        	
        	Arrays.sort(temp);
        	System.out.println("temp=" + Arrays.toString(temp));
        	
        	answer[i] = temp[selectedNum];
        	
        	i++;
        }
         
        return answer;*/
    }
}
