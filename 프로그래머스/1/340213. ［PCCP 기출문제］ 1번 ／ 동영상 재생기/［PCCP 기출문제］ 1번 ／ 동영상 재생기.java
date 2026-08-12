class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int max = toSec(video_len);
        int cur = toSec(pos);
        int op_s = toSec(op_start);
        int op_e = toSec(op_end);
        
        for(int i=0; i<commands.length; i++){
            if(cur >= op_s && cur <= op_e){
                cur = op_e;
            }
            if(commands[i].equals("prev")){
                cur -= 10;
                cur = Math.max(0, cur);
            }else{
                cur += 10;
                cur = Math.min(max, cur);
            }
        }
        
        if(cur >= op_s && cur <= op_e){
            cur = op_e;
        }
        
        int min = cur/60;
        int sec = cur%60;
        String res = "";
        if(min<10){
            res += "0";
        }
        res += min+ ":";
        if(sec<10){
            res += "0";
        }
        res += sec;
        return res;
    }
    
    public int toSec(String time){
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
    }
    
}