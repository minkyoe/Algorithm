package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16917_양념반후라이드반 {

	private static int YANG;
	private static int HOO;
	private static int BAN;
	private static int X;
	private static int Y;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		YANG = Integer.parseInt(st.nextToken());
		HOO = Integer.parseInt(st.nextToken());
		BAN = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()); // 양념 최소 마리
		Y = Integer.parseInt(st.nextToken()); // 후라이드 최소 마리
		int ans = 0;

		int min = Math.min(X, Y);

		if (YANG + HOO > BAN * 2) {
			ans += min * BAN * 2;
			X -= min;
			Y -= min;
			
			if (X > 0) {
				if (YANG > BAN * 2) {
					ans += BAN * 2 * X;
				} else {
					ans += YANG * X;
				}
			}
			if (Y > 0) {
				if (HOO > BAN * 2) {
					ans += BAN * 2 * Y;
				} else {
					ans += HOO * Y;
				}
			}
			
		} else {
			ans = ans + YANG * X + HOO * Y;
		}

		System.out.println(ans);

	} // end of main

} // end of class
