class Solution {
    int answer = -1;
    boolean[][][] visited = new boolean[41][121][121];
    public int solution(int[][] info, int n, int m) {
        
        dfs(info, 0, n, m);
        
        if(answer == -1) return -1;
        return n-answer;
    }
    
    public void dfs(int[][] info, int idx, int n, int m){
        if(idx == info.length){
            if(n>answer){
                answer = n;
            }
            return;
        }
        
        if(visited[idx][n][m]) return;
        visited[idx][n][m] = true;
        
        if(n > info[idx][0] && m > info[idx][1]){
            dfs(info, idx+1, n-info[idx][0], m);
            dfs(info, idx+1, n, m-info[idx][1]);
        }else if(n > info[idx][0] || m > info[idx][1]){
            if(n > info[idx][0]) {
                dfs(info, idx+1, n-info[idx][0], m);
            }else{
                dfs(info, idx+1, n, m-info[idx][1]);
            }
        }else{
            return;
        }
    }
}