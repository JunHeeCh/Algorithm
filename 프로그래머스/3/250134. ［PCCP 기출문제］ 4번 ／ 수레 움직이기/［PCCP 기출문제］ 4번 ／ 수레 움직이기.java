import java.util.*;

class Solution {
    
    int[] dr = new int[]{-1,1,0,0,0};
    int[] dc = new int[]{0,0,-1,1,0};
    
    public int solution(int[][] maze) {
        /*
        <조건>
        1. 방문했던 곳 이동 불가 
        2. 도착 시 해당 위치 고정 
        3. 같은 위치에 수레 이동 불가 
        => 최소한의 턴 수를 반환하라 
        풀 수 없는 경우 0 반환 

        */
        
        int n = maze.length; 
        int m = maze[0].length;
        
        int[] redS = null, redE = null, blueS = null, blueE = null; 
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    redS = new int[]{i,j};
                }else if(maze[i][j]==2){
                    blueS = new int[]{i,j};
                }else if(maze[i][j]==3){
                    redE = new int[]{i,j};
                }else if(maze[i][j]==4){
                    blueE = new int[]{i,j};
                }
            }
        }

        Set<String> visited = new HashSet();
        Queue<int[]> queue = new ArrayDeque();
        
        int redStartBit = 1 << (m * redS[0] + redS[1]);
        int blueStartBit = 1 << (m * blueS[0] + blueS[1]);

        queue.add(new int[]{redS[0], redS[1],blueS[0], blueS[1],redStartBit,blueStartBit,0});

        visited.add(redS[0]+","+redS[1]+","+blueS[0]+","+blueS[1]+","+redStartBit+","+blueStartBit);

        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            boolean flagR = false;
            boolean flagB = false;
            
            if(now[0]==redE[0]&&now[1]==redE[1]) flagR = true;
            if(now[2]==blueE[0]&&now[3]==blueE[1]) flagB = true;
            
            if(flagR && flagB){
                return now[6];
            }
            
            for(int i=0; i<4; i++){
                if(flagR) i=4;
                for(int j=0; j<4; j++){
                    if(flagB) j=4;
                    int Rr = now[0]+dr[i];
                    int Rc = now[1]+dc[i];
                    int Br = now[2]+dr[j];
                    int Bc = now[3]+dc[j];
                    
                    if(Rr<0||Rr>=n||Rc<0||Rc>=m||Br<0||Br>=n||Bc<0||Bc>=m|| maze[Rr][Rc]==5 || maze[Br][Bc]==5 || (Rr==Br&&Rc==Bc) || (Rr==now[2] && Rc==now[3] && Br==now[0] && Bc==now[1])) continue;

                    int bitR = m*Rr+Rc;
                    int bitB = m*Br+Bc;
                    if(i!=4 && (now[4]&(1<<bitR))!=0) continue;  
                    if(j!=4 && (now[5]&(1<<bitB))!=0) continue;
                    
                    int maskR = now[4] | (1<<bitR);
                    int maskB = now[5] | (1<<bitB);
                    
                    String key = Rr+","+Rc+","+Br+","+Bc+","+maskR+","+maskB;
                    
                    if(visited.contains(key)) continue;
                    queue.add(new int[]{Rr,Rc,Br,Bc,maskR, maskB, now[6]+1});
                    visited.add(key);

                }
            }
        }
        
        return 0;
    }
    
    
}
