import java.util.*;

class Solution {
    int[][] cost;
    int[][] hint;
    int res = Integer.MAX_VALUE;
    
    public int solution(int[][] cost, int[][] hint) {
        
        this.cost = cost;
        this.hint = hint;
        
        int[] purchase = new int[17];
        
        dfs(purchase, 0, 0);
        
        return res;
    }
    
    public void dfs(int[] purchase, int idx, int price){
        if(price >= res) return;
        if(idx==hint.length){
            cal(purchase, price);
            return;
        }
        
        dfs(purchase, idx+1, price); // hint의 idx를 구매하지 않음
        
        for(int i=1; i<hint[idx].length; i++){
            purchase[hint[idx][i]]++;
        }
        
        dfs(purchase, idx+1, price+hint[idx][0]); // hint의 idx를 구매함
        
        for(int i=1; i<hint[idx].length; i++){
            purchase[hint[idx][i]]--;
        }
    }
    
    public void cal(int[] purchase, int price){
        
        for(int i=0; i<cost.length; i++){
            if(purchase[i+1] >= cost[i].length){
                price += cost[i][cost[i].length-1];
            }else{
                price += cost[i][purchase[i+1]];
            }
        }
        
        res = Math.min(res, price);
        return;
    }
}