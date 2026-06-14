import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 각 유저별 처리 결과 메일을 받은 횟수 리스트 반환 
        
        // 문제유저, 신고자들
        Map<String, Set<String>> map = new HashMap(); 
        // 각 유저별 메일을 받을 횟수 
        Map<String, Integer> users = new HashMap(); 
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new HashSet());
            users.put(id_list[i], 0);
        }
        
        for(int i=0; i<report.length; i++){
            String[] temp = report[i].split(" ");
            String user = temp[0];
            String troble = temp[1];
            map.get(troble).add(user);
        }
        
        for(String name : map.keySet()) {
        	if(map.get(name).size()>=k){
                for(String user : map.get(name)){
                    users.put(user, users.get(user) + 1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = users.get(id_list[i]);
        }
        return answer;
    }
}