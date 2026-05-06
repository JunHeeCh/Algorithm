import java.util.*;

class Solution {
    
    List<Integer> list = new ArrayList();
    
    public int solution(String[][] relation) {
        int ans = 0;
        
        int n = relation.length; 
        int m = relation[0].length; 
        
        for(int i=1; i<=m; i++){
            int[] arr = new int[i];
            combination(relation, arr, 0, 0);
        }
        
        
        // 3. 만든 조합 중에 더 작은 사이즈가 겹치는 게 있다면 제거 
        for(int i=0; i<list.size(); i++){
            boolean flag = true;
            // list.get(i)가 테스트 대상
            // list.get(j)가 포함된다면 false
            for(int j=0; j<i; j++){
                if((list.get(i) & list.get(j)) == list.get(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++;
            }
        }
        
        
        return ans;
    }
    
    // 1. 조합을 만들어라 
    // 1개~m개를 선택하는 조합을 생성 
    public void combination(String[][] relation, int[] arr, int idx, int start){
        if(idx == arr.length){
            if(check(relation, arr)){
                int num = 0;
                for(int j=0; j<arr.length; j++){
                    num += Math.pow(2,arr[j]);
                }
                list.add(num);
            }
            return;
        }
        
        for(int i=start; i<relation[0].length; i++){
            arr[idx] = i;
            combination(relation, arr, idx+1, i+1);
        }
    }
    
    // 2. set으로 만들었을 때, 겹치는 게 있는지 확인
    public boolean check(String[][] relation, int[] arr){
        Set<String> set = new HashSet();
        
        for(int i=0; i<relation.length; i++){
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<arr.length; j++){
                sb.append(relation[i][arr[j]]+" ");
            }
            
            set.add(sb.toString());
        }
        
        if(set.size() == relation.length){
            return true;
        }
        return false;
    }
}