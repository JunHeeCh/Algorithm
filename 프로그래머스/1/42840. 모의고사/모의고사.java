import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        // 1번 = 1, 2, 3, 4, 5
        // 2번 = 2, 1, 2, 3, 2, 4, 2, 5
        // 3번 = 3, 3, 1, 1, 2, 2, 4, 4, 5, 5
        
        Queue<Integer> q1 = new ArrayDeque();
        Queue<Integer> q2 = new ArrayDeque();
        Queue<Integer> q3 = new ArrayDeque();
        
        Collections.addAll(q1, 1,2,3,4,5);
        Collections.addAll(q2, 2, 1, 2, 3, 2, 4, 2, 5);
        Collections.addAll(q3, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        
        int c1=0, c2=0, c3=0;
        for(int i=0; i<answers.length; i++){
            int a = q1.poll();
            int b = q2.poll();
            int c = q3.poll();
            if(a==answers[i]){
                c1++;
            }
            if(b==answers[i]){
                c2++;
            }
            if(c==answers[i]){
                c3++;
            }
            q1.add(a);
            q2.add(b);
            q3.add(c);
        }
        
        int max = c1;
        if(c2>max){
            max = c2;
        }
        if(c3>max){
            max = c3;
        }
        List<Integer> list = new ArrayList();
        if(c1==max){
            list.add(1);
        }
        if(c2==max){
            list.add(2);
        }
        if(c3==max){
            list.add(3);
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}