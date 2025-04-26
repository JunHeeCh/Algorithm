import java.util.Map;
import java.util.HashMap;


class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int len = friends.length;
        int[][] count = new int[len][len];    //주고 받은 개수
        int[] val = new int[len];    //선물 지수
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i<len; i++){
            map.put(friends[i], i);
        }
        
        for(int i = 0; i < gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            count[map.get(temp[0])][map.get(temp[1])] ++;
            val[map.get(temp[0])] ++;
            val[map.get(temp[1])] --;
        }
        
        int[] get = new int[len]; //받을 선물 개수
        
        for(int i = 0; i<len-1; i++){
            for(int j = i+1; j<len; j++){
                //i와 j의 관계에서 선물을 주고 받을지 결정하기 
                int a = count[i][j];
                int b = count[j][i];
                
                if(a>b){
                    get[i]++;
                }else if(b>a){
                    get[j]++;
                }else{
                    if(val[i]>val[j]){
                        get[i]++;
                    }else if(val[j] > val[i]){
                        get[j]++;
                    }
                }
                
            }
        }
        
        int answer = 0;
        for(int i = 0; i < get.length; i++){
            if(answer < get[i]){
                answer = get[i];
            }
        }
        return answer;
    }
   
}