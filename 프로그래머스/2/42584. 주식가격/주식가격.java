import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] arr= new int[prices.length];
        
        Stack<int[]> stack = new Stack();
        
        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && stack.peek()[1] > prices[i]){
                int[] now = stack.pop();
                arr[now[0]] = i-now[0];
            }
            stack.push(new int[]{i,prices[i]});
        }
        
        while(!stack.isEmpty()){
            int[] now = stack.pop();
            arr[now[0]] = prices.length-1-now[0];
        }
        return arr;
    }
}