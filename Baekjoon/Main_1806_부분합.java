import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {

	private static int N, S, ans;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ans = Integer.MAX_VALUE;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0; int right = 0;
		long sum = arr[0];
		
		while (left <= right && right < N) {
			if (sum < S) {
				++right;
				if (right == N) break;
				sum += arr[right];
			} else if (sum > S) {
				ans = Math.min(ans, right - left + 1);
				sum -= arr[left++];
			} else {
				ans = Math.min(ans, right - left + 1);
				sum -= arr[left++];
			}
		}
		
		if (ans == Integer.MAX_VALUE) System.out.println("0");
		else System.out.println(ans);
	} // end of main

} // end of class
