import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14929_귀찮아SIB {

	private static int N;
	private static int[] nums;
	private static long ans;
	private static int[] sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		nums = new int[N+1];
		sum = new int[N+1];
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + nums[i]; 
		}

		// (2 * 2) + (2 * 3) = 2 * (2 + 3) 원리 활용 
		for (int i = 1; i < N; i++) {
			ans += nums[i] * getSum(i);
		}
		
		System.out.println(ans);
	} // end of main

	private static int getSum(int from) {
		return sum[N] - sum[from];
	}

} // end of class
