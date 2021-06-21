import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

	private static int N;
	private static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> dq = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for (int i = 1; i <= N; i++) {
			dq.offerLast(i);
		}
		
		int order = 1;
		while (dq.size() > 1) {
			int first = dq.pollFirst();
			
			if (order == K) {
				sb.append(first).append(", ");
				order = 1;
			} else {
				order++;
				dq.offerLast(first);
			}
		}

		sb.append(dq.pollFirst());
		sb.append(">");
		System.out.println(sb);
	} // end of main

} // end of class
