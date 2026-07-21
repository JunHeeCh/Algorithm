import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] arr = new String[]{"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            String temp = babbling[i];
            
            for(int j=0; j<arr.length; j++){
                temp = temp.replace(arr[j], ","+arr[j]+",");
            }
            
            String[] array = temp.split(",");
            
            boolean flag = true;
            String prev = "";
            
            for(int j=0; j<array.length; j++){
                if(array[j].isEmpty()) continue; // 빈 토큰은 건너뛰기
                
                if(!check(array[j], arr) || array[j].equals(prev)){
                    flag = false;
                    break;
                }
                prev = array[j];
            }
            
            if(flag) answer++;
        }
        return answer;
    }
    
    public boolean check(String word, String[] arr){
        for(int i=0; i<arr.length; i++){
            if(word.equals(arr[i])){
                return true;
            }
        }
        return false;
    }
}