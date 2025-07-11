import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine().trim());
            Map<String, Integer> map = new HashMap<>();
            
            for (int i = 0; i < N; i++) {
                String[] temp = br.readLine().trim().split(" ");
                String category = temp[1];
                
                map.put(category, map.getOrDefault(category, 0) + 1);
            }
            
            int count = 1;
            for (int value : map.values()) {
                count *= (value + 1);
            }
            
            System.out.println(count - 1);
        }
    }
}