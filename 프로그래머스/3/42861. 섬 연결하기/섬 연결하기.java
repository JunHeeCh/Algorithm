import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        int[] parent = new int[n];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b)->{
            return Integer.compare(a[2], b[2]);
        });
            
        int count = 0;
        
        for(int i=0; i<costs.length; i++){
            int a = costs[i][0];
            int b = costs[i][1];
            
            if(getP(parent, a) != getP(parent, b)){
                count++;
                answer += costs[i][2];
                parent[getP(parent,b)] = getP(parent,a);
            }
            
            if(count == n-1){
                break;
            }
        }
        
        
        return answer;
    }
    
    public int getP(int[] parent, int a){
        if(parent[a] != a){
            parent[a] = getP(parent, parent[a]);
        }
        return parent[a];
    }
}