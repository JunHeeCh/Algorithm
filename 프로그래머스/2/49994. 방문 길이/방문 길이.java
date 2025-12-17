import java.util.*;

class Solution {
    public int solution(String dirs) {
        
        char[] temp = dirs.toCharArray();
        Set<String> set = new HashSet();
        
        int[] now = new int[]{0,0};
        
        for(int i=0; i<temp.length; i++){
            int[] next; 
            if(temp[i]=='U'){
                next = new int[]{now[0]+1, now[1]};
            }else if(temp[i]=='D'){
                next = new int[]{now[0]-1, now[1]};
            }else if(temp[i]=='L'){
                next = new int[]{now[0], now[1]-1};
            }else{
                //R
                next = new int[]{now[0], now[1]+1};
            }
            
            if(next[0] < -5 || next[0] > 5 || next[1] < -5 || next[1] > 5){
                continue;
            }
            
            set.add(now[0] +","+ now[1] +","+ next[0] +","+ next[1]);
            set.add(next[0] +","+ next[1] +","+ now[0] +","+ now[1]);
            now[0] = next[0];
            now[1] = next[1];
        }
        
        return set.size()/2;
    }
}