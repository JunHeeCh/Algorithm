import java.util.*;

class Solution {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
                
        Map<Long, Long> map  = new HashMap();
        
        for(int i=0; i<room_number.length; i++){
            answer[i] = find(room_number[i], map);
            map.put(answer[i], answer[i]+1);
        }
        
        return answer;
    }
    
    public long find(long number, Map<Long, Long> map){
        if(map.containsKey(number)){
            long next = find(map.get(number), map);
            map.put(number, next);
            return next;
        }
        return number;
    }
}