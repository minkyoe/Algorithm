import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1965_상자넣기 {

	private static int N;
	private static int[] arr;
	private static int[] dp;
	private static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		arr = new int[N];
		dp = new int[N];
		ans = 1;
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		
		System.out.println(ans);

	}

}
