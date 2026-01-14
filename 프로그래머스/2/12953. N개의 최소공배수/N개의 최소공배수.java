import java.util.*;

class Solution {
    public int solution(int[] arr) {
        
        Arrays.sort(arr);
        
        for(int i=1; i<arr.length; i++){
            arr[i] = LCM(arr[i-1], arr[i]);
        }
        return arr[arr.length-1];
    }
    
    public int LCM(int a, int b){
        // 최소공배수를 반환하라
        // 최소공배수 = a * b / 최대공약수
        return a*b/GCD(a,b);
    }
    
    public int GCD(int a, int b){
        if(a==0) return b;
        return GCD(b%a,a);
    }
}