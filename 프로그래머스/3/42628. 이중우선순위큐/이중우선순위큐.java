import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        TreeMap<Integer, Integer> tree = new TreeMap();
        
        for(int i=0; i < operations.length; i++){
            char first = operations[i].charAt(0);
            String[] temp = operations[i].split(" ");
            int num = Integer.parseInt(temp[1]);
            
            if(first == 'I'){
                if(tree.containsKey(num)){
                    int cnt = tree.get(num)+1;
                    // tree.remove(num);
                    tree.put(num, cnt);
                }else{
                    tree.put(num,1);
                }
                
            }else {
                if(tree.isEmpty()) continue; 
                if(num == -1){
                    Map.Entry<Integer, Integer> entry = tree.firstEntry();
                    if(entry.getValue() == 1){
                        tree.remove(entry.getKey());
                    }else{
                        int cnt = entry.getValue()-1;
                        tree.remove(entry.getKey());
                        tree.put(entry.getKey(), cnt);
                    }
                }else{
                    Map.Entry<Integer, Integer> entry = tree.lastEntry();
                    if(entry.getValue() == 1){
                        tree.remove(entry.getKey());
                    }else{
                        int cnt = entry.getValue()-1;
                        tree.remove(entry.getKey());
                        tree.put(entry.getKey(), cnt);
                    }
                }
            }
        }
        
        if(tree.size()>0){
            Map.Entry<Integer, Integer> entry = tree.firstEntry();
            int least = entry.getKey();
            entry = tree.lastEntry();
            int best = entry.getKey();
            answer = new int[]{best,least};
        }else{
            answer = new int[]{0,0};
        }
        
        
        
        return answer;
    }
}