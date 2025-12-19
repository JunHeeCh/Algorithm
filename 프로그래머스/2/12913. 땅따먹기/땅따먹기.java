import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int r = land.length;
        int c = land[0].length;
        
        for(int i=1; i<r; i++){
            for(int j=0; j<c; j++){
                int max = 0;
                for(int k=0; k<c; k++){
                    if(j==k) continue;
                    max = Math.max(max, land[i-1][k]);
                }
                land[i][j] += max;
            }
        }
        
        for(int i=0; i<c; i++){
            answer = Math.max(answer, land[r-1][i]);
        }

        return answer;
    }
}