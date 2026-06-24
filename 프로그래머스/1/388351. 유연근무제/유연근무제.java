class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++){
            int hour = schedules[i]/100;
            int min = schedules[i]%100;
            min += 10;
            if(min>=60){
                min-=60;
                hour+=1;
            }
            
            int day = startday;
            boolean flag = true;
            
            for(int j=0; j<timelogs[0].length; j++){
                if(day==8) day = 1;
                if(day>=6) {day++;continue;}
                int h = timelogs[i][j]/100;
                int m = timelogs[i][j]%100;
                if(h>hour) {flag = false; break;}
                if(h==hour && m > min) {flag = false; break;}
                day++;
            }
            if(flag) answer++;
        }
        return answer;
    }
}