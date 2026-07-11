import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        Set<Character> set = new HashSet();
        
        for(int i=0; i<skip.length(); i++){
            set.add(skip.charAt(i));
        }
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int len = index;
            for(int j=0; j<len; j++){
                ch += 1;
                if(ch > 'z') ch = 'a';
                if(set.contains(ch)){
                    len++;
                }
            }
            answer += ""+ch;
        }
        return answer;
    }
}