import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       // 입력
       int N = Integer.parseInt(br.readLine().trim());
       String[] temp = br.readLine().trim().split(" ");
       long[] arr = new long[N];
       
       Map<Long, Integer> map = new HashMap<>();
       for (int i = 0; i < N; i++) {
           arr[i] = Long.parseLong(temp[i]);
           map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
       }
       
       // 로직
       int res = 0;
       
       for (int i = 0; i < N; i++) {
           long target = arr[i];
           
           // target을 map에서 제거
           map.put(target, map.get(target) - 1);
           if (map.get(target) == 0) {
               map.remove(target);
           }
           
           for (int j = 0; j < N; j++) {
               if (i == j) continue; // 자기 자신 제외
               
               long a = arr[j];
               long need = target - a;
               
               // a를 임시로 제거
               map.put(a, map.get(a) - 1);
               if (map.get(a) == 0) {
                   map.remove(a);
               }
               
               boolean found = map.containsKey(need);
               
               // a 복원
               map.put(a, map.getOrDefault(a, 0) + 1);
               
               if (found) {
                   res++;
                   break;
               }
           }
           
           // target 복원
           map.put(target, map.getOrDefault(target, 0) + 1);
       }
       
       // 출력
       System.out.println(res);
   }
}