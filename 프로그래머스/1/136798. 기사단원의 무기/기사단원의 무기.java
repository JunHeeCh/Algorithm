import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        int[] arr = new int[number+1];
        
        Arrays.fill(arr, 1);
        
        for(int i=2; i<arr.length; i++){
            for(int j=1; i*j<arr.length; j++){
                arr[i*j]++;
            }
        }
        
        for(int i=1; i<=number; i++){
            if(arr[i]>limit){
                answer += power;
            }else{
                answer += arr[i];
            }
        }
        
        return answer;
    }
}