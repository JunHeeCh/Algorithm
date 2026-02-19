import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long sum = (long) d * d;
        
        for(int i=0; i*k<=d; i++){
            long x = i*k;
            long sq = (long)Math.sqrt(sum - x*x);
            long mock = sq/k;
            answer += mock+1;
        }
        return answer;
    }
}
