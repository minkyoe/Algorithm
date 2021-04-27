import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15665_N과M11 {

	private static int N, M;
	private static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		go(0, "");
	}

	private static void go(int cnt, String s) {
		if (cnt == M) {
			System.out.println(s);
			return;
		}
		
		int prev = -1;
		for (int i = 0; i < nums.length; i++) {
			if (prev == nums[i]) continue;
			prev = nums[i];
			go(cnt+1, s + prev + " ");
		}
	}

}
