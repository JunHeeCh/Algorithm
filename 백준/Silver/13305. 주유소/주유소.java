import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] length = new int[N - 1];  // 도로 길이는 N-1개
        int[] price = new int[N];       // 모든 가격을 읽어야 함

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < length.length; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < N; i++) {  // 모든 가격을 읽되
            price[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = price[0];   // long 타입으로 변경
        long res = 0;

        for (int i = 0; i < length.length; i++) {
            minPrice = Math.min(minPrice, price[i]);
            res += minPrice * length[i];
        }

        System.out.println(res);
    }
}