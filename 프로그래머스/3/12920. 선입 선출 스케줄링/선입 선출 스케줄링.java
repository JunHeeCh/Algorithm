
class Solution {
    public int solution(int n, int[] cores) {
        if(n <= cores.length) return n;
        
        long left = 0;
        long right = 10000*n;
        long mid, count;
        
        while(left < right){
            mid = (left+right)/2;
            count = cores.length;
            
            for(int core:cores){
                count += mid/core;
            }
            
            if(count >= n){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        
        long done = cores.length;
        for(int core:cores){
            done += (left-1)/core;
        }
        
        for(int i=0; i<cores.length; i++){
            if(left%cores[i] == 0){
                done++;
            }
            if(done == n){
                return i+1;
            }
        }
        return 0;
    }
}
