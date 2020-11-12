package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11648_지속 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int step = 0;
		
		if (s.length() != 1) {
			int len = s.length();
			int num = 1;
			while(true) {
				for (int i = 0; i < len; i++) {
					num *= s.charAt(i) - '0';
				}
				s = String.valueOf(num);
				len = s.length();
				num = 1;
				step++;
				if (len == 1) break;
			}
		}
		System.out.println(step);

	} // end of main

}
