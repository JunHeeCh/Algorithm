class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n>=a){
            int moc = n/a;
            answer += b*moc;
            n -= moc*a;
            n += b*moc;
        }
        return answer;
    }
}