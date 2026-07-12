import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        
        int[] arrive = new int[N+2];
        int[] clear = new int[N+1];
        int n = stages.length;
        
        for(int i=0; i<n; i++){
            /*
            stages[i]-1까지 클리어 
            stages[i]까지 도달
            */
            arrive[1]++;
            clear[0]++;
            if(stages[i]==N+1) continue;
            arrive[stages[i]+1]--;
            clear[stages[i]-1]--;
        }
        
        for(int i=1; i<=N; i++){
            arrive[i] += arrive[i-1];
            clear[i] += clear[i-1];
        }
        
        List<node> list = new ArrayList();
        
        for(int i=1; i<=N; i++){
            if(arrive[i]==0){
                list.add(new node(i,0));
            }else{
                list.add(new node(i, (double)(arrive[i]-clear[i-1])/arrive[i]));
            }
        }
        list.sort(null);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).stage;
        }
        
        return answer;
    }
}

class node implements Comparable<node>{
    int stage;
    double failure;
    
    public node(int stage, double failure){
        this.stage = stage;
        this.failure = failure;
    }
    
    public int compareTo(node o){
        if(o.failure == this.failure){
            return Integer.compare(this.stage, o.stage);
        }
        return Double.compare(o.failure, this.failure);
    }
}