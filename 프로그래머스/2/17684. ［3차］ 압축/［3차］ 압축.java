import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer;
        List<Integer> list = new ArrayList();
        Map<String, Integer> map = new HashMap();
        
        for(int i=0; i<26; i++){
            map.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        int value = 27;
                
        while(msg.length() != 0){
        	if(map.containsKey(msg)) {
        		list.add(map.get(msg));
        		break;
        	}
            //현재 입력과 일치하는 가장 긴 문자열 w를 찾아라
            String w=null;
            int num=0; // 출력 번호 
            for(int i=1; i<=msg.length(); i++){
                w = msg.substring(0, i);
                if(!map.containsKey(w)){
                    msg = msg.substring(i-1, msg.length());
                    break;
                }
                num = map.get(w);
            }
            //w는 사전에 추가할 글자 
            map.put(w, value++);
            list.add(num);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}