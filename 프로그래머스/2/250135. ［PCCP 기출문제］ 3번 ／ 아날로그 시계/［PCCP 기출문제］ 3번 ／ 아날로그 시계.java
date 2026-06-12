class Solution {
    double h = 1.0/120;
    double m = 1.0/10;
    double s = 6.0;

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        int start = cal(h1,m1,s1);
        int end = cal(h2,m2,s2);

        degree prev = calDegree(start);
        for(int i=start+1; i<=end; i++){
            degree now = calDegree(i);
            answer += plus(prev.hour, now.hour, prev.sec, now.sec);
            answer += plus(prev.min,  now.min,  prev.sec, now.sec);
            prev = now;
        }

        degree st = calDegree(start);
        if(st.sec == st.hour) answer++;
        if(st.sec == st.min)  answer++;

        for(int i=start; i<=end; i++){
            degree d = calDegree(i);
            if(d.sec == d.hour && d.hour == d.min) answer--;
        }
        return answer;
    }

    public int plus(double start, double end, double secP, double secN){
    double rel = 6 - (end - start);
    double gap = ((start - secP) % 360 + 360) % 360;
    return (gap > 1e-9 && gap <= rel + 1e-9) ? 1 : 0;
}

    public degree calDegree(int time){
        double hour = (time*h)%360;
        double min  = (time*m)%360;
        double sec  = (time*s)%360;
        return new degree(hour, min, sec);
    }
    
    public int cal(int h, int m, int s){ 
        return h*3600 + m*60 + s;
    }
}

class degree{
    double hour, min, sec;
    public degree(double hour, double min, double sec){
        this.hour=hour; this.min=min; this.sec=sec;
    }
}