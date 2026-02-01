import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int room = 0;
        
        hotel[] arr = new hotel[book_time.length];
        
        for(int i=0; i<book_time.length; i++){
            String[] temp = book_time[i][0].split(":");
            int st = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            
            temp = book_time[i][1].split(":");
            int ed = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            arr[i] = new hotel(st, ed);
        }
        
        Arrays.sort(arr);
        
        
        int vacant = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        
        for(int i=0; i<arr.length; i++){
            while(!pq.isEmpty()){
                if(pq.peek()<=arr[i].start){
                    pq.poll();
                    vacant++;
                }else{
                    break;
                }
            }
            
            if(vacant==0){
                room++;
            }else{
                vacant--;
            }
            pq.add(arr[i].end+10);
        }
        
        return room;
    }
}

class hotel implements Comparable<hotel>{
    int start;
    int end;
    
    public hotel(int s, int e){
        this.start = s;
        this.end = e;
    }
    
    public int compareTo(hotel o){
        return Integer.compare(this.start, o.start);
    }
}