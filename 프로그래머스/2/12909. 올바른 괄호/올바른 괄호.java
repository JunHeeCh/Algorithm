import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack();
        char[] temp = s.toCharArray();
        
        for(int i = 0; i < temp.length; i++){
            if(temp[i] == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
}