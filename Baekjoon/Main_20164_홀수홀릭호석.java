import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_20164_홀수홀릭호석 {

	private static String N;
	private static int max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = bf.readLine();
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		go(N, count(N));
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
	} // end of main

	private static void go(String str, int cnt) {
		if (str.length() >= 3) {
			for (int i = 0; i < str.length()-1; i++) {
				for (int j = i+1; j < str.length()-1; j++) {
					int a = Integer.parseInt(str.substring(0, i+1));
					int b = Integer.parseInt(str.substring(i+1, j+1));
					int c = Integer.parseInt(str.substring(j+1, str.length()));
					int sum = a + b + c;
					go(String.valueOf(sum), cnt + count(String.valueOf(sum)));
				}
			}
		}
		else if (str.length() == 2) {
			int a = (str.charAt(0)) - '0'; 
			int b = (str.charAt(1)) - '0'; 
			go(String.valueOf(a+b), cnt + count(String.valueOf(a+b)));
		}
		else {
			min = Math.min(min, cnt);
			max = Math.max(max, cnt);
		}
	}

	private static int count(String str) {
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			int num = now - '0';
			if (num % 2 != 0) ++cnt;
		}
		return cnt;
	}

} // end of class
