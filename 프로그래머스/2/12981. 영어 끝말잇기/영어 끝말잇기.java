import java.util.*;


class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        Set<String> set = new HashSet();
        int idx = -1;
        
        char prev = words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        
        for(int i=1; i< words.length; i++){
            if(set.contains(words[i]) || prev != words[i].charAt(0)){
                idx = i;
                break;
            }else{
                prev = words[i].charAt(words[i].length()-1);
                set.add(words[i]);
            }
        }
        
        if(idx == -1){
            answer = new int[]{0,0};
            return answer;
        }
        
        int num = idx%n +1;
        idx = idx/n+1;
        answer = new int[]{num,idx};
        return answer;
    }
}