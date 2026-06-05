class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video = Integer.parseInt(video_len.substring(0,2))*60+Integer.parseInt(video_len.substring(3));
        int now = Integer.parseInt(pos.substring(0,2))*60+Integer.parseInt(pos.substring(3));
        int openingS = Integer.parseInt(op_start.substring(0,2))*60+Integer.parseInt(op_start.substring(3));
        int openingE = Integer.parseInt(op_end.substring(0,2))*60+Integer.parseInt(op_end.substring(3));
        
        for(int i=0; i<commands.length; i++){
            if(now >= openingS && now <= openingE){
                now = openingE;
            }
            if(commands[i].equals("prev")){
                // 뒤로 감기
                now = Math.max(now-10, 0);
            }else{
                // 앞으로 가기 
                now = Math.min(now+10, video);
            }
        }
        
        if(now >= openingS && now <= openingE){
            now = openingE;
        }
        
        int min = now/60;
        int sec = now%60;
        
        StringBuilder sb = new StringBuilder();
        if(min<10){
            sb.append("0").append(min);
        }else{
            sb.append(min);
        }
        sb.append(":");
        if(sec<10){
            sb.append("0").append(sec);
        }else{
            sb.append(sec);
        }
        return sb.toString();
    }
}