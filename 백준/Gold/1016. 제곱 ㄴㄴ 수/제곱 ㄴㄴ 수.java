import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().trim().split(" ");
        
        long min = Long.parseLong(temp[0]);
        long max = Long.parseLong(temp[1]);
        
        // 범위 크기만큼만 boolean 배열 사용 (메모리 효율적)
        boolean[] isSquareMultiple = new boolean[(int)(max - min + 1)];
        
        // √max까지의 제곱수들 확인
        for (long i = 2; i * i <= max; i++) {
            long square = i * i;
            
            // min 이상에서 square의 첫 번째 배수 찾기
            long start = ((min - 1) / square + 1) * square;
            
            // square의 배수들을 직접 배열에 표시 (Set 사용 안함)
            for (long j = start; j <= max; j += square) {
                isSquareMultiple[(int)(j - min)] = true;
            }
        }
        
        // 제곱ㄴㄴ수 개수 계산
        int count = 0;
        for (boolean marked : isSquareMultiple) {
            if (!marked) count++;
        }
        
        System.out.println(count);
    }
}