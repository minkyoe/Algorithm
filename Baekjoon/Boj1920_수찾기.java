package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {
	private static int N;
	private static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		HashSet<Integer> set = new HashSet<Integer>();
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		
		M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (set.contains(now)) System.out.println("1");
			else System.out.println("0");
		}
	} // end of main
}
