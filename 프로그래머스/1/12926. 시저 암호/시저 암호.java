class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] temp = s.toCharArray();
        for(int i=0; i<temp.length; i++){
            if(temp[i]==' '){
                answer += " ";
                continue;
            }
            int next = temp[i]+n;
            if(temp[i] >='a' && temp[i] <= 'z'){
                if(next >'z'){
                    next -= 26;
                }
                answer += (char)next;
            }
            if(temp[i] >='A' && temp[i] <= 'Z'){
                if(next >'Z'){
                    next -= 26;
                }
                answer += (char)next;
            }
        }
        return answer;
    }
}