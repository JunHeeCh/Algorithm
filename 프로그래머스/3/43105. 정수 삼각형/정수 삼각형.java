import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] sum = new int[triangle.length][triangle[triangle.length-1].length];
        
        sum[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++){
            // i-1랑 i 줄을 비교하기
            for(int j=0; j< triangle[i].length; j++){
                // i 줄의 j랑 i-1 줄의 j,j-1을 비교
                if(j==0){
                    sum[i][j] = triangle[i][j]+sum[i-1][j];
                }else if(j==triangle[i].length-1){
                    sum[i][j] = triangle[i][j]+sum[i-1][j-1];
                }else{
                    sum[i][j] = triangle[i][j]+Math.max(sum[i-1][j], sum[i-1][j-1]);
                }
            }
        }
        
        for(int i=0; i<triangle[triangle.length-1].length; i++){
            answer = Math.max(answer, sum[triangle.length-1][i]);
        }
        return answer;
    }
}