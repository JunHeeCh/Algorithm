/*
카드가 100장 (1~100)
2~100 사이 수(n)를 정해서, 1~n까지의 카드 준비, n개의 상자 준비 
무작위로 넣어서, 임의의 상자를 하나 픽, 해당 상자 안의 카드 숫자의 상자를 또 픽, 이렇게 계속 열다보면 이미 열린 상자가 나올때까지 진행 -> 이게 1번 그룹 
나머지 중에서 다시 동일하게 진행 -> 2번 그룹

2번 그룹이 0개면 0점 

*/
import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        for(int i=0; i<cards.length; i++){
            boolean[] visited = new boolean[cards.length];
            int a = pick(visited, cards, i);
            if(a==cards.length){
                continue;
            }
            for(int j=0; j<cards.length; j++){
                if(visited[j]) continue;
                int b = pick(visited, cards, j);
                answer = Math.max(answer, a*b);
            }
        }
        
        return answer;
    }
    
    public int pick(boolean[] visited, int[] cards, int start){
        // start 상자를 열었을 때 그룹의 크기를 반환하라 
        int now = start;
        visited[now] = true;
        int cnt = 1;
        while(!visited[cards[now]-1]){
            now = cards[now]-1;
            visited[now] = true;
            cnt++;
        }
        return cnt;
    }
}