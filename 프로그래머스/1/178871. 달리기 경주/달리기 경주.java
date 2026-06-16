import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> names = new HashMap();
        String[] arr = new String[players.length];
        
        for(int i=0; i<players.length; i++){
            names.put(players[i], i);
            arr[i] = players[i];
        }
        
        for(int i=0; i<callings.length; i++){
            // callings[i] 선수가 추월함 
            int rank = names.get(callings[i]); // 추월한 선수의 등수 
            String other = arr[rank-1]; // 추월당한 선수 이름
            names.put(callings[i], rank-1);
            names.put(other, rank);
            arr[rank-1] = callings[i];
            arr[rank] = other;
        }
        
        return arr;
    }
}