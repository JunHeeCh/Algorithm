import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        int digit = 10;
        while (n >= digit) {
            int r = n % digit;
            if (r >= digit / 2) {
                n += digit - r;
            } else {
                n -= r;
            }
            digit *= 10;
        }

        System.out.println(n);
    }
}