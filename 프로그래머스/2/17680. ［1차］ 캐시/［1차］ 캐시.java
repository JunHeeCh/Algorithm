import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
                
        Deque<String> cache = new LinkedList();
        
        for(int i=0; i<cities.length; i++){
            String name = cities[i].toLowerCase();
            
            if(cache.contains(name)){
                answer += 1;
                cache.remove(name);
                cache.add(name);
            }else{
                // 캐시 미스
                answer += 5;
                if(cache.size() == cacheSize){
                    cache.pollFirst();
                }
                cache.add(name);
                
            }
        }
        return answer;
    }
}