class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        
        int[][] arr = new int[n][];
        for(int i=0; i<arr.length; i++){
            arr[i] = new int[i+1];
        }
        
        int[] dr = new int[]{1, 0, -1};
        int[] dc = new int[]{0, 1, -1};
        
        int[] now = new int[]{0,0};
        int num = 1;
        int dir = 0;
        
        while(true){
            arr[now[0]][now[1]] = num;
            num++;
            int[] next = new int[2];
            next[0] = now[0]+dr[dir];
            next[1] = now[1]+dc[dir];
            
            if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= arr[next[0]].length || arr[next[0]][next[1]] != 0){
                dir = (dir+1)%3;
                next[0] = now[0]+dr[dir];
                next[1] = now[1]+dc[dir];
                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= arr[next[0]].length || arr[next[0]][next[1]] != 0){
                    break;
                }

            }
            now = next;
        }
        
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}