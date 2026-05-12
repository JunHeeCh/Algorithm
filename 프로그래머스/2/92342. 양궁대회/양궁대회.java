class Solution {
    
    int[] peach = new int[11];
    int diff = 0;
    int[] answer;
    
    public int[] solution(int n, int[] info) {
        
        // 어피치가 n 발 쏜 후에 라이언이 n발 쏜다 
        // 0점부터 10점까지 맞칠 수 있는데 
        // 한 점수에 여러 발을 맞춰도 해당 점수 1회만 가져갈 수 있으며
        // 동일 점수에 대해서 어피치가 라이언보다 같거나 많이 맞추면 어피치가 해당 점수를 가져간다 
        // 최종 점수가 같으면 어피치 우승 
        
        // 라이언이 큰 점수 차로 우승할 수 있게 만들어야 함 
        
        // 라이언이 우승하기 위해 얻어야 하는 점수들 리스트를 뽑아서 
        // 해당 점수들과 n발이 적절한지 확인하기 
        // 28점 이상이면 무조건 우승임 
        for(int i=0; i<info.length; i++){
            peach[10-i] = info[i];    
        }
        
        boolean[] visited = new boolean[11];
        
        make(n, visited, 0);
        
        if(answer==null){
            answer = new int[]{-1};
        }
        return answer;
    }
    
    public void make(int n, boolean[] visited, int start){
        
        if(start == 11){
            check(visited, n);
            return;
        }
        make(n, visited, start+1);
        visited[start] = true;
        make(n, visited, start+1);
        visited[start] = false;
        
    }
    
    public void check(boolean[] visited, int n){
        int lion = 0, apeach = 0, count = 0;
        
        for(int i=1; i<visited.length; i++){
            if(visited[i]){
                // 라이언이 우승한 경우 
                count += peach[i]+1;
                lion += i;
            }else if(peach[i]>0){
                apeach += i;
            }
            if(count > n) return;
        }
        
        if(diff > lion-apeach || apeach >= lion){
            return;
        }
        
        diff = lion-apeach;
        answer = new int[11];
        answer[10] = n-count;
        for(int i=1; i<visited.length; i++){
            if(visited[i]){
                answer[10-i] = peach[i]+1;
            }
        }
        return;
    }
}