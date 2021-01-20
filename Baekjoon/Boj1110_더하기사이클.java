package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110_더하기사이클 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int n = Integer.parseInt(s);
		int ans = 0;
		int goal = n;
		
		while (true) {
			if (s.length() < 2) {
				s += "0";
			}
			
			String left = s.substring(1);
			String right = String.valueOf(Integer.parseInt(s.substring(0,1)) + Integer.parseInt(s.substring(1)));
			
			if (Integer.parseInt(right) > 10) {
				right = right.substring(1);
			}
			
			s = left + right;
			n = Integer.parseInt(s);
			ans++;
//			System.out.println(left + " / " + right + " = " + n);
			if (n == goal) break;
		}
		
		System.out.println(ans);
		
	} // end of main

} // end of class
