import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        
        if(!checkDone( target, words )){
            return answer;
        }
        
        answer = Integer.MAX_VALUE;
        
        List<String> list = new ArrayList();
        for(int i=0; i<words.length; i++){
            list.add(words[i]);
        }
        
        find(begin, target, list, 0);
        
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        return answer;
    }
    
    public void find(String begin, String target, List<String> list, int cnt){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }else if(list.isEmpty() && !begin.equals(target)){
            return;
        }
        
        for(int i=0; i<list.size(); i++){
            String temp = list.get(i);
            char[] a = temp.toCharArray();
            char[] b = begin.toCharArray();
            
            int diff = 0;
            for(int j=0; j<b.length; j++){
                if(a[j]!= b[j]){
                    diff++;
                }
            }
            
            if(diff == 1){
                list.remove(i);
                find(temp, target, list, cnt+1);
                list.add(temp);
            }
        }
    }
    
    public boolean checkDone(String target, String[] words){
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                return true;
            }
        }
        return false;
    }
}