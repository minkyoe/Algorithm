package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2902_KMP는왜KMP일까 {

	public static void main(String[] args) throws IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String ans = "";
		
		for (int i = 0; i < str.length(); i++) {
			if (i == 0) ans += str.charAt(i);
			else if (str.charAt(i-1) == '-') {
				ans += str.charAt(i);
			}
		}

		System.out.println(ans);
	}

}
