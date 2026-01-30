import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> queue = new LinkedList();
        int sum = 0;        
        int idx = 0;
        int time = 0;
        
        while(idx<truck_weights.length){
            while(!queue.isEmpty() && time-queue.peek()[1]>=bridge_length){
                sum -= queue.poll()[0];
            }
            
            if(sum+truck_weights[idx] <= weight){
                queue.add(new int[]{truck_weights[idx], time});
                sum += truck_weights[idx];
                idx++;
            }
            time++;
        }
        
        
        return time+bridge_length;
    }
}