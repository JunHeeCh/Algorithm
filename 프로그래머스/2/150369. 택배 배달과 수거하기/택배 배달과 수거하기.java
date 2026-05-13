class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        // cap은 택배에 실을 수 있는 상자의 개수 
        // 최소 이동 거리 구하기 
        // n은 집 개수, n<=100,000
        // 갈 때 멀리 있는 곳 기준으로, 최대한 가져가서, 멀리 있는 곳부터 나눠줌 -> 가진 상자를 0으로 만들기 
        // 올 때, 멀리 있는 곳부터 수거하기 
        
        int[] sumD = new int[n];
        int[] sumP = new int[n];
        
        sumD[0] = deliveries[n-1];
        sumP[0] = pickups[n-1];
        
        for(int i=1; i<n; i++){
            sumD[i] = sumD[i-1]+deliveries[n-i-1];
            sumP[i] = sumP[i-1]+pickups[n-i-1];
        }
        
        int minus = 0;
        int prev = 0;
        
        while(true){
            int idxD = 100001;
            int idxP = 100001;
            
            for(int i=prev; i<n; i++){
                if(sumD[i]-minus>0){
                    idxD = i;
                    break;
                }
                if(sumP[i]-minus>0){
                    idxP = i;
                    break;
                }
            }
            
            if(idxD==100001 && idxP==100001) break;
            
            int min = Math.min(idxD, idxP);
            prev = min;
            
            answer += 2*(n-min);
            
            minus += cap;
        }
        
        
        return answer;
    }
}