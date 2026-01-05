class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        long[] arr = new long[1001];
        for(int i=0; i<weights.length; i++){
            arr[weights[i]]++;
        }
        
        for(int i=100; i<arr.length; i++){
            if(arr[i]>1){
                answer += arr[i] * (arr[i]-1) / 2;
            }
        }
        
        for(int i=100; i<arr.length; i++){
            if(arr[i]==0) continue;
            
            if(i*2<=1000&&arr[i*2] > 0){
                answer += arr[i]*arr[i*2];
            }
            if(i%2==0 && i/2*3<=1000 && arr[i/2*3]>0){
                answer += arr[i]*arr[i/2*3];
            }
            if(i%3==0 && i/3*4<=1000 && arr[i/3*4]>0){
                answer += arr[i]*arr[i/3*4];
            }
        }
        
        return answer;
    }
}