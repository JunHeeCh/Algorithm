import java.util.*;

class Solution {
    public int solution(String[][] clo) {
        int answer = 1;
        Map<String, Integer> map = new HashMap();
        
        for(int i=0; i<clo.length; i++){
            map.put(clo[i][1], map.getOrDefault(clo[i][1],0)+1);
        }
        
        for(int count : map.values()){
            answer *= (count+1);
        }
        answer--;
        
        return answer;
    }
    
    
}