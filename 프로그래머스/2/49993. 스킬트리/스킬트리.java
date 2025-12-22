import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        char[] temp = skill.toCharArray();
        
        for(String name : skill_trees){
            int idx = 1;
        
            char now = temp[0];

            Set<Character> set = new HashSet();

            for(int i=1; i<temp.length; i++){
                set.add(temp[i]);    
            }
            
            char[] test = name.toCharArray();
            boolean flag = true;
            
            for(int i=0; i<test.length; i++){
                if(idx >= temp.length){
                    break;
                }
                
                if(set.contains(test[i])){
                    flag = false;
                    break;
                }
                if(test[i]==now){
                    now = temp[idx++];
                    set.remove(now);
                }
            }
            
            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}