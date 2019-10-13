package programmers;

import java.util.*;

class PGLevel1Q8 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
        if (answer.length == 0) {
            answer = new int[]{-1};
        }
        Arrays.sort(answer);
        return answer;
		
	      /*ArrayList<Integer> list = new ArrayList<Integer>();
	      
	      Arrays.sort(arr);
	      for (int i = 0; i < arr.length; i++) {
	    	  if (arr[i] % divisor == 0) {
	    		  list.add(arr[i]);
	    	  }
	      }
	      
	      if (list.isEmpty()) { 
	    	  list.add(-1);
	      }
	      
	      System.out.println(list);
	      
	      return convertListToArray(list);*/
    }

    private static int[] convertListToArray(ArrayList<Integer> arrayList) {
        int[] result = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}
