class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            int sum = i;
            int j = i+1;
            while(true){
                if(sum == n){
                    answer++;
                    break;
                }
                if(sum > n){
                    break;
                }
                
                sum += j;
                j++;
            }
        }
        return answer;
    }
}