package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5622_다이얼 {
	static int[] dialTime = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
	public static void main(String[] args) throws IOException {	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		int ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			ans += dialTime[(s.charAt(i) - '0') - 17];
		}
		System.out.println(ans);
	} // end of main

}
