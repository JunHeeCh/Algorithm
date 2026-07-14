import java.util.*;

/*
자리수에 따라서 26*자리수 만큼이 만들어지는데 
자리수 <= 11 
*/

class Solution {
    
    public String solution(long n, String[] bans) {
        String answer = "";
        
        List<String>[] cnt = new ArrayList[12];
        for(int i=0; i<12; i++){
            cnt[i] = new ArrayList();
        }
        
        for(int i=0; i<bans.length; i++){
            cnt[bans[i].length()].add(bans[i]);
        }
        
        long mul = 1;
        int del = 0;
        long aggregate = 0; // 누적 개수 
        long prev = 0;
        
        for(int i=1; i<12; i++){
            // i는 자리수 
            prev = aggregate;
            mul *= 26; // 해당 자리수에서 만들어지는 개수 
            del = cnt[i].size(); // 해당 자리수에서 지워지는 개수 
            // 만들어진 수 - 지워진 수 = 실제 해당 자리수에 생성되는 주문 개수 
            aggregate += mul-del;
            if(aggregate >= n){
                // i 자리수 내에 우리가 원하는 게 있다 
                // prev번까지가 i-1자리수에서 만든 주문의 개수 
                // prev+1 부터 n까지 만들면 되는데, 그 중에 cnt에 있는 것만 빼고 
                // n-prev개를 만들면 됨 (n-prev)번째 단어가 알고 싶다!
                answer = make(n-prev, i, cnt[i]);
                break;
            }
        }
        
        return answer;
    }
    
    public String make(long n, int len, List<String> ban){

        char[] word = new char[len];
        
        for(int i=0; i<len; i++){
            // word[i]를 결정해야 하는데 
            for(char c = 'a'; c<= 'z'; c++){
                word[i] = c;
                String prefix = new String(word, 0, i+1);
                long remain = len -i -1;
                long total = pow26(remain);
                int banCount = 0;
                for(String b : ban){
                    if(b.startsWith(prefix)){
                        banCount++;
                    }
                }
                long cnt = total - banCount;
                if(n <= cnt){
                    break;
                }else{
                    n -= cnt;
                }
            }
            
        }
        
        return new String(word);
    }
    
    public long pow26(long e){
        long r = 1;
        for(int i=0; i<e; i++) r *= 26;
        return r;
    }
    
}