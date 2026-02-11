class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int unit = 1;
        
        while(unit <= s.length() && answer > unit){
            int a = compression(unit, s);
            answer = Math.min(answer, a);
            unit++;
        }
        
        return answer;
    }
    
    public int compression(int unit, String s){
        StringBuilder sb = new StringBuilder();
        
        String temp = s.substring(0, unit);
        int cnt = 1;
        
        for(int i=unit; i<s.length(); i+=unit){
            String sub;
            if(i+unit >= s.length()){
                sub = s.substring(i);
            }else{
                sub = s.substring(i, i+unit);
            }
            
            if(temp.equals(sub)){
                cnt++;
            }else{
                if(cnt == 1){
                    sb.append(temp);
                }else{
                    sb.append(cnt+temp);
                }
                cnt = 1;
            }
            temp = sub;
        }
        
        if(cnt == 1){
            sb.append(temp);
        }else{
            sb.append(cnt+temp);
        }
        return sb.length();
    }
}