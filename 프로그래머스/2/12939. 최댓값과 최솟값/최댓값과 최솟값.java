import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());
        int min = num;
        int max = num;
        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            min = Math.min(min,num);
            max = Math.max(max,num);
        }
        
        String answer = (min+" "+max);
        return answer;
    }
}