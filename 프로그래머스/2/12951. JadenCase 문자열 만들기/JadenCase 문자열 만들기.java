class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isFirst = true;  // 단어의 첫 글자인지 확인
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == ' '){
                answer.append(c);
                isFirst = true;  // 다음 문자는 단어의 첫 글자
            } else {
                if(isFirst){
                    // 단어의 첫 글자는 대문자로
                    if(c >= 'a' && c <= 'z'){
                        c = (char)(c - ('a' - 'A'));
                    }
                    isFirst = false;
                } else {
                    // 단어의 나머지 글자는 소문자로
                    if(c >= 'A' && c <= 'Z'){
                        c = (char)(c + ('a' - 'A'));
                    }
                }
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}