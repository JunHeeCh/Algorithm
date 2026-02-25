import java.util.*;

class Solution {
    puzzle[] arr;
    public int solution(int[] diffs, int[] times, long limit) {
        
        int n = diffs.length;
        int left = 1;
        int right = 1;
        
        arr = new puzzle[n];
        
        arr[0] = new puzzle(1, times[0], 0);
        for(int i=1; i<n; i++){
            arr[i] = new puzzle(diffs[i], times[i], times[i-1]);
            left = Math.min(left, diffs[i]);
            right = Math.max(right, diffs[i]);
        }
        
        Arrays.sort(arr);

        int level = (left+right)/2;
        
        while(left < right){
            if(cal(level) > limit){
                left = level+1;
            }else{
                right = level;
            }
            level = (left+right)/2;
        }
        
        
        return right;
    }
    
    public long cal(int level){
        long answer = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i].diff <= level){
                answer += arr[i].time_cur;
            }else{
                answer += (long)(arr[i].diff-level)*(arr[i].time_cur+arr[i].time_prev)+arr[i].time_cur;
            }
        }
        return answer;
    }
}
class puzzle implements Comparable<puzzle>{
    int diff;
    int time_cur;
    int time_prev;
    
    public puzzle(int diff, int cur, int prev){
        this.diff = diff;
        this.time_cur = cur;
        this.time_prev = prev;
    }
    
    public int compareTo(puzzle o){
        return Integer.compare(this.diff, o.diff);
    }
}