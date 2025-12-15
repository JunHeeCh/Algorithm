import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        Set<Integer> set = new HashSet();
        
        for(int i=0; i<elements.length; i++){
            // i 는 시작점 
            int sum = 0;
            for(int j=0; j<elements.length; j++){
                sum += elements[(i+j)%elements.length];
                set.add(sum);
            }
        }
        
        answer = set.size();
        return answer;
    }
}