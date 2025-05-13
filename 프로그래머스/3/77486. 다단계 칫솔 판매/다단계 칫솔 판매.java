import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<enroll.length; i++){
            map.put(enroll[i], i);
        }
        //referral[i]는 i번째 조직원의 추천인 이름
        int[] answer = new int[enroll.length];
        
        for(int i = 0; i<seller.length; i++){
            int index = map.get(seller[i]);
            int money = amount[i]*100;
            
            while(true){

                int yours = money/10;
                int my = money-yours;

                answer[index] += my;
                
                if(referral[index].equals("-") || yours==0){
                    break;
                }
                index = map.get(referral[index]);
                money = yours;
                
            }//while
            
        }//for
        
        
        
        
        return answer;
    }
}