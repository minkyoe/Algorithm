package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2675_문자열반복 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(bf.readLine());
		
		for (int testCase = 0; testCase < tc; testCase++) {
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			String ans = "";
			for (int i = 0; i < s.length(); i++) {
				char now = s.charAt(i);
				for (int j = 0; j < cnt; j++) {
					ans += now;
				}
			}
			System.out.println(ans);
		}

	}

}
