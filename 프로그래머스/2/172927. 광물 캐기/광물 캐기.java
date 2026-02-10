import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int totalPicks = picks[0] + picks[1] + picks[2];
        int limit = Math.min(minerals.length, totalPicks * 5);
        
        PriorityQueue<setmenu> pq = new PriorityQueue();
        
        for(int i=0; i<limit; i+=5){
            int a=0, b=0, c=0;
            for(int j=i; j<i+5; j++){
                if(j>=limit) break;
                if(minerals[j].equals("diamond")){
                    a++;
                }else if(minerals[j].equals("iron")){
                    b++;
                }else{
                    c++;
                }
            }
            pq.add(new setmenu(a,b,c));
        }
        
        while(!pq.isEmpty()){
            setmenu now = pq.poll();
            if(picks[0] > 0){
                answer += now.dcnt+now.icnt+now.scnt;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += 5*now.dcnt+now.icnt+now.scnt;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += 25*now.dcnt+5*now.icnt+now.scnt;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }
}

class setmenu implements Comparable<setmenu>{
    int dcnt, icnt, scnt;
    
    public setmenu(int a, int b, int c){
        this.dcnt = a;
        this.icnt = b;
        this.scnt = c;
    }
    
    public int compareTo(setmenu o){
        if(this.dcnt!=o.dcnt){
            return Integer.compare(o.dcnt, this.dcnt);
        }
        if(this.icnt!=o.icnt){
            return Integer.compare(o.icnt, this.icnt);
        }
        return Integer.compare(o.scnt, this.scnt);
    }
}