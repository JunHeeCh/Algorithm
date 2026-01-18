import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        boolean flag = true;
        
        Map<String, Integer> map1 = new HashMap();
        
        for(int i=0; i<str1.length()-1; i++){
            String temp = str1.substring(i, i+2);
            temp = temp.toLowerCase();
            flag = true;
            for(int j=0; j<temp.length(); j++){
                if(temp.charAt(j) < 'a' || temp.charAt(j) > 'z'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                map1.put(temp, map1.getOrDefault(temp, 0)+1);
            }
        }
        
        Map<String, Integer> map2 = new HashMap();
        
        for(int i=0; i<str2.length()-1; i++){
            String temp = str2.substring(i, i+2);
            temp = temp.toLowerCase();
            flag = true;
            for(int j=0; j<temp.length(); j++){
                if(temp.charAt(j) < 'a' || temp.charAt(j) > 'z'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                map2.put(temp, map2.getOrDefault(temp, 0)+1);
            }
        }
        
        int inter=0, union=0;
        
        Set<String> keys = new HashSet();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        
        for(String key : keys){
            int a = map1.getOrDefault(key, 0);
            int b = map2.getOrDefault(key, 0);
            inter += Math.min(a,b);
            union += Math.max(a,b);
        }
        
        if(inter == 0 && union == 0){
            return 65536;
        }
        
        answer = (int)((float)inter / union * 65536);
        return answer;
    }
}