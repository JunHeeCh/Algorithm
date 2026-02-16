import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer;
        
        List<String> list = new ArrayList(); // 끝난 순서대로 담기 
        Stack<work> stack = new Stack(); // 임시 저장소 
        
        work[] works = new work[plans.length];
        for(int i=0; i<plans.length; i++){
            String[] startT = plans[i][1].split(":");
            int st = Integer.parseInt(startT[0])*60 + Integer.parseInt(startT[1]);
            int sp = Integer.parseInt(plans[i][2]);
            works[i] = new work(plans[i][0], st, sp);
        }
        
        Arrays.sort(works); // 시작 시간 순으로 정렬 
        
        for(int i=0; i<works.length; i++){
            if(stack.isEmpty()){
                stack.push(works[i]);
            }else{
                int time = works[i].start - stack.peek().start;
                while(time > 0 && !stack.isEmpty()){
                    work now = stack.pop();
                    if(now.spent <= time){
                        time -= now.spent;
                        list.add(now.name);
                    }else{
                        now.spent -= time;
                        time = 0;
                        stack.push(now);
                    }
                }
                stack.push(works[i]);
            }
        }
        
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }
        
        answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

class work implements Comparable<work>{
    String name;
    int start;
    int spent;
    
    public work(String name, int start, int spent){
        this.name = name;
        this.start = start;
        this.spent = spent;
    }
    
    public int compareTo(work o){
        return Integer.compare(this.start, o.start);
    }
}