import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Integer> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') st.push(-1);
            else if (c == '[') st.push(-2);
            else {
                int sum = 0;

                while (!st.isEmpty() && st.peek() > 0) {
                    sum += st.pop();
                }

                if (st.isEmpty()) {
                    System.out.println(0);
                    return;
                }

                int open = st.pop();

                if (c == ')' && open == -1) {
                    st.push(sum == 0 ? 2 : sum * 2);
                } else if (c == ']' && open == -2) {
                    st.push(sum == 0 ? 3 : sum * 3);
                } else {
                    System.out.println(0);
                    return;
                }
            }
        }

        int ans = 0;
        while (!st.isEmpty()) {
            int v = st.pop();
            if (v < 0) {
                System.out.println(0);
                return;
            }
            ans += v;
        }

        System.out.println(ans);
    }
}