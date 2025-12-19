class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0);
        
        return answer;
    }
    
    public void dfs(int[] num, int idx, int target, int sum){
        if(idx == num.length){
            if(target == sum){
                answer++;
            }
            return;
        }
        
        dfs(num, idx+1, target, sum+num[idx]);
        dfs(num, idx+1, target, sum-num[idx]);
    }
}