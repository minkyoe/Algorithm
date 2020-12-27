package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908_상수 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		String a = st.nextToken();
		String b = st.nextToken();
		
		String tmpA = "";
		for (int i = a.length()-1; i >= 0; i--) {
			tmpA += a.charAt(i);
		}
		int A = Integer.parseInt(tmpA);
		
		String tmpB = "";
		for (int i = b.length()-1; i >= 0; i--) {
			tmpB += b.charAt(i);
		}
		int B = Integer.parseInt(tmpB);
		
		if (A > B) System.out.println(A);
		else System.out.println(B);

	}

}
