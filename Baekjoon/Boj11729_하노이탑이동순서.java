package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11729_하노이탑이동순서 {

	private static int cnt;
	private static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		cnt = 0;
		sb = new StringBuilder();
		recur(N, 1, 2, 3);
		sb.insert(0, cnt+"\n");
		System.out.println(sb);
	}

	private static void recur(int num, int start, int mid, int end) {
		++cnt;
		if (num == 1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		recur(num-1, start, end, mid);
		sb.append(start + " " + end + "\n");
		recur(num-1, mid, start, end);
		
	}

}
