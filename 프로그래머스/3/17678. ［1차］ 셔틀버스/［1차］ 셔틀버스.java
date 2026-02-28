import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
                
        int[] arr = new int[timetable.length];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = cal(timetable[i]);
        }
        
        Arrays.sort(arr); // 크루들을 도착 시간 순으로 나열 완료 
        
        int lastTime = 540+(n-1)*t;

        Queue<Integer> queue = new LinkedList();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=lastTime){
                queue.add(arr[i]);
            }else{
                break;
            }
        }
                
        for(int i=540; i< lastTime; i+=t){
            int vacant = m;
            while(vacant > 0 && !queue.isEmpty()){
                if(queue.peek() <= i){
                    vacant--;
                    queue.poll();
                }else{
                    break;
                }
            }
        }
        
        if(queue.size() < m){
            return toString(lastTime);
        }else{
            int time = 0;
            for(int i=0; i<m; i++){
                time = queue.poll();
            }
            return toString(time-1);
        }
    }
    
    public int cal(String time){
        String[] temp = time.split(":");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        return a*60+b;
    }
    
    public String toString(int time){
        int a = time/60;
        int b = time%60;
        if(a<10 && b < 10){
            return "0"+a+":"+"0"+b;
        }else if(a<10 && b >= 10){
            return "0"+a+":"+b;
        }else if(a>=10 && b < 10){
            return a+":"+"0"+b;
        }
        return  a+":"+b;
    }
}