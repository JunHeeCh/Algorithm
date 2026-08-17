class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i=1; i<food.length; i++){
            food[i] /= 2;
            answer += (""+i+"").repeat(food[i]);
        }
        answer += "0";
        for(int i=food.length-1; i>0; i--){
            answer += (""+i+"").repeat(food[i]);
        }
        return answer;
    }
}