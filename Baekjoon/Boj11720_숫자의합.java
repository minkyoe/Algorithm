package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11720_숫자의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		bf.readLine();
		String s = bf.readLine();
		int ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			ans += s.charAt(i) - '0';
		}
		System.out.println(ans);
	}

}
