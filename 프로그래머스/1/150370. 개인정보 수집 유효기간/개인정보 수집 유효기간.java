import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int[] arr = new int[28]; // 약관 정보 
        for(int i=0; i<terms.length; i++){
            String[] temp = terms[i].split(" ");
            arr[terms[i].charAt(0)-'A'] = Integer.parseInt(temp[1]);
        }
        
        List<Integer> list = new ArrayList();
        
        for(int i=0; i<privacies.length; i++){
            int idx = i+1;
            String[] temp = privacies[i].split(" ");
            if(check(today, temp[0], arr[privacies[i].charAt(11)-'A'])){
                list.add(idx);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    public boolean check(String today, String past, int len){
        // 파기해야 하면 true 반환하기 
        
        String[] now = today.split("\\.");
        int ty = Integer.parseInt(now[0]);
        int tm = Integer.parseInt(now[1]);
        int td = Integer.parseInt(now[2]);
        
        now = past.split("\\.");
        int py = Integer.parseInt(now[0]);
        int pm = Integer.parseInt(now[1]);
        int pd = Integer.parseInt(now[2]);
        
        pm += len;
        pd--;
        if(pd<1){
            pd = 28;
            pm--;
        }
        while(pm>12){
            py++;
            pm-=12;
        }
        
        // past+len 계산 완료 -> 해당 past 보다 today가 크면 파기 -> true 반환 
        if(ty>py) return true;
        if(ty==py){
            if(tm>pm) return true;
            if(tm==pm){
                if(td>pd) return true;
            }
        }
        return false;
    }
}