import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21317_징검다리건너기 {

	private static int N;
	private static int[] small;
	private static int[] big;
	private static int K;
	private static int ans;
	private static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		small = new int[N-1];
		big = new int[N-1];
		ans = Integer.MAX_VALUE;
		flag = false; // 가장 큰 점프 썼는지
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			small[i] = Integer.parseInt(st.nextToken());
			big[i] = Integer.parseInt(st.nextToken());
		}
		
		K = Integer.parseInt(bf.readLine());
		go(0, 0);
		System.out.println(ans);
	} // end of main

	private static void go(int now, int energy) {
		if (now >= N) return;
		if (now == N-1) {
			ans = Math.min(ans, energy);
			return;
		}
		
		go(now+1, energy+small[now]);
		go(now+2, energy+big[now]);
		if (!flag) {
			flag = true;
			go(now+3, energy+K);
			flag = false;
		}
	}

} // end of class
