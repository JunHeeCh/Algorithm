import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pq.isEmpty()){
                break;
            }
            int a = pq.poll();
            if(a-1>0){
                pq.add(a-1);
            }
        }
        
        while(!pq.isEmpty()){
            int a = pq.poll();
            answer += a*a;
        }
        
        
        return answer;
    }
}