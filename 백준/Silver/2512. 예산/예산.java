import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//2512 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());

		String[] temp = br.readLine().trim().split(" ");
		int[] arr = new int[N];
		int sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			sum += arr[i];
		}
		
		int ideal = Integer.parseInt(br.readLine().trim());
		Arrays.sort(arr);
		
		if(sum <= ideal) {
			System.out.println(arr[arr.length-1]);
		}else {
			
			int idx = arr.length-1;
			
			//상한액 기준을 arr[idx]로 설정
			while (sum > ideal && idx >= 0) {
				idx--;
				if (idx < 0) break;
				
				sum = 0;
				for (int i = 0; i <= idx; i++) {
					sum += arr[i];
				}
				sum += arr[idx]*(arr.length-1-idx);
			}//while
			
			// idx < 0인 경우 처리 (예산이 너무 적은 경우)
			if (idx < 0) {
				int maxLimit = 0;
				// 가능한 최대 상한액 찾기
				for (int limit = 0; limit <= arr[0]; limit++) {
					int total = 0;
					for (int i = 0; i < arr.length; i++) {
						total += Math.min(arr[i], limit);
					}
					if (total <= ideal) {
						maxLimit = limit;  // 조건을 만족하는 최대값 계속 업데이트
					}
				}
				System.out.println(maxLimit);
				return;
			}
			
			// 정상적인 경우: arr[idx]부터 시작해서 최대 상한액 찾기
			int res = arr[idx];
			
			int max = 0;
			if (idx + 1 < arr.length) {
				max = arr[idx + 1];
			} else {
				max = arr[idx];
			}
			
			// arr[idx]부터 max까지 정확한 계산으로 최대 상한액 찾기
			for (int limit = arr[idx]; limit <= max; limit++) {
				int total = 0;
				for (int i = 0; i < arr.length; i++) {
					total += Math.min(arr[i], limit);
				}
				
				if (total <= ideal) {
					res = limit;  // 조건을 만족하는 최대값 계속 업데이트
				} else {
					break;  // 예산 초과하면 더 이상 진행 안 함
				}
			}
			
			System.out.println(res);
			
		}//else
		
	}
}