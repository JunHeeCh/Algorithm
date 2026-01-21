import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String temp = Integer.toString(n,k);
        
        StringTokenizer st = new StringTokenizer(temp, "0");
        while(st.hasMoreTokens()){
            String tmp = st.nextToken();
            if(isPrime(tmp)){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isPrime(String number){
        long num = Long.parseLong(number);
        
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        
        for(long i=3; i*i<=num; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}