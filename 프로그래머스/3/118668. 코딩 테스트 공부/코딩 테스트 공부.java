import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        
        int goal_alp = alp;
        int goal_cop = cop;
                
        for(int[] problem : problems){
            goal_alp = Math.max(goal_alp, problem[0]);
            goal_cop = Math.max(goal_cop, problem[1]);
        }
        
        int[][] board = new int[goal_alp+1][goal_cop+1];
        for(int[] arr : board){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        // int[]{현 alp, 햔 cop, 지금까지 cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));
        pq.add(new int[]{alp, cop, 0});
        board[alp][cop] = 0;
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(board[now[0]][now[1]] < now[2]) continue;
            
            if(now[0]>=goal_alp && now[1]>=goal_cop){
                answer = now[2];
                break;
            }
            
            if(now[0]<goal_alp){
                if(board[now[0]+1][now[1]] > now[2]+1){
                    pq.add(new int[]{now[0]+1, now[1], now[2]+1});
                    board[now[0]+1][now[1]] = now[2]+1;
                }
            }
            if(now[1]<goal_cop){
                if(board[now[0]][now[1]+1] > now[2]+1){
                    pq.add(new int[]{now[0], now[1]+1, now[2]+1});
                    board[now[0]][now[1]+1] = now[2]+1;
                }
            }
            
            for(int[] problem : problems){
                if(problem[0] <= now[0] && problem[1] <= now[1]){
                    int nr = Math.min(now[0]+problem[2], goal_alp);
                    int nc = Math.min(now[1]+problem[3], goal_cop);
                    if(board[nr][nc] > now[2]+problem[4]){
                        pq.add(new int[]{nr, nc, now[2]+problem[4]});
                        board[nr][nc] = now[2]+problem[4];
                    }
                }
            }
            
        }
        return answer;
    }

}