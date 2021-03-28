import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12871_무한문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		String t = bf.readLine();
		
		if (s.length() == t.length()) {
			if (s.equals(t)) System.out.println(1);
			else System.out.println(0);
		}
		else {
			int slen = s.length();
			int tlen = t.length();
			
			// 두 문자열 길이의 최소공배수만큼 길이를 늘림 
			int lcm = LCM(s.length(), t.length());
			String newS = "";
			String newT = "";
			
			for (int i = slen; i <= lcm; i += slen) {
				newS += s;
			}
			for (int i = tlen; i <= lcm; i += tlen) {
				newT += t;
			}
			
			if (newS.equals(newT)) System.out.println(1);
			else System.out.println(0);
		}
	} // end of main

	private static int LCM(int a, int b) {
		if (a > b) return a * b / GCD(a, b);
		else return a * b / GCD(b, a);
	}

	private static int GCD(int a, int b) {
		if (b == 0) return a;
		return GCD(b, a % b); 
	}
	
} // end of class
