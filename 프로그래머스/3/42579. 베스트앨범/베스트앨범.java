import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        
        Map<String, int[]> map = new HashMap(); // 장르, 횟수, 리스트넘버
        PriorityQueue<music>[] pq = new PriorityQueue[100];  // 해당 장르의 넘버랑 횟수를 저장해야 함
        
        for(int i=0; i<pq.length; i++){
            pq[i] = new PriorityQueue();
        }
        
        int idxP = 0;
        
        for(int i=0; i<genres.length; i++){
            String name = genres[i];
            if(map.containsKey(name)){
                int[] temp = map.get(name);
                
                pq[temp[1]].add(new music(i, plays[i]));
                map.put(name, new int[]{temp[0]+plays[i], temp[1]});
            }else{
                map.put(name, new int[]{plays[i], idxP});
                pq[idxP].add(new music(i, plays[i]));
                idxP++;
                
            }
        }
        
        // map에서 가장 많이 재생된 장르 순으로 정렬
        List<int[]> list = new ArrayList();
        for(String name : map.keySet()){
            list.add(map.get(name));
        }
        list.sort((a,b)->{
            return Integer.compare(b[0], a[0]);
        });
            
        for(int i=0; i<list.size(); i++){
            int no = list.get(i)[1];
            
            int size = pq[no].size();
            for(int j=0; j< Math.min(2, size); j++){
                answer.add(pq[no].poll().number);
            }
        }
        
        
            
        
        // 장르 안에서는 재생 순으로
        
        // 동일하다면 먼저 나온 순서대로 
        
        // 각 장르에선 2개씩 
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}

class music implements Comparable<music>{
    int number;
    int cnt;
    
    public music(int number, int cnt){
        this.number = number;
        this.cnt = cnt;
    }
    
    public int compareTo(music o){
        if(this.cnt == o.cnt){
            return Integer.compare(this.number, o.number);
        }
        
        return Integer.compare(o.cnt, this.cnt);
    }
}