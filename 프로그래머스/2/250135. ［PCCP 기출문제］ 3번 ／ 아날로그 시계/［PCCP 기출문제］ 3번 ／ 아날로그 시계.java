class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        // 초침이 시침 or 분침과 겹치는 횟수를 반환하라 
        // 각각 구해서 더하기 
        // 동시에 겹치는 경우가 있다면 제거 
        
        // 시침은 60*60*12초 에 360도를 회전
        // 분침은 60*60초 에 360도를 회전
        double hour = 0.1/12; // 초당 회전 
        double min = 0.1; 
        double sec = 6;
        
        int start = cal(h1,m1,s1);
        int end = cal(h2,m2,s2);
        
        double nowH = (hour * start) % 360;
        double nowM = (min  * start) % 360;
        double nowS = (sec  * start) % 360;
        
        if(nowH==nowS) answer++;
        if(nowM==nowS) answer++;
        
        for(int i=start+1; i<=end; i++){
            double prevDiffH = sec*(i-1) - hour*(i-1);
            double currDiffH = sec*i     - hour*i;
            if (Math.floor(currDiffH/360) > Math.floor(prevDiffH/360)) answer++;

            double prevDiffM = sec*(i-1) - min*(i-1);
            double currDiffM = sec*i     - min*i;
            if (Math.floor(currDiffM/360) > Math.floor(prevDiffM/360)) answer++;
        }
        
        if(start==0) answer--;
        if(start <= cal(12,0,0) && end >= cal(12,0,0)) answer--;
        return answer;
    }
    
    public int cal(int h, int m, int s){
        int sum = h*60*60;
        sum += m*60;
        sum += s;
        return sum;
    }
}