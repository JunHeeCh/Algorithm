import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        int camera = Integer.MIN_VALUE;
        
        for(int i=0; i<routes.length; i++){
            int s = routes[i][0];
            int e = routes[i][1];
            
            if(camera < s){
                camera = e;
                answer++;
            }
            
        }
        
        
        
        
        return answer;
    }
}