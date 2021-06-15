import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17952_과제는끝나지않아 {

	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		Deque<int[]> dq = new LinkedList<>();
		int ans = 0; // 받은 점수
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int order = Integer.parseInt(st.nextToken());
			
			if (order == 1) {
				// 현재 받은 과제 넣기
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if ((time-1) == 0) ans += score; // 받자마자 과제 끝낸 경우
				else dq.offerFirst(new int[] {score, time-1});
			}
			
			else if (order == 0) {
				if (dq.isEmpty()) continue;
				// 원래 받은 과제 시간 줄이기
				int[] tmp = dq.pollFirst();
				if ((tmp[1] - 1) == 0) ans += tmp[0];
				else dq.offerFirst(new int[] {tmp[0], tmp[1] - 1});
			}
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
