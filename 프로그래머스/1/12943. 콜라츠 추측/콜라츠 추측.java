class Solution {
    public int solution(int num) {
        
        long n = num;
        
        if(n == 1){
            return 0;
        }
        
        int answer = 0;
        while(answer < 500){
            if(n %2 == 0){
                n /= 2;
            }else{
                n *= 3;
                n += 1;
            }
            answer ++;
            if(n == 1){
                break;
            }
        }

        return answer >= 500 ? -1 : answer;
    }
}