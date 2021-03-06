package programmers.level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class PGLevel1Q5 {
    public static final String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public String solution(int a, int b) {
        String answer = "";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2016-" + a + "-" + b);

            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            int dayNum = cal.get(Calendar.DAY_OF_WEEK);
            answer = week[dayNum - 1];
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(answer);

        return answer;
    }
}
