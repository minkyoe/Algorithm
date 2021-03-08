import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11497_통나무건너뛰기 {

	private static int N;
	private static int[] arr;
	private static int[] arranged;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N];
			
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			arranged = new int[N];
			Arrays.sort(arr);
			
			int left = 0;
			int right = N-1;
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					arranged[left] = arr[i];
					left += 1;
				} else {
					arranged[right] = arr[i];
					right -= 1;
				}
			}
			
			int ans = Integer.MIN_VALUE;
			for (int i = 0; i < N-1; i++) {
				ans = Math.max(ans, Math.abs(arranged[i] - arranged[i+1]));
			}
			
			System.out.println(ans);
		} // end of tc
		
	} // end of main

} // end of class
