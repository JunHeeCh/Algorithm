import java.util.*;

class Solution {
    public int[] solution(String s) {
        String temp = s.substring(2,s.length()-2);
        String[] arr = temp.split("\\},\\{");
        
        Arrays.sort(arr, (a,b)-> a.length()-b.length());
        
        List<Integer> list = new ArrayList();
        Set<Integer> set = new HashSet();
        
        list.add(Integer.parseInt(arr[0]));
        set.add(Integer.parseInt(arr[0]));
        for(int i=1; i<arr.length; i++){
            String[] tmp = arr[i].split(",");
            for(int j=0; j<tmp.length; j++){
                if(set.contains(Integer.parseInt(tmp[j]))) continue;
                list.add(Integer.parseInt(tmp[j]));
                set.add(Integer.parseInt(tmp[j]));
                break;
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}