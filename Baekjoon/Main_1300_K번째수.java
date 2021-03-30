import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_K번째수 {

	private static int N, k;
	private static long ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		k = Integer.parseInt(bf.readLine());
		ans = Integer.MAX_VALUE;
		
		long left = 1;
		long right = k;
		
		while (left <= right) {
			long mid = (left + right) / 2; // 행렬 내 원소
			
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(N, mid / i);
			}
			
			if (cnt >= k) {
				right = mid - 1;
				ans = mid;
			} else {
				left = mid + 1;
			} 
		}
		
		System.out.println(ans);
	} // end of main

} // end of class
