class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        int l = s.length();
        
        for(int i=0; i<l; i++){
            int a = get(s, i, i);
            int b = get(s,i,i+1);
            
            answer = Math.max(answer,Math.max(a,b));
        }

        return answer;
    }
    
    public int get(String s, int left, int right){
        char[] st = s.toCharArray();
        
        while(left >= 0 && right < st.length && st[left]==st[right]){
            left--;
            right++;
        }
        
        return right-left-1;
        
    }
}