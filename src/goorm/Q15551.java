package goorm;

import java.io.*;

public class Q15551 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] curTeam = br.readLine().split(" ");
        String[] heros = br.readLine().split(" ");

        int count = 0;
        for (String member : curTeam) {
            for (String hero : heros) {
                if (member.equals(hero)) {
                    count++;
                }
            }
        }

        System.out.println(heros.length - count);
    }
}
