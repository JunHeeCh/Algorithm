import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        for(int m=0; m<cookie.length-1; m++){
            // l~m 까지는 첫째 아들
            // m+1 ~ r까지는 둘째 아들 
            int l = m;
            int r = m+1;
            int sum1 = cookie[l];
            int sum2 = cookie[r];
            // l은 --하고, r은 ++ 하면서 둘을 맞춤 
            while(l >= 0 && r < cookie.length){
                if(sum1==sum2){
                    answer = Math.max(answer, sum1);
                    l--;
                    r++;
                    if(l < 0 || r >= cookie.length){
                        break;
                    }
                    sum1 += cookie[l];
                    sum2 += cookie[r];
                }else if(sum1 > sum2){
                    r++;
                    if(r >= cookie.length){
                        break;
                    }
                    sum2 += cookie[r];
                }else{
                    l--;
                    if(l < 0){
                        break;
                    }
                    sum1 += cookie[l];
                }
            }
            
        }
        

        return answer;
    }
}