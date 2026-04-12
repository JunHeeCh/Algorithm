import java.util.*;

class Solution {
    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*");
        
        List<Long> list = new ArrayList();
        
        while(st.hasMoreTokens()){
            list.add(Long.parseLong(st.nextToken()));
        }
        
        st = new StringTokenizer(expression, "0123456789");
        List<String> oper = new ArrayList();
        
        while(st.hasMoreTokens()){
            oper.add(st.nextToken());
        }
        
        String[][] priority = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
        };
        
        long answer = 0;
        
        for(int i=0; i<priority.length; i++){
            List<Long> num = new ArrayList(list);
            List<String> op = new ArrayList(oper);
            for(int j=0; j<priority[i].length; j++){
                for(int k = 0; k < op.size(); ) {
                    if(op.get(k).equals(priority[i][j])) {
                        long a = num.get(k);
                        long b = num.get(k+1);
                        long res = cal(a, b, priority[i][j]);

                        num.set(k, res);
                        num.remove(k+1);
                        op.remove(k);

                        // k 그대로 (증가 X)
                    } else {
                        k++;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(num.get(0)));
        }
        
        return answer;
    }
    
    public long cal (long a, long b, String op){
        switch(op){
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
        }
        return 0;
    }
}