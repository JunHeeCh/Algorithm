import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int p = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		List<int[]> list = new ArrayList(); // 인원수, 시작레벨, 마지막레벨 -> 방 정보
		List[] numbers = new ArrayList[p]; // 들어간 사람들 넘버
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = new ArrayList<Integer>();
		}
		String[] people = new String[p];
		Map<String, Integer> map = new HashMap();

		for (int i = 0; i < p; i++) {
			temp = br.readLine().trim().split(" ");
			int level = Integer.parseInt(temp[0]);
			String name = temp[1];
			boolean flag = false;

			people[i] = name;
			map.put(name, level);

			for (int j = 0; j < list.size(); j++) {
				int[] now = list.get(j);
				if (now[0] >= m || level < now[1] || level > now[2])
					continue;

				// j번째 방에 넣을 수 있다
				flag = true;
				list.get(j)[0]++;
				numbers[j].add(i);
				break;
			}

			if (!flag) {
				list.add(new int[] { 1, level - 10, level + 10 });
				numbers[list.size() - 1].add(i);
			}
		}

		for (int j = 0; j < list.size(); j++) {
			int[] now = list.get(j);
			String[] imsi = new String[now[0]];

			// numbers[j]
			for (int i = 0; i < numbers[j].size(); i++) {
				imsi[i] = people[(int) numbers[j].get(i)];
			}

			Arrays.sort(imsi);

			if (now[0] >= m) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			for (int i = 0; i < imsi.length; i++) {
				System.out.println(map.get(imsi[i]) + " " + imsi[i]);
			}
		}

	}

}
