
import java.util.*;

class Solution {
    
    public int solution(int[] a) {
        int answer = 0;
        int n = a.length;
        
        Map<Integer,Integer> map = new HashMap();
        for(int i : a){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        
        for(int k: map.keySet()){
            if(map.get(k)*2<=answer) continue;
            
            int pair = 0;
            for(int i=0; i<n-1; i++){
                if(a[i]!=a[i+1] && (a[i]==k||a[i+1]==k)){
                    pair++;
                    i++;
                }
            }
            answer = Math.max(answer, pair*2);
        }
        return answer;
    }
    
    
}