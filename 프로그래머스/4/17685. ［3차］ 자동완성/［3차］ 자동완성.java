import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] words) {
        Arrays.sort(words);
        int answer = 0;
        
        for(int i = 0; i<words.length; i++){
            int add = 0;
            if(i>0){
                add = compare(words[i], words[i-1]);
            }
            
            if(i<words.length-1){
                int diff = compare(words[i], words[i+1]);
                add = Math.max(add, diff);
            }
            answer += add;
        }
        
        
        return answer;
    }
    
    public Integer compare(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        int min = Math.min(c1.length, c2.length);
        
        for(int i = 0; i<min; i++){
            if(c1[i] != c2[i]){
                return i+1;
            }
        }
        
        if(min == c1.length) {
        	return c1.length;
        }else {
        	return min+1;        	
        }
    }

}

