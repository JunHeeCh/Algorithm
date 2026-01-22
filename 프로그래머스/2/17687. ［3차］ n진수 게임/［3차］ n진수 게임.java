import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder all = new StringBuilder();
        StringBuilder answer = new StringBuilder();
                
        int num = 0;
        
        while(all.length() < t*m){
            all.append(Integer.toString(num, n));
            num ++;
        }
        
        for(int i=0; i<t; i++){
            answer.append(all.charAt(p-1+i*m));
        }
        return answer.toString().toUpperCase();
    }
}