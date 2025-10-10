import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        // 총 n 개의 숫자의 합이 s가 되면서, 그들의 곱이 최대가 되는 걸 만들어라 (오름차순으로)
        if(s < n){
            int[] answer = {-1};
            return answer;
        }
        
        // 1차 집합
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++){
            answer[i] = s/n;
        }
        
        int res = s-(s/n)*n;
        
        for(int i=0; i < res; i++){
            answer[i]++;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}