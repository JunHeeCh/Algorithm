import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin+1)];
        
        for(long i=begin; i<=end; i++){
            answer[(int)(i-begin)] = func(i);
        }
        return answer;
    }
    
    public int func(long num){
        if(num==1) return 0;
        
        int res = 1;
        
        for(int i = 2; i*i<=num; i++){
            if(num%i==0){
                long can = num/i;
                if(can <= 10000000){
                    return (int)can;
                }
                res = i;
            }
        }
        
        return res;
    }
}