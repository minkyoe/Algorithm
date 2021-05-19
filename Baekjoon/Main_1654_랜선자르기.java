import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {

	private static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		K = Integer.parseInt(st.nextToken()); // already get
		N = Integer.parseInt(st.nextToken()); // need
		
		long left = 1;
		long right = 0;
		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			right = Math.max(right, arr[i]);
		}
		
		while (left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = 0;
			for (int i = 0; i < K; i++) {
				cnt += (arr[i] / mid);
			}
			
			if (cnt < N) right = mid - 1;
			else left = mid + 1;
		}
		
		 System.out.println(right);
	} // end of main

} // end of class
