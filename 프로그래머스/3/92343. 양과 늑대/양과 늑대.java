import java.util.*;
/*
양 <= 늑대 : 늑대가 이김 
최대한 많은 양을 모아서 루트 노드로 돌아오기
최대 양 마리 수 반환 
*/
class Solution {
    int answer = 0;
    List<Integer>[] tree;
    int[] info;
    
    public int solution(int[] info, int[][] edges) {
        int N = info.length;
        
        this.info = info;
        tree = new ArrayList[N];
        
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList();
        }
        for(int i =0; i< edges.length; i++){
            tree[edges[i][0]].add(edges[i][1]);
        }
        
        dfs(1, 0, new ArrayList(tree[0]));
        
        return answer;
    }
    
    public void dfs(int sheep, int wolf, List<Integer> candidates){
        answer = Math.max(answer, sheep);
        
        for(int node : candidates){
            int ns = sheep, nw = wolf;
            if(info[node] == 0){
                ns++;
            }else{
                nw++;
            }
            if(nw >= ns) continue;
            List<Integer> next = new ArrayList(candidates);
            next.remove(Integer.valueOf(node));
            next.addAll(tree[node]);
            
            dfs(ns, nw, next);
        }
    }
}