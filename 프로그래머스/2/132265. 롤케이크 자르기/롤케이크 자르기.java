import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
                
        Map<Integer, Integer> mapL = new HashMap(); // 값, 개수
        Map<Integer, Integer> mapR = new HashMap(); // 값, 개수

        for(int i=0; i< topping.length; i++){
            mapR.put(topping[i], mapR.getOrDefault(topping[i], 0)+1);
        }
        
        for(int i=0; i< topping.length; i++){
            mapL.put(topping[i], mapL.getOrDefault(topping[i], 0)+1);
            if(mapR.get(topping[i])>1){
                mapR.put(topping[i], mapR.get(topping[i])-1);
            }else{
                mapR.remove(topping[i]);
            }
            
            if(mapL.size()==mapR.size()) answer++;
        }
        
        return answer;
    }
}