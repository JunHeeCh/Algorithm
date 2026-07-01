import java.util.*;

class Solution {
    int answer =0;
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] arr = new int[n+1];
        
        Arrays.fill(arr, 1);
        
        for(int i=0; i<lost.length; i++){
            arr[lost[i]]--;
        }

        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]]++;
        }
        
        List<Integer> list = new ArrayList();
        
        for(int i=1; i<=n; i++){
            if(arr[i]>1){
                list.add(i);
            }
        }
        
        make(arr, list, 0);
        return answer;
    }
    
    public void make(int[] arr, List<Integer> list, int idx){
        if(idx==list.size()){
            int count = 0;
            for(int i=1; i<arr.length; i++){
                if(arr[i]>0) count++;
            }
            answer = Math.max(answer, count);
            return;
        }
        
        int no = list.get(idx);
        
        if(arr[no-1]==0){
            arr[no-1]++;
            arr[no]--;
            make(arr, list, idx+1);
            arr[no-1]--;
            arr[no]++;
        }
        
        if(no != arr.length-1 && arr[no+1]==0){
            arr[no+1]++;
            arr[no]--;
            make(arr, list, idx+1);
            arr[no+1]--;
            arr[no]++;
        }
        
        make(arr, list, idx+1);
    }
}