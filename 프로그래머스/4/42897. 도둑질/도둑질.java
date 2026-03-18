import java.util.*;

class Solution {
    public int solution(int[] money) {
        
        int[] arr = new int[money.length];
        arr[0] = money[0];
        arr[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<money.length-1; i++){
            arr[i] = Math.max(arr[i-1], arr[i-2]+money[i]);
        }
        
        int[] arr2 = new int[money.length];
        arr2[0] = 0;
        arr2[1] = money[1];
        
        for(int i=2; i<money.length; i++){
            arr2[i] = Math.max(arr2[i-1], arr2[i-2]+money[i]);
        }
        return Math.max(arr[money.length-2], arr2[money.length-1]);
    }
}