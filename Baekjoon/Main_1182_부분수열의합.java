import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {

	private static int N, S;
	private static int[] nums;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ans = 0;
		nums = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		go(0, 0, true);
		System.out.println(ans);
	} // end of main

	private static void go(int idx, int sum, boolean first) {
		if (!first && sum == S) {
			++ans;
		}
		
		for (int i = idx; i < N; i++) {
			if (first) first = false;
			go(i+1, sum + nums[i], first);
		}
	}

} // end of class
