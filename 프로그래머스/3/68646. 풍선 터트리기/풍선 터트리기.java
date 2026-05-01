import java.util.*;

class Solution {
    
    public int solution(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
                
        left[0] = a[0];
        
        for(int i=1; i<a.length; i++){
            left[i] = Math.min(a[i], left[i-1]);
        }
        
        right[a.length-1] = a[a.length-1];
        for(int i=a.length-2; i>=0; i--){
            right[i] = Math.min(a[i], right[i+1]);
        }
        
        int answer = 2;
        
        for(int i=1; i<a.length-1; i++){
            if(left[i-1]>=a[i] || right[i+1]>=a[i]){
                answer++;
            }
        }
        
        return answer;
    }
    
   
}