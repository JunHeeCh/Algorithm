import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
                
        int max = 0;
        
        m = change(m);
                
        for(int i=0; i<musicinfos.length; i++){
            StringTokenizer temp = new StringTokenizer(musicinfos[i], ",:");
            int hour = Integer.parseInt(temp.nextToken());
            int min = Integer.parseInt(temp.nextToken());
            int start = hour*60+min;
            hour = Integer.parseInt(temp.nextToken());
            min = Integer.parseInt(temp.nextToken());
            int end = hour*60+min;
            String title = temp.nextToken();
            String music = temp.nextToken();
            
            music = change(music);
            
            StringBuilder sb = new StringBuilder();
            int time = end-start;
            int comp = time;
            
            while(time >= music.length()){
                sb.append(music);
                time -= music.length();
            }
            sb.append(music.substring(0, time));
            
            // 멜로디가 있는지를 확인
            // 가장 긴 재생시간, 가장 먼저 입력
            if(sb.toString().contains(m)) {
            	if(max < comp) {
            		max = comp;
            		answer = title;
            	}
            }
        }
        return answer;
    }
    public String change(String m){
        return m.replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g")
            .replaceAll("A#", "a");
    }
}