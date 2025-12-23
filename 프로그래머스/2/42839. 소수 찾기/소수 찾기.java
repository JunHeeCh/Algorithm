import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] temp = numbers.toCharArray();
        
        Set<Integer> set = new HashSet();
        
        boolean[] visited = new boolean[temp.length];
        char[] test = new char[temp.length];
        make(set, temp, visited, 0, test);
        
        for(Integer i : set){
            if(isPrime(i)){
                answer++;
            }
        }
        return answer;
    }
    
    public void make(Set set, char[] temp, boolean[] visited, int cnt, char[] test){        
        if(cnt > 0){
            int num = Integer.parseInt(new String(test, 0, cnt));
            set.add(num);
        }
        
        if(cnt == temp.length) return;
        
        for(int i=0; i<temp.length; i++){
            if(!visited[i]){
                visited[i] = true;
                test[cnt] = temp[i];
                make(set, temp, visited, cnt+1, test);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}