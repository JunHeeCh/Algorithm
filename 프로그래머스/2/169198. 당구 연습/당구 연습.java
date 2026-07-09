class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = cal(m,n, startX, startY, balls[i][0], balls[i][1]);
        }
        return answer;
    }
    
    public int cal(int m, int n, int x, int y, int tx, int ty){
        int min = Integer.MAX_VALUE;
        
        if(!(x==tx && ty > y)){
            int a = tx;
            int b = 2*n-ty;
            int cal = (a-x)*(a-x)+(b-y)*(b-y);
            min = Math.min(min, cal);
        }
        
        if(!(y==ty && tx > x)){
            int a = 2*m-tx;
            int b = ty;
            int cal = (a-x)*(a-x)+(b-y)*(b-y);
            min = Math.min(min, cal);
        }

        if(!(x==tx && ty < y)){
            int a = tx;
            int b = -ty;
            int cal = (a-x)*(a-x)+(b-y)*(b-y);
            min = Math.min(min, cal);
        }
        
        if(!(y==ty && tx < x)){
            int a = -tx;
            int b = ty;
            int cal = (a-x)*(a-x)+(b-y)*(b-y);
            min = Math.min(min, cal);
        }
        
        return min;
    }
}