class Solution {
    int answer;
    String goal;
    int count = 0;
    public int solution(String word) {
        answer = 0;
        goal = word;
        
        char[] words = {'A','E','I','O','U'};
        char[] make = new char[5];
        
        dfs(words, 0, make);
        return answer;
    }
    
    public void dfs(char[] word, int idx, char[] make){
        if(answer > 0) return;
        
        if(idx > 0){
            count++;
        }
        if(new String(make, 0, idx).equals(goal)){
            answer = count;
            return;
        }
        
        if(idx == make.length) return;
        
        for(int i=0; i<word.length; i++){
            make[idx] = word[i];
            dfs(word, idx+1, make);
        }
    }
}