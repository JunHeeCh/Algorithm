class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey>0){
            int rest = storey%10;
            if(rest < 5){
                answer += rest;
                storey /= 10;
            }else if(rest > 5){
                answer += 10-rest;
                storey /= 10;
                storey++;
            }else{
                if((storey / 10) % 10 >= 5){
                    answer += 5;
                    storey /= 10;
                    storey++;
                }else{
                    answer += 5;
                    storey /= 10;
                }
            }
        }
        
        return answer;
    }
}