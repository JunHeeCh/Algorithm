import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        
        int total = cal(play_time);
        int adv = cal(adv_time);
        
        int[] diff = new int[total+1];
        
        for(int i=0; i<logs.length; i++){
            String[] st = logs[i].split("-");
            int start = cal(st[0]);
            int end = cal(st[1]);
            diff[start]++;
            diff[end]--;
        }
        
        for(int i=1; i<total+1; i++){
            diff[i] += diff[i-1];
        }
        
        long[] window = new long[total-adv+1];
        
        long init = 0;
        for(int i=0; i<adv; i++){
            init += diff[i];
        }
        
        window[0] = init;
        long max = init;
        int time = 0;
        
        for(int i=1; i<total-adv+1; i++){
            window[i] = window[i-1]-diff[i-1]+diff[adv+i-1];
            if(window[i]>max){
                max = window[i];
                time = i;
            }
        }
        
        int sec = time%60;
        time /= 60;
        int min = time%60;
        int hour = time/60;
        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
    
    public int cal(String time){
        String[] st = time.split(":");
        int t = 0;
        t += Integer.parseInt(st[0])*60*60;
        t += Integer.parseInt(st[1])*60;
        t += Integer.parseInt(st[2]);
        return t;
    }
    
}