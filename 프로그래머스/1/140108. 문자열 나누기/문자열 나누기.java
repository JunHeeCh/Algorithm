class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int a = 1, b = 0;
        int idx = 0;
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==x){
                a++;
            }else{
                b++;
            }
            if(a==b){
                answer++;
                idx = i+1;
                a=1;
                b=0;
                if(i+1 < s.length()){
                    x = s.charAt(i+1);
                }
                i++;
            }
        }

        if(idx != s.length()){
            answer++;
        }
        return answer;
    }
}