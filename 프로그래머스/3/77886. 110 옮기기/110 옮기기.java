class Solution {

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;

            // 문자열을 순회하며 "110" 패턴을 제거하고 카운트
            for (char c : s[i].toCharArray()) {
                sb.append(c);
                int len = sb.length();
                if (len >= 3 && 
                    sb.charAt(len - 1) == '0' && 
                    sb.charAt(len - 2) == '1' &&
                    sb.charAt(len - 3) == '1') {
                    sb.setLength(len - 3);  // "110" 제거
                    count++;
                }
            }

            // 삽입 위치: 마지막 '0' 뒤 (없으면 맨 앞)
            int index = sb.lastIndexOf("0");
            sb.insert(index + 1, "110".repeat(count));

            answer[i] = sb.toString();
        }

        return answer;
    }

}