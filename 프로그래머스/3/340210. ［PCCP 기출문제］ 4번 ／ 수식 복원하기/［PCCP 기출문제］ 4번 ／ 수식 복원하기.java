import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> list = new ArrayList();
        
        boolean[] jin = new boolean[10];
        for(int i=2; i<=9; i++){
            jin[i] = true;
        }
        
        int globalMax = 0;
        for (String exp : expressions) {
            for (int d = 1; d <= 8; d++) {
                if (exp.contains(d + "")) globalMax = Math.max(globalMax, d);
            }
        }
        for (int i = 2; i <= globalMax; i++) jin[i] = false;
        
        // 수식 결과가 X 거나 숫자거나
        // 숫자인 경우를 확인해서 진법의 범위를 찾고
        // X인 경우, 진법에 따라 결과가 같으면 숫자, 아니면 ?
        
        for(int i=0; i<expressions.length; i++){
            if(expressions[i].contains("X")) continue;
            check(jin, expressions[i]);
        }
        
        for(int i=0; i<expressions.length; i++){
            if(!expressions[i].contains("X")) continue;
            String res = cal(jin, expressions[i]);
            list.add(expressions[i].replace("X", res));
        }
        
        return list.toArray(new String[0]);
    }
    
    public String cal(boolean[] jin, String exp) {
        String answer = "";
        String[] arr = exp.split(" ");

        int max = 0;
        for (int i = 1; i <= 8; i++) {
            if (exp.contains(i + "")) max = i;
        }

        for (int i = max+1; i < jin.length; i++) {
            if (!jin[i]) continue;

            int a = Integer.parseInt(arr[0], i);
            int b = Integer.parseInt(arr[2], i);
            int calVal = arr[1].equals("+") ? a + b : a - b;

            String cur = Integer.toString(calVal, i);

            if (answer.equals("")) {
                answer = cur;
            } else if (!answer.equals(cur)) {
                return "?";
            }
        }
        return answer;
    }

    public void check(boolean[] jin, String exp) {

        String[] arr = exp.split(" ");
        String c = arr[4];   

        for (int i = 2; i < jin.length; i++) {
            if (!jin[i]) continue;
            int a = Integer.parseInt(arr[0], i);
            int b = Integer.parseInt(arr[2], i);
            int calVal = arr[1].equals("+") ? a + b : a - b;

            if (!Integer.toString(calVal, i).equals(c)) {
                jin[i] = false;
            }
        }
    }
}