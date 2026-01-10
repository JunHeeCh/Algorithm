import java.util.*;

class Solution {
    int max = 0;
    public int solution(int n, int k, int[] enemy) {        
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n < 0){
                if(k==0) return i;
                n += pq.poll();
                k--;
            }
        }
        return enemy.length;
    }

}