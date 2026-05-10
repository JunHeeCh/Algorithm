import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[] arrS = new int[n+1];
        int[] arrA = new int[n+1];
        int[] arrB = new int[n+1];
        
        Arrays.fill(arrS, Integer.MAX_VALUE);
        Arrays.fill(arrA, Integer.MAX_VALUE);
        Arrays.fill(arrB, Integer.MAX_VALUE);
        
        List<int[]>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<fares.length; i++){
            list[fares[i][0]].add(new int[]{fares[i][1], fares[i][2]});
            list[fares[i][1]].add(new int[]{fares[i][0], fares[i][2]});
        }
        
        func(arrS, list, s);
        func(arrA, list, a);
        func(arrB, list, b);

        answer = arrS[a]+arrS[b];
        
        for(int i=1; i<=n; i++){
            // i가 중간다리 역할이라고 할 때 
            int sum = arrS[i]+arrA[i]+arrB[i];
            answer = Math.min(answer, sum);
        }
        
        return answer;
    }
    
    public void func(int[] arr, List<int[]>[] list, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] x,int[] y)->{
            return Integer.compare(x[1], y[1]);
        }); // 노드 번호, 거리 
        pq.add(new int[]{n,0});
        arr[n] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(arr[now[0]] < now[1]) continue;
                
            for(int[] next : list[now[0]]){
                if(arr[now[0]]+next[1] < arr[next[0]]){
                    arr[next[0]] = arr[now[0]]+next[1];
                    pq.add(new int[]{next[0], arr[next[0]]});
                }
            }
        }
    }
}