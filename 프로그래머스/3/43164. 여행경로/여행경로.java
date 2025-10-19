import java.util.*;

class Solution {
    static boolean flag = false;
    public String[] solution(String[][] tickets) {
        String[] answer = new String [tickets.length+1];
        
        Map<String, List<String>> map = new HashMap();
        
        for(int i=0; i<tickets.length; i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0], new ArrayList());
            }
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        
        for(String name : map.keySet()){
            map.get(name).sort(null);
        }
    
        answer[0] = "ICN";
        make(map, answer, 1, "ICN");
        
        return answer;
    }
    
    public void make(Map<String, List<String>> map, String[] answer, int idx, String city){

        if(idx == answer.length){
            flag = true;
            return;
        }
        
        if(flag){
            return;
        }
        
        if(!map.containsKey(city) || map.get(city).isEmpty()){
            return;
        }
        
        for(int i=0; i<map.get(city).size(); i++){
            String next = map.get(city).get(i);
            map.get(city).remove(i);
            answer[idx] = next;
            make(map, answer, idx+1, next);
            
            if(!flag){
                map.get(city).add(i, next);
            }
        }
        
        
        
    }
}