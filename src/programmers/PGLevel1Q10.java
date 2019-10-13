package programmers;

import java.util.*;

class PGLevel1Q10 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(strings));
        Collections.sort(list, new MyComparator(n));

        System.out.println(list);

        return convertListToArray(list);
    }

    private class MyComparator implements Comparator<String> {
        int mNumber;

        public MyComparator(int n) {
            mNumber = n;
        }

        @Override
        public int compare(String first, String second) {
            char charFirst = first.charAt(this.mNumber);
            char charSecond = second.charAt(this.mNumber);

            if (charFirst > charSecond) {
                return 1;
            } else if (charFirst < charSecond) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private String[] convertListToArray(ArrayList<String> arrayList) {
        String[] result = new String[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}
