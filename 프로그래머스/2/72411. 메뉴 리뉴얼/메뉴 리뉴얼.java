import java.util.*;

class Solution {
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList();
        List<String>[] list = new ArrayList[11];
        
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        int[] max = new int[11];
        
        map = new HashMap();
        
        for(int i=0; i<orders.length; i++){
            for(int j=0; j<course.length; j++){
                // order[i]의 주문을 가지고, course[j] 개의 코스 메뉴를 만들어라 
                char[] arr = new char[course[j]];
                char[] name = orders[i].toCharArray();
                Arrays.sort(name);
                make(arr, name, 0, 0);
            }
        }
        
        for(String name:map.keySet()){
            //name의 길이가 같은 것 중에서 가장 많이 주문된 메뉴를 골라야 함 
            int cnt = map.get(name);
            if(cnt < 2) continue;
            
            if(max[name.length()] < cnt){
                list[name.length()] = new ArrayList();
                list[name.length()].add(name);
                max[name.length()] = cnt;
            }else if(max[name.length()] == cnt){
                list[name.length()].add(name);
            }
        }
        
        for(int i=0; i<list.length; i++){
            for(String menu : list[i]){
                answer.add(menu);
            }
        }
        
        answer.sort(null);
        
        return answer.toArray(new String[0]);
    }
    
    public void make(char[] arr, char[] order, int idx, int start){
        if(idx == arr.length){
            String menu = new String(arr);
            map.put(menu, map.getOrDefault(menu, 0)+1);
            return;
        }
        for(int i=start; i<order.length; i++){
            arr[idx] = order[i];
            make(arr, order, idx+1, i+1);
        }
    }
}
