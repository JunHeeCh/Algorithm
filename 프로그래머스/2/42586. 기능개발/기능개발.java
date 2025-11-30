import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] days = new int[progresses.length];
        for(int i = 0; i < progresses.length; i++){
            days[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0){
                days[i]++;
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        int current = days[0];
        int cnt = 1;
        
        for(int i = 1; i < days.length; i++){
            if(days[i] <= current){
                cnt++;
            } else {
                list.add(cnt);
                current = days[i];
                cnt = 1;
            }
        }
        
        list.add(cnt);
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
