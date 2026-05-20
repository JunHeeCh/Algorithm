import java.util.*;

class Solution {
    int answer = 0;
    Map<Character, Integer> init;
    
    public int solution(int n, String[] data) {
        init = new HashMap();
        init.put('A',0);
        init.put('C',1);
        init.put('F',2);
        init.put('J',3);
        init.put('M',4);
        init.put('N',5);
        init.put('R',6);
        init.put('T',7);
        
        int[] arr = new int[8];
        boolean[] visited = new boolean[8];
        make(arr, visited, 0, data);
        
        // 다음의 조건을 만족하는 정렬의 개수를 return 
        // 구성원은 총 8인 


        return answer;
    }
    
    public void make(int[] arr, boolean[] visited, int idx, String[] data){
        if(idx==8){
            StringBuilder sb= new StringBuilder();
			for(int num:arr) {
				sb.append(num);
			}
            if(check(sb.toString(), data)){
                answer++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[idx] = i;
                make(arr, visited, idx+1, data);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String arr, String[] data){
        // 조건을 모두 만족하면 true 
         for(int i=0; i<data.length; i++){
            char[] temp = data[i].toCharArray();
             
            
           int start = init.get(temp[0]);
           int end = init.get(temp[2]);
           char condition = temp[3];
           int num = temp[4]-'0';  
             
            // start와 end의 거리가 어떻게 되는지를 알아내면 됨 
            int first  = arr.indexOf(String.valueOf(start));  
            int second = arr.indexOf(String.valueOf(end));    
            int diff = Math.abs(first-second)-1;
            switch(condition){
                case '=': 
                    if(diff!=num) return false;
                    break;
                case '<': 
                    if(diff >= num) return false;
                    break;
                case '>': 
                    if(diff <= num) return false;
                    break;
            }
        }
        
        return true;
    }
}