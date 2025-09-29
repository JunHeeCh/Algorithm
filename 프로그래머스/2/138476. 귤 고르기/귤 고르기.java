import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int max = 0;
        for(int i=0; i<tangerine.length; i++){
            max = Math.max(max, tangerine[i]);
        }
        
        int[] count = new int[max+1];
        for(int i=0; i<tangerine.length; i++){
            count[tangerine[i]]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i=0; i<count.length; i++){
            if(count[i]>0){
                pq.add(count[i]);
            }
        }
        
        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
            answer++;
            if(sum >= k) break;
        }
        
        return answer;
    }
}