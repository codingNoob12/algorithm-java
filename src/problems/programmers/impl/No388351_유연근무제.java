package problems.programmers.impl;

public class No388351_유연근무제 {
    class Solution1 {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int count = 0;
            for (int i = 0; i < timelogs.length; i++) {
                boolean isInTime = true;
                int limitTime = getLimitTime(schedules[i]);
                System.out.println(limitTime);
                for (int j = 0; j < timelogs[i].length; j++) {
                    int day = (startday - 1 + j) % 7;
                    if (day < 5 && timelogs[i][j] > limitTime) {
                        isInTime = false;
                        break;
                    }
                }

                if (isInTime) {
                    count++;
                }
            }

            return count;
        }

        private int getLimitTime(int schedule) {
            int h = schedule / 100, m = schedule % 100 + 10;
            h += m / 60;
            m %= 60;
            return h * 100 + m;
        }
    }
}
