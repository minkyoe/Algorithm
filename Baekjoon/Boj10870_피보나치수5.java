package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10870_피보나치수5 {

	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		
		if (N == 0) {
			System.out.println("0");
		} else if (N == 1) {
			System.out.println("1");
		} else {
			System.out.println(recur(1, 1, 2));
		}
		
		

	}

	private static int recur(int before, int num, int cnt) {
		if (cnt == N) {
			return num;
		}
		return recur(num, before+num, cnt+1);
	}

}
