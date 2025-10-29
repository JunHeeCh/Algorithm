import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Character, Integer> map = new HashMap();
        map.put('[', -1);
        map.put(']', 1);
        map.put('(', -2);
        map.put(')',2);
        map.put('{', -3);
        map.put('}', 3);
        
        int n = s.length();
        char[] temp = s.toCharArray();
        
        for(int i=0; i<n; i++){
            // i는 시작점 
            Stack<Character> stack = new Stack();
            for(int j=0; j<n; j++){
                // i+j를 돌면서 
                int no = (i+j)%n;
                if(!stack.isEmpty() && map.get(stack.peek()) < 0 && map.get(stack.peek())+map.get(temp[no])==0){

                    stack.pop();       
                }else{
                    stack.push(temp[no]);
                }
            }
            
            if(stack.isEmpty()){
                answer++;
            }
        }
        
        return answer;
    }
}