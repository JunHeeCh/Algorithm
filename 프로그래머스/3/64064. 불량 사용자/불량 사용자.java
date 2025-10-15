import java.util.*;

class Solution {
    static Set<Set<Integer>> resultSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        List<Integer>[] list = new ArrayList[banned_id.length];
        
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<banned_id.length; i++){
            for(int j=0; j<user_id.length; j++){

                if(banned_id[i].length() != user_id[j].length()){
                    continue;
                }
                
                boolean flag = true;
                
                for(int k=0; k<banned_id[i].length(); k++){
                    if(banned_id[i].charAt(k) == '*'){
                        continue;
                    }
                    if(banned_id[i].charAt(k) != user_id[j].charAt(k)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag){
                    list[i].add(j);
                }
            }
        }
                
        resultSet = new HashSet();
        
        // 각 금지 아이디에 해당할 수 있는 번호가 할당되어 있다 
        // 앞에서부터 하나씩 골랐을 때 나오는 가짓수를 저장
        boolean[] visited = new boolean[user_id.length];
        Set<Integer> set = new HashSet();
        find(list, visited, 0, set);

        return resultSet.size();
    }
    
    public void find(List<Integer>[] list, boolean[] visited, int idx, Set<Integer> set){
        if(idx == list.length){
            resultSet.add(new HashSet(set));
            return;
        }
        
        for(Integer num : list[idx]){
            if(!visited[num]){
                visited[num] = true;
                set.add(num);
                find(list, visited, idx+1, set);
                visited[num] = false;
                set.remove(num);
            }
        }
    }
}