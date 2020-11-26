package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9325_얼마 {

	private static int car;
	private static int n;
	private static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= tc; i++) {
			ans = 0;
			car = Integer.parseInt(bf.readLine());
			n = Integer.parseInt(bf.readLine()); // 옵션 개수
			ans += car;
			
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
				int q = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ans += q*p;
			}
			
			System.out.println(ans);
		} // end of tc
	} // end of main

}
