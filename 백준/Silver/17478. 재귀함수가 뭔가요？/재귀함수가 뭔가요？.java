import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String temp = "____";
	static String q1;
	static String a1;
	static String a2;
	static String a3;
	static String res;
	static String e1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		q1 = "\"재귀함수가 뭔가요?\"";
		a1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		a2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		a3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		res = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		e1 = "라고 답변하였지.";

		sb.append(start + "\n");
		call(sb, N, 0);

		System.out.println(sb);

	}

	private static void call(StringBuilder sb, int n, int time) {
		if (n == 0) {
			addtemp(sb, time);
			sb.append(q1 + "\n");
			addtemp(sb, time);
			sb.append(res + "\n");
			addtemp(sb, time);
			sb.append(e1 + "\n");
			return;
		}
		addtemp(sb, time);
		sb.append(q1 + "\n");
		addtemp(sb, time);
		sb.append(a1 + "\n");
		addtemp(sb, time);
		sb.append(a2 + "\n");
		addtemp(sb, time);
		sb.append(a3 + "\n");
		call(sb, n - 1, time + 1);
		addtemp(sb, time);
		sb.append(e1 + "\n");
	}

	private static void addtemp(StringBuilder sb, int time) {
		for (int i = 0; i < time; i++) {
			sb.append(temp);
		}
	}

}
