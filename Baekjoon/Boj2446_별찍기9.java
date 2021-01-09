package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2446_별찍기9 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		recur(0, 0);
	}

	private static void recur(int cnt, int idx) {
		if (idx == N*2-1) return;
		
		for (int i = 0; i < N*2-1; i++) {
			if (i < cnt) System.out.print(" ");
			else if (i >= N*2-cnt-1) break;
			else System.out.print("*");
			
		}
		System.out.println();
		if (idx + 1 >= N) recur(cnt - 1, idx + 1);
		else recur(cnt + 1, idx + 1);
		return;
	}

}
