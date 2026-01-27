class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            // numbers[i] 가 함수에 들어가는 숫자
            long x = numbers[i];
            
            if(x % 2 == 0){
                answer[i] = x+1;
            }else{
                // x^(x+1)은 바뀐 비트들이 1로 표시됨 (연속된 1들 + 그 앞의 0)
                long diff = x ^ (x + 1);
                // diff >> 2 를 더하면 "0->1" 비트는 유지하고, 오른쪽 1 하나를 0으로 만드는 효과
                answer[i] = (x + 1) + (diff >> 2);
            }
        }
        
        return answer;
    }

}