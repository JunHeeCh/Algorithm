class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[players.length]; // 필요한 서버 수 
        
        int n = players[0]/m;
        server[0] = n;
        answer += n;
        if(n>0 && k<24){
            server[k] = -n;
        }
        
        for(int i=1; i<players.length; i++){
            server[i] += server[i-1]; // 현재 있는 서버 수
            n = players[i]/m; // 필요한 서버 수 
            
            if(n>server[i]){
                int diff = n-server[i];
                if(i+k<24){
                    server[i+k] += -diff;
                }
                answer += diff;
                server[i] = n;
            }
        }
        
        
        
        return answer;
    }
}