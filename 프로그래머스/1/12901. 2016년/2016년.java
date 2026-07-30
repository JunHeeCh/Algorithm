class Solution {
    public String solution(int a, int b) {
        // 2월이 29일까지
        // 7월까지는 홀수 월이 31일, 짝수 월이 30일
        // 8월부터는 짝수월이 31일, 홀수 월이 30일
        for(int i=1; i<=12; i++){
            if(i==a) break;
            if(i==2){
                b += 29;
            }else if(i<8){
                b += (i%2==0)? 30 : 31;
            }else{
                b += (i%2==1)? 30 : 31;
            }
        }
        
        String[] arr = new String[]{"THU","FRI","SAT","SUN","MON","TUE","WED"};
        b %= 7;
        
        return arr[b];
    }
}