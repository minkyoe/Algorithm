package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		
		StringTokenizer st = new StringTokenizer(str, "-");
		int ans = 0;
		boolean isFirst = true;
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			
			// 맨 처음에 나오는 숫자
			if (isFirst) {
				if (token.contains("+")) {
					int sum = 0;
					StringTokenizer st2 = new StringTokenizer(token, "+");
					while(st2.hasMoreTokens()) {
						sum += Integer.parseInt(st2.nextToken());
					}
					ans += sum;
				} else {
					ans += Integer.parseInt(token);
				}
				isFirst = false;
				continue;
			}
			
			if (token.contains("+")) {
				int sum = 0;
				StringTokenizer st2 = new StringTokenizer(token, "+");
				while(st2.hasMoreTokens()) {
					sum += Integer.parseInt(st2.nextToken());
				}
				ans -= sum;
			} else {
				ans -= Integer.parseInt(token);
			}
		}
		
		System.out.println(ans);

	} // end of main

} // end of class
