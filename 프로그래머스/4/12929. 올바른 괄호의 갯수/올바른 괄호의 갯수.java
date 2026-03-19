class Solution {
    int answer = 0;
    public int solution(int n) {
        func(0, n, n);
        return answer;
    }
    
    // 앞에 있는 (의 개수, 사용할 수 있는 (의 개수, 사용할 수 있는 )의 개수
    public void func(int front, int a, int b){
        if(a==0 && b==0){
            answer++;
            return;
        }
        
        if(a>0){
            func(front+1, a-1, b);
        }
        
        if(front>0 && b>0){
            func(front-1, a, b-1);
        }
        
    }
}

