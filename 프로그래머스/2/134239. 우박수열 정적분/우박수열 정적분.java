import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList();
        list.add(k);
        int n = 0;
        
        while(k != 1){
            if(k%2==0){
                k /= 2;
            }else{
                k *= 3;
                k++;
            }
            list.add(k);
            n++;
        }
        
        double[] area = new double[n+1];
        for(int i=1; i<area.length; i++){
            // area[i] = i-1부터 i 까지의 면적
            area[i] = area[i-1]+(double)(list.get(i)+list.get(i-1))/2;
        }
        
        for(int i=0; i<ranges.length; i++){
            int a = ranges[i][0];
            int b = n+ranges[i][1];
            if(a>b){
                answer[i] = -1;
                continue;
            }
            answer[i] = area[b]-area[a];
        }
        return answer;
    }
}