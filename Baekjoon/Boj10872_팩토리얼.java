package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10872_팩토리얼 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		if (N == 0) System.out.println(1);
		else {
			int ans = recur(1, 1);
			
			System.out.println(ans);
		}
	}

	private static int recur(int n, int num) {
		if (n == N) return num;
		
		int tmp = recur(n+1, num*(n+1));
		
		return tmp;
	}

}
