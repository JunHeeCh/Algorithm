class Solution {
    public int solution(String name) {
        int answer = 0; 
        
        int move = name.length()-1; // 커서 이동 횟수 

        char[] temp = name.toCharArray();
        for(int i=0; i<temp.length; i++){
            answer += Math.min(temp[i]-'A','Z'-temp[i]+1);
        }
        
        for(int i=0; i<temp.length; i++){
            int next = i+1;
            while(next < temp.length && temp[next] == 'A'){
                next++;
            }
            move = Math.min(move, i*2+temp.length-next);
            move = Math.min(move, (temp.length-next) * 2 + i);
        }
        return answer+move;
    }
}