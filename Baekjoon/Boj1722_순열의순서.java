package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1722_순열의순서 {
	private static int N;
	private static long k;
	private static long  order;
	private static int[] nums;
	private static long[] factorial;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		k = Integer.parseInt(st.nextToken());
		nums = new int[N];
		factorial = new long[21];
		
		// 20! 까지 구해놓기
		factorial[0] = 1;
		factorial[1] = 1;
		for (int i = 2; i <= 20; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		if (k == 1) { // 순서 -> 숫자
			order = Long.parseLong(st.nextToken());
			int[] result = new int[N];
			boolean[] visited = new boolean[N+1]; // 각 자리마다 1~N 중복 되지 않게
			for (int i = 0; i < N; i++) { // 자리 인덱스
				for (int j = 1; j <= N; j++) { // 1~N
					if (visited[j]) continue;
					if (factorial[N-i-1] < order) order -= factorial[N-i-1];
					else {
						result[i] = j;
						visited[j] = true;
						break;
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				System.out.print(result[i] + " ");
			}
		} else { // 숫자 -> 순서
			long sum = 1; // 순서
			int idx = 0;
			boolean[] visited = new boolean[N+1]; // 각 자리마다 1~N 중복 되지 않게
			while (st.hasMoreTokens()) {
				nums[idx++] = Integer.parseInt(st.nextToken());
			}
			
			int size = idx;
			for (int i = 0; i < size; i++) {
				int now = nums[i];
				int index = i;
				long less = 0;
				visited[now] = true;
				for (int j = 1; j <= N; j++) {
					if (now > j && !visited[j]) {
						less++;
					}
				}
				
				sum += factorial[size-index-1] * less;
			}
			System.out.println(sum);
		}
	} // end of main
}
