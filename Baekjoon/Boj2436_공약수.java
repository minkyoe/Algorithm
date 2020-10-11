package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2436_공약수 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int gcd = Integer.parseInt(st.nextToken());
		int lcm = Integer.parseInt(st.nextToken());
		
		lcm /= gcd;
		int hap = Integer.MAX_VALUE;
		int ansA = 0;
		int ansB = 0;
		
		for (int i = 1; i * i <= lcm; i++) {
			if (lcm % i == 0 && isSeoroso(i, lcm / i)) {
				if (hap > i * gcd + lcm / i * gcd) {
					hap = i * gcd + lcm / i * gcd;
					ansA = i * gcd;
					ansB = lcm / i * gcd;
				}
			}
		}
		
		System.out.println(ansA + " " + ansB);
	} // end of main
	
	public static boolean isSeoroso(int a, int b) {
		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (a != 0) {
			int tmp = b % a;
			b = a;
			a = tmp;
		}
		
		if (b == 1) return true;
		return false;
	}
} // end of class
