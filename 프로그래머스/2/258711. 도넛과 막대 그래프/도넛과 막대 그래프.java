import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        
        int idx = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;
        
        Set<Integer> node = new HashSet();
        Map<Integer,Integer> input = new HashMap();
        Map<Integer,Integer> output = new HashMap();
        
        for(int i=0; i<edges.length; i++){
            output.put(edges[i][0], output.getOrDefault(edges[i][0],0)+1);
            input.put(edges[i][1], input.getOrDefault(edges[i][1],0)+1);
            node.add(edges[i][0]);
            node.add(edges[i][1]);
        }
        
        for(int key : node){
            int in = input.getOrDefault(key,0);
            int out = output.getOrDefault(key,0);
            if(out==0){
                stick++;
            }
            if(out>=2 && in>=2){
                eight++;
            }
            if(out>=2 && in==0){
                idx = key;
            }
        }
        
        donut = output.get(idx)-stick-eight;
        
        int[] answer = new int[]{idx, donut, stick, eight};
        return answer;
    }

}