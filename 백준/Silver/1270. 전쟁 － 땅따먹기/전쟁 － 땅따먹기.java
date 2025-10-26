import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            Map<Long, Integer> map = new HashMap<>();  // Long으로 변경!
            String answer = "SYJKGW";

            for (int j = 0; j < n; j++) {
                long num = Long.parseLong(st.nextToken());  // long으로 파싱
                int cnt = map.getOrDefault(num, 0) + 1;
                map.put(num, cnt);
            }

            for (long k : map.keySet()) {  // long으로 변경
                if (map.get(k) * 2 > n) {
                    answer = String.valueOf(k);
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}