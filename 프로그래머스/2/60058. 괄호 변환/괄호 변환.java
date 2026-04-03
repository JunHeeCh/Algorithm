class Solution {
    public String solution(String p) {
      
        return func1(p);
    }
    
    public String func1(String w){
        
            if(w.length()==0) return "";
        
        StringBuilder answer = new StringBuilder();
            // 2번 분리
            String[] temp = split(w);
            if(check(temp[0])){
                answer.append(temp[0]);
                answer.append(func1(temp[1]));
            }else{
                StringBuilder st = new StringBuilder();
                st.append("(");
                st.append(func1(temp[1]));
                st.append(")");
                String tmp = temp[0].substring(1, temp[0].length()-1);
                st.append(reverse(tmp));
                return st.toString();
            }
        return answer.toString();
    }
    
    public String reverse(String t){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i)=='('){
                sb.append(")");
            }else{
                sb.append("(");
            }
        }
        return sb.toString();
    }
    public boolean check(String u){
        int ans = 0;
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i)=='('){
                ans++;
            }else{
                ans--;
            }
            if(ans<0) return false;
        }
        return true;
    }
    
    public String[] split(String w){
        int left=0,right=0;
        
        if(w.charAt(0)=='('){
            left++;
        }else{
            right++;
        }
        
        for(int i=1; i<w.length(); i++){
            
            if(w.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            
            if(left==right){
                String u = w.substring(0,i+1);
                String v = w.substring(i+1, w.length());
                return new String[]{u,v};
            }
        }
        return new String[]{"", ""}; 
    }
}