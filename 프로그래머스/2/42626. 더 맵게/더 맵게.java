import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue();
        
        for(int i=0; i<scoville.length; i++){
            pq.add((long)scoville[i]);
        }
        
        while(pq.size()>0){
            long a = pq.poll();
            
            if(a>=K){
                break;
            }
            
            if(pq.size()==0){
                answer = -1;
                break;
            }
            
            long b = pq.poll();
            
            long c = a+2*b;
            pq.add(c);
            answer++;
        }
        
        return answer;
    }
}