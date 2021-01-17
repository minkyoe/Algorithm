package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_숫자카드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());

			boolean isRight = false;
			int left = 0;
			int right = N - 1;

			while (left <= right) {
				int midIdx = (left + right) / 2;
				int mid = nums[midIdx];
				if (mid < n)
					left = midIdx + 1;
				else if (mid > n)
					right = midIdx - 1;
				else {
					isRight = true;
					break;
				}
			}

			if (isRight) sb.append("1 ");
			else sb.append("0 ");
		}

		System.out.println(sb);
	} // end of main

}
