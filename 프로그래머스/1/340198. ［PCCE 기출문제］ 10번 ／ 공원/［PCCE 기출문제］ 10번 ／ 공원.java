import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        int max = 0;
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    max = Math.max(max, cal(park,i,j));
                }
            }
        }
        
        Arrays.sort(mats);
        
        if(mats[0]>max) return -1;
        
        answer = mats[0];
        for(int i=1; i<mats.length; i++){
            if(mats[i]>max){
                return answer;
            }
            answer = mats[i];
        }
        return answer;
    }
    
    public int cal(String[][] park, int r, int c){
        int n = park.length;
        int m = park[0].length;
        
        for(int a=2; a<=50; a++){
            // i는 한변의 길이 
            boolean flag = true;
            for(int i=r; i<r+a; i++){
                for(int j=c; j<c+a; j++){
                    if(i>=n || j>=m){
                        flag = false;
                        break;
                    }
                    if(!park[i][j].equals("-1")){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(!flag){
                return a-1;
            }
        }
        
        return Math.min(n-r, m-c);
    }
}