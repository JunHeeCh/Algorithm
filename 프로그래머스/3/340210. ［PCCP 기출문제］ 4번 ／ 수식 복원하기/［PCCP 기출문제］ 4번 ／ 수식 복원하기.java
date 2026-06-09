import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {

        boolean[] globalPossible = new boolean[10];
        Arrays.fill(globalPossible, true);
        globalPossible[0] = globalPossible[1] = false;

        // 1단계: 확정 수식으로 가능 진법 교집합
        for (String expr : expressions) {
            String[] nums = expr.split("[+\\-=]");
            String a   = nums[0].trim();
            String b   = nums[1].trim();
            String res = nums[2].trim();

            if (res.equals("X")) continue;

            boolean isPlus = expr.contains("+");
            boolean[] possible = new boolean[10];

            for (int j = 2; j <= 9; j++) {
                try {
                    int A = Integer.parseInt(a, j);
                    int B = Integer.parseInt(b, j);
                    int C = Integer.parseInt(res, j);
                    possible[j] = isPlus ? (A + B == C) : (A - B == C);
                } catch (NumberFormatException e) {
                    possible[j] = false;
                }
            }

            for (int j = 2; j <= 9; j++) {
                if (!possible[j]) globalPossible[j] = false;
            }
        }

        // 2단계: X 수식의 피연산자 minBase로 추가 필터링
        for (String expr : expressions) {
            String[] nums = expr.split("[+\\-=]");
            String a   = nums[0].trim();
            String b   = nums[1].trim();
            String res = nums[2].trim();

            if (!res.equals("X")) continue;

            int minBase = 2;
            for (char c : (a + b).toCharArray()) {
                if (Character.isDigit(c)) {
                    minBase = Math.max(minBase, (c - '0') + 1);
                }
            }

            for (int j = 2; j < minBase; j++) {
                globalPossible[j] = false;
            }
        }

        // 3단계: X 수식 결과 계산
        String[] answer = new String[expressions.length];

        for (int i = 0; i < expressions.length; i++) {
            String expr = expressions[i];
            String[] nums = expr.split("[+\\-=]");
            String a   = nums[0].trim();
            String b   = nums[1].trim();
            String res = nums[2].trim();

            if (!res.equals("X")) {
                answer[i] = expr;
                continue;
            }

            boolean isPlus = expr.contains("+");

            int minBase = 2;
            for (char c : (a + b).toCharArray()) {
                if (Character.isDigit(c)) {
                    minBase = Math.max(minBase, (c - '0') + 1);
                }
            }

            String resStr = null;
            boolean isQuestion = false;

            for (int j = minBase; j <= 9; j++) {
                if (!globalPossible[j]) continue;
                try {
                    int A = Integer.parseInt(a, j);
                    int B = Integer.parseInt(b, j);
                    int cal = isPlus ? A + B : A - B;
                    String calStr = Integer.toString(cal, j);

                    if (resStr == null) {
                        resStr = calStr;
                    } else if (!resStr.equals(calStr)) {
                        isQuestion = true;
                        break;
                    }
                } catch (NumberFormatException e) {
                    // skip
                }
            }

            answer[i] = isQuestion || resStr == null
                ? expr.replace("X", "?")
                : expr.replace("X", resStr);
        }

        // 4단계: 원본이 X였던 수식만 반환
        List<String> result = new ArrayList<>();
        for (int i = 0; i < expressions.length; i++) {
            if (expressions[i].contains("X")) {
                result.add(answer[i]);
            }
        }
        return result.toArray(new String[0]);
    }
}