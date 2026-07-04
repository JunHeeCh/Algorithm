import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] arr = new int[26];
        Arrays.fill(arr, 101);
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                arr[c-'A'] = Math.min(arr[c-'A'], j+1);
            }
        }
        
        for(int i=0; i<targets.length; i++){
            int count = 0;
            for(int j=0; j<targets[i].length(); j++){
                if(arr[targets[i].charAt(j)-'A']==101){
                    count = -1;
                    break;
                }
                count += arr[targets[i].charAt(j)-'A'];
            }
            answer[i] = count;
        }
        return answer;
    }
}