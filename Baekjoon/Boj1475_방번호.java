package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1475_방번호 {

	private static int[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		selected = new int[10];
		
		String s = st.nextToken();
		
		for (int i = 0; i < s.length(); i++) {
			int now = s.charAt(i) - '0';
			if (now == 9) {
				if(selected[9] > selected[6]) selected[6]++;
				else selected[9]++;
			}
			else if (now == 6) {
				if(selected[6] > selected[9]) selected[9]++;
				else selected[6]++;
			}
			else {
				selected[now]++;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			ans = ans < selected[i] ? selected[i] : ans;
		}
		
		System.out.println(ans);
		
	} // end of main

}
