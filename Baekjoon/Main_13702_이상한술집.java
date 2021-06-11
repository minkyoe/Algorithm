import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13702_이상한술집 {

	private static int N, K;
	private static int max;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		max = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			if (arr[i] > max) max = arr[i];
		}

		int left = 0;
		int right = max;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0;
			 
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] / mid;
			}
			
			if (sum >= K) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(right);
	} // end of main

} // end of class
