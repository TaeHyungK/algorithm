package programmers;

import java.util.ArrayList;

class PGLevel1Q3 {
    public int solution(int n, int[] lost, int[] reserve) {

        int ll = lost.length;
        int rl = reserve.length;
        ArrayList<Integer> ok = new ArrayList<Integer>();

        for (int i = 0; i < ll; i++) {
            for (int j = 0; j < rl; j++) {
                if (lost[i] == reserve[j]) {
                    for (int k = j; k < rl - 1; k++) {
                        reserve[k] = reserve[k + 1];
                    }
                    for (int l = i; l < ll - 1; l++) {
                        lost[l] = lost[l + 1];
                    }
                    ll--;
                    rl--;
                }
            }
        }

        for (int i = 0; i < ll; i++) {
            int j = 0;

            while (j < rl) {
                if (ok.size() == 0 || !ok.contains(reserve[j])) {
                    if ((lost[i] + 1) == reserve[j] || (lost[i] - 1) == reserve[j]) {
                        ll--;
                        // System.out.println("after answer=" + answer + "j=" + j);
                        ok.add(reserve[j]);
                        break;
                    }
                    j++;
                } else {
                    j++;
                }
            }
        }
        return n - ll;
    }
}
