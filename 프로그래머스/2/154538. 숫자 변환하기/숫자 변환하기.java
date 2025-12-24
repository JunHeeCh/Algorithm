import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        
        boolean[] visited = new boolean[y+1];
        
        Queue<int[]> queue = new LinkedList();
        
        queue.add(new int[]{x, 0});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0]==y){
                answer = now[1];
                break;
            }
            
            if(now[0]*2 <= y && !visited[now[0]*2]) {
                queue.add(new int[]{now[0]*2, now[1]+1});
                visited[now[0]*2] = true;
            }
            if(now[0]*3 <= y && !visited[now[0]*3]) {
                queue.add(new int[]{now[0]*3, now[1]+1});
                visited[now[0]*3] = true;
            }
            if(now[0]+n <= y && !visited[now[0]+n]) {
                queue.add(new int[]{now[0]+n, now[1]+1});
                visited[now[0]+n] = true;
            }
        }
        return answer;
    }
}