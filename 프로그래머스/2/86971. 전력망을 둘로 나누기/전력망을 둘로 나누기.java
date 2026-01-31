import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 100;
        
        List<Integer>[] list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0; i<wires.length; i++){
            list[wires[i][0]].remove((Integer)wires[i][1]);
            list[wires[i][1]].remove((Integer)wires[i][0]);
            
            answer = Math.min(answer, func(n, list,wires[i][0], wires[i][1]));
            
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        return answer;
    }
    
    public int func(int n, List<Integer>[] list, int a, int b){
        int cnt1=1, cnt2 =1;
        
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> queue = new LinkedList();
        queue.add(a);
        visited[a] = true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i:list[now]){
                if(!visited[i]){
                    visited[i] = true;
                    cnt1++;
                    queue.add(i);
                }
            }
        }

        queue.add(b);
        visited[b] = true;
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            for(int i:list[now]){
                if(!visited[i]){
                    visited[i] = true;
                    cnt2++;
                    queue.add(i);
                }
            }
        }
        
        return Math.abs(cnt1-cnt2);
    }
}