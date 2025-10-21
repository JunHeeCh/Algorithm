class Solution {
    public long solution(int[] num) {
        long answer = 0;
        
        long[] sum1 = new long[num.length];
        sum1[0] = num[0];
        long max1 = sum1[0];
        
        for(int i=1; i<num.length; i++){
            int now = i%2==0? num[i]:-num[i];
            
            if(sum1[i-1]>0){
                sum1[i] = sum1[i-1]+now;
            }else{
                sum1[i] = now;
            }
            
            max1 = Math.max(max1, sum1[i]);
        }
        
        long[] sum2 = new long[num.length];
        sum2[0] = -num[0];
        long max2 = sum2[0];
        
        for(int i=1; i<num.length; i++){
            int now = i%2==0? -num[i]:num[i];
            
            if(sum2[i-1]>0){
                sum2[i] = sum2[i-1]+now;
            }else{
                sum2[i] = now;
            }
            
            max2 = Math.max(max2, sum2[i]);
        }
        
        answer = Math.max(max1, max2);
        return answer;
    }
}