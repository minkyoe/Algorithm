import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {

	private static int N;
	private static int K;
	private static int[] nums;
	private static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cnt = 0;
		nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = N-1; i >= 0; i--) {
			if (nums[i] > K) continue;
			
			int mok = K / nums[i];
			K -= nums[i] * mok;
			cnt += mok;
			
			if (K == 0) break;
		}
		
		System.out.println(cnt);
	} // end of main

} // end of class
