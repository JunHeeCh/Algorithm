import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        int[] cnt = new int[10];
        
        for(int i=0; i<priorities.length; i++){
            cnt[priorities[i]]++;
        }
        
        Queue<node> queue = new LinkedList();
        for(int i=0; i<priorities.length; i++){
            queue.add(new node(i, priorities[i]));
        }
        
        int res = 1;
        boolean flag = false;
        
        while(true){
            flag = false;
            node now = queue.poll();
            
            for(int i=9; i>now.p; i--){
                if(cnt[i] > 0){
                    queue.add(now);
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                continue;
            }
            
            if(now.time == location){
                break;
            }
            cnt[now.p]--;
            res++;
            
        }
        
        return res;
    }
}

class node{
    int time;
    int p;
    
    public node(int time, int p){
        this.time = time;
        this.p=p;
    }
}