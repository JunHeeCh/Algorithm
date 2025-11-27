import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantmap = new HashMap();
        for(int i=0; i<want.length; i++){
            wantmap.put(want[i], number[i]);
        }
        
        
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> map = new HashMap();
            for(int j=i; j<i+10; j++){
                if(map.containsKey(discount[j])){
                    int temp = map.get(discount[j]);
                    map.put(discount[j], temp+1);
                }else{
                    map.put(discount[j], 1);
                }
            }
            
            boolean flag = true;
            
            for(String item : wantmap.keySet()){
                if(map.getOrDefault(item,0) < wantmap.get(item)){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                answer++;
            }
            
        }
        
        return answer;
    }
}

