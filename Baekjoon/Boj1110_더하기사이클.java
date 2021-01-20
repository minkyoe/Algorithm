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
				s = "0" + s;
			}
			
			String left = s.substring(1);
			String right = String.valueOf(Integer.parseInt(s.substring(0,1)) + Integer.parseInt(s.substring(1)));
			
			if (right.length() >= 2) {
				right = right.substring(1);
			}
			
			if (left.equals("0")) s = right;
			else s = left + right;
			n = Integer.parseInt(s);
			ans++;
			if (n == goal) break;
		}
		
		System.out.println(ans);
		
	} // end of main

} // end of class
