package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2138_전구와스위치 {
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		String tmp = bf.readLine();
		int[] before = new int[N+1];
		int[] beforeCopy = new int[N+1];
		int[] after = new int[N+1];
		for (int i = 1; i <= N; i++) {
			before[i] = tmp.charAt(i-1) - '0';
			beforeCopy[i] = before[i];
		}

		tmp = bf.readLine();
		for (int i = 1; i <= N; i++) {
			after[i] = tmp.charAt(i-1) - '0';
		}
		
		
		int ans = Integer.MAX_VALUE;
		int cnt = 0;
		boolean isSame = true;
		// 1번 스위치 안누를때
		for (int i = 2; i <= N; i++) {
			if (before[i-1] == after[i-1])
				continue;
			cnt++; // 스위치 누름
			if (i == N) {
				before[i] = before[i] - 1 < 0 ? 1 : 0;
				before[i - 1] = before[i - 1] - 1 < 0 ? 1 : 0;
			} else {
				before[i] = before[i] - 1 < 0 ? 1 : 0;
				before[i - 1] = before[i - 1] - 1 < 0 ? 1 : 0;
				before[i + 1] = before[i + 1] - 1 < 0 ? 1 : 0;
			}
		}
		
		// 같은지 비교
		for (int j = 1; j <= N; j++) {
			if (before[j] != after[j]) {
				isSame = false;
				break;
			}
		}


		if (isSame) {
			ans = ans > cnt ? cnt : ans;
		}
		cnt = 0;
		isSame = true;
		
		
		// 1번 스위치 누를때
		beforeCopy[1] = beforeCopy[1] - 1 < 0 ? 1 : 0;
		beforeCopy[2] = beforeCopy[2] - 1 < 0 ? 1 : 0;
		cnt++;
		for (int i = 2; i <= N; i++) {
			if (beforeCopy[i-1] == after[i-1])
				continue;
			cnt++; // 스위치 누름
			if (i == N) {
				beforeCopy[i] = beforeCopy[i] - 1 < 0 ? 1 : 0;
				beforeCopy[i - 1] = beforeCopy[i - 1] - 1 < 0 ? 1 : 0;
			} else {
				beforeCopy[i] = beforeCopy[i] - 1 < 0 ? 1 : 0;
				beforeCopy[i - 1] = beforeCopy[i - 1] - 1 < 0 ? 1 : 0;
				beforeCopy[i + 1] = beforeCopy[i + 1] - 1 < 0 ? 1 : 0;
			}
		}

		// 같은지 비교
		for (int j = 1; j <= N; j++) {
			if (beforeCopy[j] != after[j]) {
				isSame = false;
				break;
			}
		}
		
		if (isSame) {
			ans = ans > cnt ? cnt : ans;
		} 
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(ans);
		}


	} // end of main
} // end of class
