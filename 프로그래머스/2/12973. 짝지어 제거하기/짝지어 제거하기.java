import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        char[] temp = s.toCharArray();
        Stack<Character> stack = new Stack();

        stack.push(temp[0]);
        
        for(int i=1; i<temp.length; i++){
            if(stack.isEmpty() || stack.peek() != temp[i]){
                stack.push(temp[i]);
            }else{
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }
        return answer;
    }
}