import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i < win_nums.length; i++){
            set.add(win_nums[i]);
        }
        
        
        int least = 0;
        int zero = 0;
        
        for(int i=0; i < lottos.length; i++){
            if(set.contains(lottos[i])){
                least++;
            }else if(lottos[i]==0){
                zero++;
            }
        }
    
        int best = least + zero;
    
        if(least <= 1){
            least = 6;
        }else{
            least = 7-least;
        }
    
        if(best <= 1){
            best = 6;
        }else{
            best = 7-best;
        }
    
        
        int[] answer = {best, least};
        
        
        return answer;
    }
}