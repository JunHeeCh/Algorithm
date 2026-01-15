import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        Arrays.sort(citations);
        
        int n = citations.length;
                
        for(int i=0; i<n; i++){
            // citations[i]가 인용 횟수
            // n-i 가 인용된 논문 개수
            if(n-i <= citations[i])
                return n-i;
        }
        return 0;
    }
}