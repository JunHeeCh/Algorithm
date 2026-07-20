class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] visited = new boolean[n+1];
        
        for(int i=2; i<visited.length; i++){
            for(int j=2; i*j<visited.length; j++){
                visited[i*j] = true;
            }
        }
        
        for(int i=2; i<=n; i++){
            if(visited[i]) continue;
            answer++;
        }
        return answer;
    }
}