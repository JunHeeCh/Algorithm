import java.util.*;

/*
1. 큐를 하나 만들어서 작업들을 넣어야 하고
2. 이 작업에서 작업 소요 시간이 짧고, 요청 시각이 빠르고, 작업 번호가 작은 걸 선택
3. 하나의 작업이 끝나는 시간까지 요청 시각을 확인해서 큐에 넣어야 함
*/
class Solution {
    public int solution(int[][] jobs) {
        // 반환 시간의 평균의 정수부분 반환하기 
        int n = jobs.length;
        
        node[] arr = new node[n];
        
        for(int i=0; i<n; i++){
            // 소요, 요청, 번호
            arr[i] = new node(jobs[i][1], jobs[i][0], i);
        }
        
        Arrays.sort(arr, (node a, node b)-> Integer.compare(a.start, b.start));
        
        int idx = 0;
        int nowT = 0;
        
        PriorityQueue<node> pq = new PriorityQueue();
        
        int answer = 0;
        
        while(true){
            if(idx >= n && pq.isEmpty()){
                break;
            }
            // 현재 시간까지 들어와야 하는 작업들을 모두 큐에 넣기 
            for(int i=idx; i<n; i++){
                if(arr[i].start <= nowT){
                    pq.add(arr[i]);
                    idx = i+1; 
                }else{
                    break;
                }
            }
            // 큐에서 하나 뽑아서 처리하고 시간 업데이트 
            if(pq.isEmpty()){
                nowT = arr[idx].start;
                continue;
            }
            node now = pq.poll();
            nowT += now.time; 
            answer += nowT-now.start;
        }
        
        
        return answer/n;
    }
}

class node implements Comparable<node>{
    int time; // 작업 소요 시간 
    int start; // 요청 시간
    int no; // 작업 번호 
    
    public node(int time, int start, int no){
        this.time = time;
        this.start = start;
        this.no = no;
    }
    
    public int compareTo(node o){
        if(this.time != o.time){
            return Integer.compare(this.time, o.time);
        }
        if(this.start != o.start){
            return Integer.compare(this.start, o.start);
        }
        return Integer.compare(this.no, o.no);
    }
}