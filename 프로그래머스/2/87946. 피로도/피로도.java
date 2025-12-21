class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dun) {
        
        boolean[] visited = new boolean[dun.length];
        
        find(visited, dun, k, 0);
        return answer;
    }
    
    public void find(boolean[] visited, int[][] dun, int current, int res){
        
        answer = Math.max(answer, res);

        for(int i=0; i<dun.length; i++){
            if(!visited[i] && dun[i][0]<=current){
                visited[i] = true;
                find(visited, dun,  current-dun[i][1], res+1);
                visited[i] = false;
            }
        }
    }
}