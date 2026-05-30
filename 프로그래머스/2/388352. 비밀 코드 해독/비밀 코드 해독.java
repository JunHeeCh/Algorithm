import java.util.*;

class Solution {
    
    Set<String> set = new HashSet();
    int N; // 1~n까지의 숫자 조합 
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        // 서로 다른 숫자, 오름차순 
        
        // q[0]는 시도한 정수, ans[0]는 그 중에서 맞은 숫자를 의미 
        // q[0]의 조합과 ans[0]의 조합을 가지고 만들 수 있는 모든 조합을 만들고 
        N = n; 
        
        // 총 5개 숫자를 만들어야 하는데 
        int[] arr = new int[ans[0]];
        make(q[0], arr, 0, 0);
        
        // i=1~q.length-1 까지 가능한지를 보면서 필터링을 하면 될 듯 
        for(int i=1; i<q.length; i++){
            // set에 있는 후보가 정답이라는 가정 하에 q[i]를 평가했을 때 ans[i]와 일치하는지를 구분하면 될 듯 
            filter(q[i], ans[i]);
        }
        return set.size();
    }
    
    public void make(int[] tryy, int[] arr, int start, int idx){
        if(idx==arr.length){
            int[] candidate = new int[5];
            for(int i=0; i<idx; i++){
                candidate[i] = tryy[arr[i]];
            }
            // idx 부터 4까지는 아무 숫자나 넣어서 채워야지 
            boolean[] visited = new boolean[N+1];
            for(int i=0; i<tryy.length; i++){
                visited[tryy[i]] = true;
            }
            
            fulfill(candidate, visited, idx);
            return;
        }
        
        // try 중에서 arr 개수 만큼 맞췄음 
        for(int i=start; i<5; i++){
            arr[idx] = i; // 인덱스 번호를 저장하자 
            make(tryy, arr, i+1, idx+1);
        }
    }
    
    public void fulfill(int[] candidate, boolean[] visited, int idx){
        if(idx==5){
            // 이제 오름차순 정렬해서 set에 추가하자 
            int[] copy = candidate.clone();  // ✅ 복사본만 정렬
            Arrays.sort(copy);
            set.add(Arrays.toString(copy));
            return;
        }
        
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            candidate[idx] = i;
            visited[i] = true;
            fulfill(candidate, visited, idx+1);
            visited[i] = false;
        }
    }
    
    public void filter(int[] q, int ans){
        Set<Integer> qSet = new HashSet<>();
        for(int num : q) qSet.add(num);

        Iterator<String> iter = set.iterator();
        while(iter.hasNext()){
            String st = iter.next();
            String[] arr = st.substring(1, st.length()-1).split(", ");
            int cnt = 0;
            for(String s : arr){
                if(qSet.contains(Integer.parseInt(s.trim()))) cnt++;
            }
            if(cnt != ans) iter.remove();
        }
    }
}