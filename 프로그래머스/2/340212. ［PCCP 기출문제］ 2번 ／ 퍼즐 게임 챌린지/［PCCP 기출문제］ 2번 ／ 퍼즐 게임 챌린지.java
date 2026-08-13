import java.util.*;

class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 100000;
        
        while(left < right){
            int mid = (left+right)/2;
            long res = cal(diffs, times, mid);
            if(res > limit){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
    public long cal(int[] diffs, int[] times, int level){
        long res = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i]>level){
                if(i>0){
                    res += (times[i]+times[i-1])*(diffs[i]-level);
                }else{
                    res += (times[i])*(diffs[i]-level);
                }
            }
            res += times[i];
        }
        return res;
    }

}
