import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int numA = arrayA[0];
        for(int i=1; i<arrayA.length; i++){
            numA = gcd(arrayA[i], numA);
        }
        
        int numB = arrayB[0];
        for(int i=1; i<arrayB.length; i++){
            numB = gcd(arrayB[i], numB);
        }
        
        if(check(arrayA, numB)) answer = Math.max(answer, numB);
        if(check(arrayB, numA)) answer = Math.max(answer, numA);
        return answer;
    }
    
    public boolean check(int[] arr, int num){
        for(int i=0; i<arr.length; i++){
            if(arr[i]%num==0) return false;
        }
        return true;
    }
    
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}