import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int mul = a * b * c;
        int[] arr = new int[10];

        // mul이 0이어도 정상 처리됨
        do {
            arr[mul % 10]++;
            mul /= 10;
        } while (mul != 0);

        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}
