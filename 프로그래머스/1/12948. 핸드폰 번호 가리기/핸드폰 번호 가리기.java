import java.io.*;

class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        
        char[] temp = phone_number.toCharArray();
        
        for(int i=0; i<temp.length; i++){
            if(i < temp.length-4){
                answer.append("*");
            }else{
                answer.append(temp[i]);
            }
        }
        
        return answer.toString();
    }
}