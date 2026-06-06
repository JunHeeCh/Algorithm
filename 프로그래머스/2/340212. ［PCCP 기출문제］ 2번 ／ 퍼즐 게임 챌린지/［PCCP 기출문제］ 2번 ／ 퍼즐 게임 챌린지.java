import java.util.*;

class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1, right = 100000;
        
        while(left < right){
            int mid = (left+right)/2;
            if(cal(diffs,times,mid)>limit){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }
    
    public long cal(int[] diffs, int[] times, int level){
        long total = Math.max(0, diffs[0]-level)*(times[0])+times[0];
        
        for(int i=1; i<diffs.length; i++){
            total += Math.max(0, diffs[i]-level)*(times[i]+times[i-1])+times[i];    
        }
        
        return total;
    }

}
