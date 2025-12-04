import java.util.*;

class Solution {
    public boolean solution(String[] phone) {
        boolean answer = true;
        
        Arrays.sort(phone);
        
        for(int i=0; i<phone.length-1; i++){
            // i 랑 i+1 을 비교
            if(comp(phone[i], phone[i+1])){
                answer = false;
                break;
            }
        }
        return answer;
    }
    
    public boolean comp(String a, String b){
        int len = Math.min(a.length(), b.length());
        
        for(int i=0; i<len; i++){
            if(a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        
        return true;
    }
}